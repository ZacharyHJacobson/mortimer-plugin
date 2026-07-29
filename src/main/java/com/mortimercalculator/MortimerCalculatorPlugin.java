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

	public class TaskStats
	{
		int assign_min;
		int assign_max;
		int travel_time;
		int kills_per_hour;
		int superiors_per_heart;

		public TaskStats(String task_name)
		{
			switch(task_name)
			{
				case "Crawling Hands":
					assign_min = 35;
					assign_max = 50;
					travel_time = 7;
					kills_per_hour = 1565;
					superiors_per_heart = 1376;
					break;
				case "Cave Crawlers":
					assign_min = 35;
					assign_max = 50;
					travel_time = 5;
					kills_per_hour = 1384;
					superiors_per_heart = 1336;
					break;
				case "Banshees":
					assign_min = 35;
					assign_max = 50;
					travel_time = 27;
					kills_per_hour = 1333;
					superiors_per_heart = 1288;
					break;
				case "Rockslugs":
					assign_min = 35;
					assign_max = 50;
					travel_time = 32;
					kills_per_hour = 1125;
					superiors_per_heart = 1240;
					break;
				case "Cockatrice":
					assign_min = 35;
					assign_max = 50;
					travel_time = 39;
					kills_per_hour = 818;
					superiors_per_heart = 1192;
					break;
				case "Pyrefiends":
					assign_min = 35;
					assign_max = 50;
					travel_time = 21;
					kills_per_hour = 857;
					superiors_per_heart = 1144;
					break;
				case "Infernal Mages":
					assign_min = 35;
					assign_max = 50;
					travel_time = 47;
					kills_per_hour = 642;
					superiors_per_heart = 960;
					break;
				case "Bloodveld":
					assign_min = 120;
					assign_max = 180;
					travel_time = 45;
					kills_per_hour = 600;
					superiors_per_heart = 896;
					break;
				case "Gryphons":
					assign_min = 80;
					assign_max = 120;
					travel_time = 56;
					kills_per_hour = 600;
					superiors_per_heart = 888;
					break;
				case "Jellies":
					assign_min = 80;
					assign_max = 120;
					travel_time = 44;
					kills_per_hour = 840;
					superiors_per_heart = 872;
					break;
				case "Custodian Stalkers":
					assign_min = 80;
					assign_max = 120;
					travel_time = 86;
					kills_per_hour = 440;
					superiors_per_heart = 504;
					break;
				case "Turoth":
					assign_min = 80;
					assign_max = 120;
					travel_time = 50;
					kills_per_hour = 383;
					superiors_per_heart = 832;
					break;
				case "Warped Creatures":
					assign_min = 80;
					assign_max = 120;
					travel_time = 70;
					kills_per_hour = 457;
					superiors_per_heart = 816;
					break;
				case "Cave Horrors":
					assign_min = 80;
					assign_max = 120;
					travel_time = 75;
					kills_per_hour = 610;
					superiors_per_heart = 784;
					break;
				case "Aberrant Spectres":
					assign_min = 80;
					assign_max = 120;
					travel_time = 34;
					kills_per_hour = 500;
					superiors_per_heart = 760;
					break;
				case "Basilisks":
					assign_min = 40;
					assign_max = 60;
					travel_time = 38;
					kills_per_hour = 450;
					superiors_per_heart = 1024;
					break;
				case "Wyrms":
					assign_min = 80;
					assign_max = 120;
					travel_time = 45;
					kills_per_hour = 250;
					superiors_per_heart = 728;
					break;
				case "Dust Devils":
					assign_min = 120;
					assign_max = 180;
					travel_time = 49;
					kills_per_hour = 780;
					superiors_per_heart = 680;
					break;
				case "Kurask":
					assign_min = 40;
					assign_max = 60;
					travel_time = 70;
					kills_per_hour = 290;
					superiors_per_heart = 600;
					break;
				case "Venators":
					assign_min = 120;
					assign_max = 180;
					travel_time = 60;
					kills_per_hour = 107;
					superiors_per_heart = 536;
				case "Gargoyles":
					assign_min = 120;
					assign_max = 180;
					travel_time = 17;
					kills_per_hour = 380;
					superiors_per_heart = 520;
					break;
				case "Aquanites":
					assign_min = 40;
					assign_max = 60;
					travel_time = 50;
					kills_per_hour = 200;
					superiors_per_heart = 472;
					break;
				case "Nechryael":
					assign_min = 150;
					assign_max = 200;
					travel_time = 42;
					kills_per_hour = 520;
					superiors_per_heart = 440;
					break;
				case "Drakes":
					assign_min = 40;
					assign_max = 60;
					travel_time = 55;
					kills_per_hour = 155;
					superiors_per_heart = 368;
					break;
				case "Abyssal Demons":
					assign_min = 120;
					assign_max = 180;
					travel_time = 47;
					kills_per_hour = 650;
					superiors_per_heart = 352;
					break;
				case "Dark Beasts":
					assign_min = 40;
					assign_max = 60;
					travel_time = 17;
					kills_per_hour = 205;
					superiors_per_heart = 256;
					break;
				case "Araxytes":
					assign_min = 120;
					assign_max = 180;
					travel_time = 20;
					kills_per_hour = 769;
					superiors_per_heart = 224;
					break;
				case "Smoke Devils":
					assign_min = 80;
					assign_max = 120;
					travel_time = 50;
					kills_per_hour = 800;
					superiors_per_heart = 200;
					break;
				case "Hydras":
					assign_min = 150;
					assign_max = 200;
					travel_time = 45;
					kills_per_hour = 149;
					superiors_per_heart = 160;
					break;
			}
		}
	}

	private final int HOUR = 6000;

	@Override
	protected void startUp() throws Exception
	{
		panel = injector.getInstance(MortimerCalculatorPanel.class);
		navButton = NavigationButton.builder().tooltip("Mortimer Calculator").icon(ImageUtil.loadImageResource(getClass(), "/mortpanel.png")).panel(panel).build();
		clientToolbar.addNavigation(navButton);

		List<Float> ticks_wasted = new ArrayList<Float>();
		List<String> task_names = new ArrayList<String>();
		task_names.add("Gargoyles");		//! get from master
		int length_modifier = 0;			//! get from master
		int drop_modifier = 0;				//!get from master
		TaskStats task_stats = new TaskStats(task_names.get(0));
		ticks_wasted.add(calcTicksWasted(task_stats, 0, 0, 0, false));	//! modifiers
		//! compare the three
		log.debug("ticks wasted: {}", ticks_wasted.get(0));	//! display output highlighting one of three UI spots
		//! give skip advice based on number assigned
	}

	private float calcTicksWasted(TaskStats task_stats, int length_modifier, int drop_modifier, float number_assigned, boolean slaughter)
	{
		if(number_assigned == 0) number_assigned = killsPerTask(task_stats, length_modifier);
		float number_killed_with_bracelet = applyBracelet(number_assigned, slaughter);
		int task_completion_time = timePerTask(task_stats, number_killed_with_bracelet);
		float tasks_per_heart = tasksPerHeart(task_stats.superiors_per_heart, number_killed_with_bracelet, drop_modifier);
		int time_per_heart = config.timeToHeart();
		float task_time_per_heart = task_completion_time * tasks_per_heart;
		if((task_time_per_heart < time_per_heart) && (!slaughter))
		{
			return calcTicksWasted(task_stats, length_modifier, drop_modifier, number_assigned, true);
		}
		return(task_completion_time * (1 - (time_per_heart/task_time_per_heart)));
	}

	private float killsPerTask(TaskStats task_stats, int length_modifier)
	{
		float task_length = (float)(task_stats.assign_min + task_stats.assign_max)/2;
		task_length += length_modifier;
		return task_length;
	}

	private float applyBracelet(float number_assigned, boolean slaughter)
	{
		return number_assigned * (float)((slaughter) ? (4.0/3.0) : (.8));
	}

	private int timePerTask(TaskStats task_stats, float number_killed_with_bracelet)
	{
		int time = config.prepTime() + task_stats.travel_time;	//! let uses input eventually
		time += (int)(number_killed_with_bracelet/task_stats.kills_per_hour * HOUR);	//! let uses input eventually
		return time;
	}

	private float tasksPerHeart(int base_superiors_per_heart, float number_killed_with_bracelet, int drop_modifier)
	{
		int kills_per_superior = (config.eliteCas()) ? 150 : 200;
		float superiors_per_task = number_killed_with_bracelet/kills_per_superior;
		float modified_superiors_per_heart = (float)((base_superiors_per_heart * 100.0) / (100.0 + drop_modifier));
		return modified_superiors_per_heart/superiors_per_task;
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged)
	{
		if(configChanged.getKey().equals("showTimeWasted"))
		{
			panel.update();
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
