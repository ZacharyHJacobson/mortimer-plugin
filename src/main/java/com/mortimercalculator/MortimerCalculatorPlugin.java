package com.mortimercalculator;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

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

	 public class TaskStats{
		int assign_min;
		int assign_max;
		int travel_time;
		int kills_per_hour;
		int superiors_per_heart;

		public TaskStats(String task_name)
		{
			switch(task_name)
			{
				case "Gargoyles":
					assign_min = 120;
					assign_max = 180;
					travel_time = 17;
					kills_per_hour = 380;
					superiors_per_heart = 520;
			}
		}
	}

	private final int HOUR = 6000;

	@Override
	protected void startUp() throws Exception
	{
		String task_name = "Gargoyles";		//! get from master
		int length_modifier = 0;			//! get from master
		int drop_modifier = 0;				//!get from master
		TaskStats task_stats = new TaskStats(task_name);
		float ticks_wasted = calcTicksWasted(task_stats, 0, 0, 0, false);	//! modifiers
		//! compare the three
        log.debug("ticks wasted: {}", ticks_wasted);	//! display output highlighting one of three UI spots
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
		log.debug("tl: " + number_killed_with_bracelet + ", tct: " + task_completion_time + ", tph: " + tasks_per_heart + ", ttph: " + task_time_per_heart);
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

	@Provides
    MortimerCalculatorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MortimerCalculatorConfig.class);
	}
}
