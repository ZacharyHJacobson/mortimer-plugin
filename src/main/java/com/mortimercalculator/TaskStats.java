package com.mortimercalculator;

/**
 * data structure to hold stats for a specific monster that can be assigned as a slayer task
 */
public class TaskStats
{
    public static MortimerCalculatorConfig config;

    int travel_time;
    int kills_per_hour;
    int superiors_per_heart;

    public TaskStats(String task_name)
    {
        switch(task_name)
        {
            case "Crawling Hands":
                travel_time = config.crawlingHandsTravelTime();
                kills_per_hour = config.crawlingHandsKPH();
                superiors_per_heart = 1376;
                break;
            case "Cave Crawlers":
                travel_time = config.caveCrawlersTravelTime();
                kills_per_hour = config.caveCrawlersKPH();
                superiors_per_heart = 1336;
                break;
            case "Banshees":
                travel_time = config.bansheesTravelTime();
                kills_per_hour = config.bansheesKPH();
                superiors_per_heart = 1288;
                break;
            case "Rockslugs":
                travel_time = config.rockslugsTravelTime();
                kills_per_hour = config.rockslugsKPH();
                superiors_per_heart = 1240;
                break;
            case "Cockatrice":
                travel_time = config.cockatriceTravelTime();
                kills_per_hour = config.cockatriceKPH();
                superiors_per_heart = 1192;
                break;
            case "Pyrefiends":
                travel_time = config.pyrefiendsTravelTime();
                kills_per_hour = config.pyrefiendsKPH();
                superiors_per_heart = 1144;
                break;
            case "Infernal Mages":
                travel_time = config.infernalMagesTravelTime();
                kills_per_hour = config.infernalMagesKPH();
                superiors_per_heart = 960;
                break;
            case "Bloodveld":
                travel_time = config.bloodveldTravelTime();
                kills_per_hour = config.bloodveldKPH();
                superiors_per_heart = 896;
                break;
            case "Gryphons":
                travel_time = config.gryphonsTravelTime();
                kills_per_hour = config.gryphonsKPH();
                superiors_per_heart = 888;
                break;
            case "Jellies":
                travel_time = config.jelliesTravelTime();
                kills_per_hour = config.jelliesKPH();
                superiors_per_heart = 872;
                break;
            case "Custodian Stalkers":
                travel_time = config.custodianStalkersTravelTime();
                kills_per_hour = config.custodianStalkersKPH();
                superiors_per_heart = 504;
                break;
            case "Turoth":
                travel_time = config.turothTravelTime();
                kills_per_hour = config.turothKPH();
                superiors_per_heart = 832;
                break;
            case "Warped Creatures":
                travel_time = config.warpedCreaturesTravelTime();
                kills_per_hour = config.warpedCreaturesKPH();
                superiors_per_heart = 816;
                break;
            case "Cave Horrors":
                travel_time = config.caveHorrorsTravelTime();
                kills_per_hour = config.caveHorrorsKPH();
                superiors_per_heart = 784;
                break;
            case "Aberrant Spectres":
                travel_time = config.aberrantSpectresTravelTime();
                kills_per_hour = config.aberrantSpectresKPH();
                superiors_per_heart = 760;
                break;
            case "Basilisks":
                travel_time = config.basilisksTravelTime();
                kills_per_hour = config.basilisksKPH();
                superiors_per_heart = 1024;
                break;
            case "Wyrms":
                travel_time = config.wyrmsTravelTime();
                kills_per_hour = config.wyrmsKPH();
                superiors_per_heart = 0;
                break;
            case "Dust Devils":
                travel_time = config.dustDevilsTravelTime();
                kills_per_hour = config.dustDevilsKPH();
                superiors_per_heart = 680;
                break;
            case "Kurask":
                travel_time = config.kuraskTravelTime();
                kills_per_hour = config.kuraskKPH();
                superiors_per_heart = 600;
                break;
            case "Venators":
                travel_time = config.venatorsTravelTime();
                kills_per_hour = config.venatorsKPH();
                superiors_per_heart = 536;
                break;
            case "Gargoyles":
                travel_time = config.gargoylesTravelTime();
                kills_per_hour = config.gargoylesKPH();
                superiors_per_heart = 520;
                break;
            case "Aquanites":
                travel_time = config.aquanitesTravelTime();
                kills_per_hour = config.aquanitesKPH();
                superiors_per_heart = 472;
                break;
            case "Nechryael":
                travel_time = config.nechryaelTravelTime();
                kills_per_hour = config.nechryaelKPH();
                superiors_per_heart = 440;
                break;
            case "Drakes":
                travel_time = config.drakesTravelTime();
                kills_per_hour = config.drakesKPH();
                superiors_per_heart = 368;
                break;
            case "Abyssal Demons":
                travel_time = config.abyssalDemonsTravelTime();
                kills_per_hour = config.abyssalDemonsKPH();
                superiors_per_heart = 352;
                break;
            case "Dark Beasts":
                travel_time = config.darkBeastsTravelTime();
                kills_per_hour = config.darkBeastsKPH();
                superiors_per_heart = 256;
                break;
            case "Araxytes":
                travel_time = config.araxytesTravelTime();
                kills_per_hour = config.araxytesKPH();
                superiors_per_heart = 224;
                break;
            case "Smoke Devils":
                travel_time = config.smokeDevilsTravelTime();
                kills_per_hour = config.smokeDevilsKPH();
                superiors_per_heart = 200;
                break;
            case "Hydras":
                travel_time = config.hydrasTravelTime();
                kills_per_hour = config.hydrasKPH();
                superiors_per_heart = 160;
                break;
        }
    }
}