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
			position = 1,
			section = settingsSection,
			keyName = "prepTime",
			name = "Ticks until geared",
			description = "Total ticks between finishing the previous task and being geared for the new one, does NOT include travel time to task location"
	)
	default int prepTime()
	{
		return 30;
	}
	@ConfigItem(
			position = 2,
			section = settingsSection,
			keyName = "hideWhenAway",
			name = "Hide when away",
			description = "Hide side panel when task window is closed"
	)
	default boolean hideWhenAway()
	{
		return true;
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
		return 393051;
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

	@ConfigSection(name = "Aberrant Spectres (Advanced)", description = "Change values used for Aberrant Spectres", position = 1, closedByDefault = true)
	String aberrantSpectresSection = "Aberrant Spectres (Advanced)";
	@ConfigItem(
			position = 1,
			section = aberrantSpectresSection,
			keyName = "aberrantSpectresTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int aberrantSpectresTravelTime() {return 34;}
	@ConfigItem(
			position = 2,
			section = aberrantSpectresSection,
			keyName = "aberrantSpectresKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int aberrantSpectresKPH() {return 500;}

	@ConfigSection(name = "Abyssal Demons (Advanced)", description = "Change values used for Abyssal Demons", position = 1, closedByDefault = true)
	String abyssalDemonsSection = "Abyssal Demons (Advanced)";
	@ConfigItem(
			position = 1,
			section = abyssalDemonsSection,
			keyName = "abyssalDemonsTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int abyssalDemonsTravelTime() {return 47;}
	@ConfigItem(
			position = 2,
			section = abyssalDemonsSection,
			keyName = "abyssalDemonsKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int abyssalDemonsKPH() {return 650;}

	@ConfigSection(name = "Aquanites (Advanced)", description = "Change values used for Aquanites", position = 1, closedByDefault = true)
	String aquanitesSection = "Aquanites (Advanced)";
	@ConfigItem(
			position = 1,
			section = aquanitesSection,
			keyName = "aquanitesTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int aquanitesTravelTime() {return 50;}
	@ConfigItem(
			position = 2,
			section = aquanitesSection,
			keyName = "aquanitesKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int aquanitesKPH() {return 200;}

	@ConfigSection(name = "Araxytes (Advanced)", description = "Change values used for Araxytes", position = 1, closedByDefault = true)
	String araxytesSection = "Araxytes (Advanced)";
	@ConfigItem(
			position = 1,
			section = araxytesSection,
			keyName = "araxytesTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int araxytesTravelTime() {return 20;}
	@ConfigItem(
			position = 2,
			section = araxytesSection,
			keyName = "araxytesKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int araxytesKPH() {return 769;}

	@ConfigSection(name = "Banshees (Advanced)", description = "Change values used for Banshees", position = 1, closedByDefault = true)
	String bansheesSection = "Banshees (Advanced)";
	@ConfigItem(
			position = 1,
			section = bansheesSection,
			keyName = "bansheesTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int bansheesTravelTime() {return 27;}
	@ConfigItem(
			position = 2,
			section = bansheesSection,
			keyName = "bansheesKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int bansheesKPH() {return 1333;}

	@ConfigSection(name = "Basilisks (Advanced)", description = "Change values used for Basilisks", position = 1, closedByDefault = true)
	String basilisksSection = "Basilisks (Advanced)";
	@ConfigItem(
			position = 1,
			section = basilisksSection,
			keyName = "basilisksTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int basilisksTravelTime() {return 38;}
	@ConfigItem(
			position = 2,
			section = basilisksSection,
			keyName = "basilisksKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int basilisksKPH() {return 450;}

	@ConfigSection(name = "Bloodveld (Advanced)", description = "Change values used for Bloodveld", position = 1, closedByDefault = true)
	String bloodveldSection = "Bloodveld (Advanced)";
	@ConfigItem(
			position = 1,
			section = bloodveldSection,
			keyName = "bloodveldTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int bloodveldTravelTime() {return 45;}
	@ConfigItem(
			position = 2,
			section = bloodveldSection,
			keyName = "bloodveldKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int bloodveldKPH() {return 600;}

	@ConfigSection(name = "Cave Crawlers (Advanced)", description = "Change values used for Cave Crawlers", position = 1, closedByDefault = true)
	String caveCrawlersSection = "Cave Crawlers (Advanced)";
	@ConfigItem(
			position = 1,
			section = caveCrawlersSection,
			keyName = "caveCrawlersTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int caveCrawlersTravelTime() {return 5;}
	@ConfigItem(
			position = 2,
			section = caveCrawlersSection,
			keyName = "caveCrawlersKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int caveCrawlersKPH() {return 1384;}

	@ConfigSection(name = "Cave Horrors (Advanced)", description = "Change values used for Cave Horrors", position = 1, closedByDefault = true)
	String caveHorrorsSection = "Cave Horrors (Advanced)";
	@ConfigItem(
			position = 1,
			section = caveHorrorsSection,
			keyName = "caveHorrorsTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int caveHorrorsTravelTime() {return 75;}
	@ConfigItem(
			position = 2,
			section = caveHorrorsSection,
			keyName = "caveHorrorsKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int caveHorrorsKPH() {return 610;}

	@ConfigSection(name = "Cockatrice (Advanced)", description = "Change values used for Cockatrice", position = 1, closedByDefault = true)
	String cockatriceSection = "Cockatrice (Advanced)";
	@ConfigItem(
			position = 1,
			section = cockatriceSection,
			keyName = "cockatriceTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int cockatriceTravelTime() {return 39;}
	@ConfigItem(
			position = 2,
			section = cockatriceSection,
			keyName = "cockatriceKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int cockatriceKPH() {return 818;}

	@ConfigSection(name = "Crawling Hands (Advanced)", description = "Change values used for Crawling Hands", position = 1, closedByDefault = true)
	String crawlingHandsSection = "Crawling Hands (Advanced)";
	@ConfigItem(
			position = 1,
			section = crawlingHandsSection,
			keyName = "crawlingHandsTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int crawlingHandsTravelTime() {return 7;}
	@ConfigItem(
			position = 2,
			section = crawlingHandsSection,
			keyName = "crawlingHandsKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int crawlingHandsKPH() {return 1565;}

	@ConfigSection(name = "Custodian Stalkers (Advanced)", description = "Change values used for Custodian Stalkers", position = 1, closedByDefault = true)
	String custodianStalkersSection = "Custodian Stalkers (Advanced)";
	@ConfigItem(
			position = 1,
			section = custodianStalkersSection,
			keyName = "custodianStalkersTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int custodianStalkersTravelTime() {return 86;}
	@ConfigItem(
			position = 2,
			section = custodianStalkersSection,
			keyName = "custodianStalkersKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int custodianStalkersKPH() {return 440;}

	@ConfigSection(name = "Dark Beasts (Advanced)", description = "Change values used for Dark Beasts", position = 1, closedByDefault = true)
	String darkBeastsSection = "Dark Beasts (Advanced)";
	@ConfigItem(
			position = 1,
			section = darkBeastsSection,
			keyName = "darkBeastsTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int darkBeastsTravelTime() {return 17;}
	@ConfigItem(
			position = 2,
			section = darkBeastsSection,
			keyName = "darkBeastsKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int darkBeastsKPH() {return 205;}

	@ConfigSection(name = "Drakes (Advanced)", description = "Change values used for Drakes", position = 1, closedByDefault = true)
	String drakesSection = "Drakes (Advanced)";
	@ConfigItem(
			position = 1,
			section = drakesSection,
			keyName = "drakesTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int drakesTravelTime() {return 55;}
	@ConfigItem(
			position = 2,
			section = drakesSection,
			keyName = "drakesKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int drakesKPH() {return 155;}

	@ConfigSection(name = "Dust Devils (Advanced)", description = "Change values used for Dust Devils", position = 1, closedByDefault = true)
	String dustDevilsSection = "Dust Devils (Advanced)";
	@ConfigItem(
			position = 1,
			section = dustDevilsSection,
			keyName = "dustDevilsTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int dustDevilsTravelTime() {return 49;}
	@ConfigItem(
			position = 2,
			section = dustDevilsSection,
			keyName = "dustDevilsKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int dustDevilsKPH() {return 780;}

	@ConfigSection(name = "Gargoyles (Advanced)", description = "Change values used for Gargoyles", position = 1, closedByDefault = true)
	String gargoylesSection = "Gargoyles (Advanced)";
	@ConfigItem(
			position = 1,
			section = gargoylesSection,
			keyName = "gargoylesTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int gargoylesTravelTime() {return 17;}
	@ConfigItem(
			position = 2,
			section = gargoylesSection,
			keyName = "gargoylesKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int gargoylesKPH() {return 380;}

	@ConfigSection(name = "Gryphons (Advanced)", description = "Change values used for Gryphons", position = 1, closedByDefault = true)
	String gryphonsSection = "Gryphons (Advanced)";
	@ConfigItem(
			position = 1,
			section = gryphonsSection,
			keyName = "gryphonsTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int gryphonsTravelTime() {return 56;}
	@ConfigItem(
			position = 2,
			section = gryphonsSection,
			keyName = "gryphonsKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int gryphonsKPH() {return 600;}

	@ConfigSection(name = "Hydras (Advanced)", description = "Change values used for Hydras", position = 1, closedByDefault = true)
	String hydrasSection = "Hydras (Advanced)";
	@ConfigItem(
			position = 1,
			section = hydrasSection,
			keyName = "hydrasTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int hydrasTravelTime() {return 45;}
	@ConfigItem(
			position = 2,
			section = hydrasSection,
			keyName = "hydrasKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int hydrasKPH() {return 149;}

	@ConfigSection(name = "Infernal Mages (Advanced)", description = "Change values used for Infernal Mages", position = 1, closedByDefault = true)
	String infernalMagesSection = "Infernal Mages (Advanced)";
	@ConfigItem(
			position = 1,
			section = infernalMagesSection,
			keyName = "infernalMagesTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int infernalMagesTravelTime() {return 47;}
	@ConfigItem(
			position = 2,
			section = infernalMagesSection,
			keyName = "infernalMagesKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int infernalMagesKPH() {return 642;}

	@ConfigSection(name = "Jellies (Advanced)", description = "Change values used for Jellies", position = 1, closedByDefault = true)
	String jelliesSection = "Jellies (Advanced)";
	@ConfigItem(
			position = 1,
			section = jelliesSection,
			keyName = "jelliesTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int jelliesTravelTime() {return 44;}
	@ConfigItem(
			position = 2,
			section = jelliesSection,
			keyName = "jelliesKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int jelliesKPH() {return 840;}

	@ConfigSection(name = "Kurask (Advanced)", description = "Change values used for Kurask", position = 1, closedByDefault = true)
	String kuraskSection = "Kurask (Advanced)";
	@ConfigItem(
			position = 1,
			section = kuraskSection,
			keyName = "kuraskTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int kuraskTravelTime() {return 70;}
	@ConfigItem(
			position = 2,
			section = kuraskSection,
			keyName = "kuraskKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int kuraskKPH() {return 290;}

	@ConfigSection(name = "Nechryael (Advanced)", description = "Change values used for Nechryael", position = 1, closedByDefault = true)
	String nechryaelSection = "Nechryael (Advanced)";
	@ConfigItem(
			position = 1,
			section = nechryaelSection,
			keyName = "nechryaelTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int nechryaelTravelTime() {return 42;}
	@ConfigItem(
			position = 2,
			section = nechryaelSection,
			keyName = "nechryaelKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int nechryaelKPH() {return 520;}

	@ConfigSection(name = "Pyrefiends (Advanced)", description = "Change values used for Pyrefiends", position = 1, closedByDefault = true)
	String pyrefiendsSection = "Pyrefiends (Advanced)";
	@ConfigItem(
			position = 1,
			section = pyrefiendsSection,
			keyName = "pyrefiendsTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int pyrefiendsTravelTime() {return 21;}
	@ConfigItem(
			position = 2,
			section = pyrefiendsSection,
			keyName = "pyrefiendsKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int pyrefiendsKPH() {return 857;}

	@ConfigSection(name = "Rockslugs (Advanced)", description = "Change values used for Rockslugs", position = 1, closedByDefault = true)
	String rockslugsSection = "Rockslugs (Advanced)";
	@ConfigItem(
			position = 1,
			section = rockslugsSection,
			keyName = "rockslugsTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int rockslugsTravelTime() {return 32;}
	@ConfigItem(
			position = 2,
			section = rockslugsSection,
			keyName = "rockslugsKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int rockslugsKPH() {return 1125;}

	@ConfigSection(name = "Smoke Devils (Advanced)", description = "Change values used for Smoke Devils", position = 1, closedByDefault = true)
	String smokeDevilsSection = "Smoke Devils (Advanced)";
	@ConfigItem(
			position = 1,
			section = smokeDevilsSection,
			keyName = "smokeDevilsTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int smokeDevilsTravelTime() {return 50;}
	@ConfigItem(
			position = 2,
			section = smokeDevilsSection,
			keyName = "smokeDevilsKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int smokeDevilsKPH() {return 800;}

	@ConfigSection(name = "Turoth (Advanced)", description = "Change values used for Turoth", position = 1, closedByDefault = true)
	String turothSection = "Turoth (Advanced)";
	@ConfigItem(
			position = 1,
			section = turothSection,
			keyName = "turothTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int turothTravelTime() {return 50;}
	@ConfigItem(
			position = 2,
			section = turothSection,
			keyName = "turothKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int turothKPH() {return 383;}

	@ConfigSection(name = "Venators (Advanced)", description = "Change values used for Venators", position = 2, closedByDefault = true)
	String venatorsSection = "Venators (Advanced)";
	/*@ConfigItem(
			position = 0,
			section = venatorsSection,
			keyName = "venatorsZeroTime",
			name = "0-time Venators",
			description =  "Enable if you would kill Venators even if you already owned a heart"
	)
	default boolean venatorsZeroTime()
	{
		return false;
	}*/
	@ConfigItem(
			position = 1,
			section = venatorsSection,
			keyName = "venatorsTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int venatorsTravelTime() {return 60;}
	@ConfigItem(
			position = 2,
			section = venatorsSection,
			keyName = "venatorsKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int venatorsKPH() {return 107;}

	@ConfigSection(name = "Warped Creatures (Advanced)", description = "Change values used for Warped Creatures", position = 1, closedByDefault = true)
	String warpedCreaturesSection = "Warped Creatures (Advanced)";
	@ConfigItem(
			position = 1,
			section = warpedCreaturesSection,
			keyName = "warpedCreaturesTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int warpedCreaturesTravelTime() {return 70;}
	@ConfigItem(
			position = 2,
			section = warpedCreaturesSection,
			keyName = "warpedCreaturesKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int warpedCreaturesKPH() {return 457;}

	@ConfigSection(name = "Wyrmlings (Advanced)", description = "Change values used for Wyrm tasks (done at Wyrmlings)", position = 1, closedByDefault = true)
	String wyrmsSection = "Wyrmlings (Advanced)";
	@ConfigItem(
			position = 1,
			section = wyrmsSection,
			keyName = "wyrmsTravelTime",
			name = "Travel Time",
			description = "Total ticks between being fully geared up at the bank and arriving at the task location"
	)
	default int wyrmsTravelTime() {return 20;}
	@ConfigItem(
			position = 2,
			section = wyrmsSection,
			keyName = "wyrmsKPH",
			name = "Kills Per Hour",
			description = "Average kills per hour not including banking and travel time"
	)
	default int wyrmsKPH() {return 920;}
}
