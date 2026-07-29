package com.mortimercalculator;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

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

	@Getter(AccessLevel.PACKAGE)
	private MortimerCalculatorPanel panel;

	@Getter(AccessLevel.PACKAGE)
	private NavigationButton navButton;

	@Inject
	private ClientToolbar clientToolbar;

	@Override
	protected void startUp() throws Exception
	{
		panel = injector.getInstance(MortimerCalculatorPanel.class);
		navButton = NavigationButton.builder().tooltip("Mortimer Calculator").icon(ImageUtil.loadImageResource(getClass(), "/mortpanel.png")).panel(panel).build();
		clientToolbar.addNavigation(navButton);

		List<String> ticks_wasted = new ArrayList<String>();
		List<String> task_names = new ArrayList<String>();
		task_names.add("Gargoyles");		//! get from master
		int length_modifier = 0;			//! get from master
		int drop_modifier = 0;				//!get from master
		//! compare the three
		//! modifiers
		//! display output highlighting one of three UI spots
		//! give skip advice based on number assigned
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		panel.update();
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
