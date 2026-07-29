package com.mortimercalculator;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.ComponentID;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@PluginDescriptor(
		name = "Mortimer Calculator"
)
public class MortimerCalculatorPlugin extends Plugin
{
	public int best_rating_index = -1;
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

	private boolean in_range = false;
	public boolean mortimer_open = false;
	public Rectangle[] rectangles = new Rectangle[3];

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(mortimerCalculatorOverlay);
		panel = injector.getInstance(MortimerCalculatorPanel.class);
		navButton = NavigationButton.builder().tooltip("Mortimer Calculator").icon(ImageUtil.loadImageResource(getClass(), "/mortpanel.png")).panel(panel).build();
		clientToolbar.addNavigation(navButton);

		//! display output highlighting one of three UI spots
		//! give skip advice based on number assigned
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		panel.update();
	}

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		mortimer_open = false;
		Player player = client.getLocalPlayer();
		if(player != null)
		{
			boolean now_in_range = player.getWorldLocation().distanceTo(new WorldPoint(2590, 8613, 0)) < 5;
			if(!in_range)
			{
				Widget chatWidget = client.getWidget(15138820);
				if((chatWidget != null)&&(Objects.equals(chatWidget.getText(), "Mortimer"))) now_in_range = true;
			}
			if((!in_range) && (now_in_range))
			{
				SwingUtilities.invokeLater(() -> clientToolbar.openPanel(navButton));
			}
			in_range = now_in_range;
			//check if dialog open
			final Widget task_widget = client.getWidget(15466499);
			if(task_widget != null)
			{
				//Id	15138820
				mortimer_open = true;
				Widget[] subwidgets = task_widget.getDynamicChildren();
				int matches = 0;
				for(int x = 1; x < subwidgets.length- 4; x++)
				{
					if(subwidgets[x].getText().contains("Amount: "))
					{
						panel.update_task(matches,
								subwidgets[x-1].getText().split(">")[1],
								subwidgets[x+4].getText().substring(subwidgets[x+4].getText().indexOf(" ") + 1),
								Integer.parseInt(subwidgets[x+4].getText().split(" ")[0].split("%")[0]));
						rectangles[matches] = subwidgets[x-2].getBounds();
						matches += 1;
					}
				}
				panel.update();
			}
		}
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
