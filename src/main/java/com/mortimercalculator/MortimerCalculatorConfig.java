package com.mortimercalculator;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("MortimerCalculator")
public interface MortimerCalculatorConfig extends Config
{
	@ConfigSection(name = "Settings", description = "General use settings", position = -100)
	String settingsSection = "Settings";

	@ConfigItem(
		position = 0,
		section = settingsSection,
		keyName = "eliteCas",
		name = "Elite CAs",
		description = "Enable if Elite or higher Combat Achievement rewards have been claimed"
	)
	default boolean eliteCas()
	{
		return true;
	}

	@ConfigItem(
			position = 0,
			section = settingsSection,
			keyName = "prepTime",
			name = "Ticks to prepare for new task",
			description = "Total ticks between finishing the previous task and being geared for the new one, does NOT include travel time to task location"
	)
	default int prepTime()
	{
		return 30;
	}

	@ConfigSection(name = "Settings (Advanced)", description = "Change values used for calculations", position = -10, closedByDefault = true)
	String advancedSettingsSection = "Settings (Advanced)";

	@ConfigItem(
			position = 0,
			section = advancedSettingsSection,
			keyName = "timeToHeart",
			name = "Time to heart",
			description = "Estimated ticks to obtain an Imbued Heart"
	)
	default int timeToHeart()
	{
		return 402161;
	}

	@ConfigItem(
			position = 1,
			section = advancedSettingsSection,
			keyName = "showTimeWasted",
			name = "Show time wasted per task",
			description = "Show time wasted per task, the metric used for choosing which is the best (lower is better)"
	)
	default boolean showTimeWasted()
	{
		return false;
	}

	/*@ConfigSection(name = "Venators (Advanced)", description = "Change values used for Venators", position = 1, closedByDefault = true)
	String venatorsSection = "Venators (Advanced)";

	@ConfigItem(
			position = 0,
			section = venatorsSection,
			keyName = "zeroTimeVenators",
			name = "0-time Venators",
			description =  "Enable if you would kill Venators without the Heart chance"
	)
	default boolean zeroTimeVenators()
	{
		return false;
	}*/
}
