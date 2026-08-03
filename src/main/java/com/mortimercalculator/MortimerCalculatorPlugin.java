package com.mortimercalculator;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;

@Slf4j
@PluginDescriptor(
		name = "Mortimer Calculator"
)
public class MortimerCalculatorPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private MortimerCalculatorConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MortimerCalculatorOverlay mortimerCalculatorOverlay;

	@Getter(AccessLevel.PACKAGE)
	private MortimerCalculatorPanel panel;

	@Getter(AccessLevel.PACKAGE)
	private NavigationButton navButton;

	@Inject
	private ClientToolbar clientToolbar;

	boolean mortimer_open = false;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(mortimerCalculatorOverlay);
		panel = injector.getInstance(MortimerCalculatorPanel.class);
		navButton = NavigationButton.builder().tooltip("Mortimer Calculator").icon(ImageUtil.loadImageResource(getClass(), "/mortpanel.png")).panel(panel).build();
		updateNavButton();
		//! give skip advice based on number assigned
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged ignoredConfigChanged)
	{
		updateNavButton();
		panel.update();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded ignoredEvent)
	{
		update();
	}

	/**
	 * update mortimer_open boolean and hide nav button if setting to do so is on, public for overlay to call
	 */
	public void mortimerClosed()
	{
		mortimer_open = false;
		updateNavButton();
	}

	/**
	 * remove nav panel button if Mortimer's UI isn't present and the hide when away setting is on, otherwise restore
	 */
	public void updateNavButton()
	{
		if(!mortimer_open && config.hideWhenAway()) clientToolbar.removeNavigation(navButton);
		if(!config.hideWhenAway()) clientToolbar.addNavigation(navButton);
	}

	/**
	 * check if Mortimer's UI is present, update overlay if it is, and update nav button either way
	 */
	public void update()
	{
		mortimer_open = false;
		Player player = client.getLocalPlayer();
		if(player != null)
		{
			final Widget task_widget = client.getWidget(MortimerConstants.TASK_WIDGET_ID);
            if (task_widget != null && !task_widget.isHidden()) {
                clientToolbar.addNavigation(navButton);
                SwingUtilities.invokeLater(() -> clientToolbar.openPanel(navButton));
                mortimer_open = true;
                updateOverlay(task_widget);
            }
        }
		updateNavButton();
	}

	/**
	 * update the overlay with the widget for the best available Mortimer task
	 * @param task_widget parent Widget for the components of Mortimer's UI
	 */
	private void updateOverlay(Widget task_widget)
	{
		Widget[] subwidgets = task_widget.getDynamicChildren();
		Widget[] task_widgets = new Widget[3];
		int matches = 0;
		for(int x = 1; x < subwidgets.length- 4; x++)
		{
			// quantity subwidget is one index after the task name and four subwidgets before the modifier subwidget
			if(subwidgets[x].getText().contains("Amount: "))
			{
				panel.update_task(matches,
						subwidgets[x-1].getText().split(">")[1],
						Integer.parseInt(subwidgets[x].getText().split("Amount: ")[1].split(" to ")[0]),
						Integer.parseInt(subwidgets[x].getText().split(" to ")[1]),
						subwidgets[x+4].getText().substring(subwidgets[x+4].getText().indexOf(" ") + 1),
						Integer.parseInt(subwidgets[x+4].getText().split(" ")[0].split("%")[0]));
				task_widgets[matches] = subwidgets[x-2];
				matches += 1;
			}
		}
		Widget best_task_widget = task_widgets[panel.update()];
		mortimerCalculatorOverlay.updateTaskWidget(best_task_widget);
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
	}

	@Provides
	MortimerCalculatorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MortimerCalculatorConfig.class);
	}
}
