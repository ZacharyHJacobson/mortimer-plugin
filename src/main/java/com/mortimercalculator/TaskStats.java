package com.mortimercalculator;

/**
 * data structure to hold stats for a specific monster that can be assigned as a slayer task
 */
public class TaskStats
{
    public static MortimerCalculatorConfig config;

    MortimerCalculatorConfig.PriorityComparedToHeart zero_time;
    int travel_time;
    int kills_per_hour;
    int superiors_per_heart;
    int kills_per_superior;

    public TaskStats(String task_name)
    {
        kills_per_superior = (config.eliteCas()) ? 150 : 200;
        switch(task_name)
        {
            case "Crawling Hands":
                zero_time = config.crawlingHandsZeroTime();
                travel_time = config.crawlingHandsTravelTime();
                kills_per_hour = config.crawlingHandsKPH();
                superiors_per_heart = 1376;
                break;
            case "Cave Crawlers":
                zero_time = config.caveCrawlersZeroTime();
                travel_time = config.caveCrawlersTravelTime();
                kills_per_hour = config.caveCrawlersKPH();
                superiors_per_heart = 1336;
                break;
            case "Banshees":
                zero_time = config.bansheesZeroTime();
                travel_time = config.bansheesTravelTime();
                kills_per_hour = config.bansheesKPH();
                superiors_per_heart = 1288;
                break;
            case "Rockslugs":
                zero_time = config.rockslugsZeroTime();
                travel_time = config.rockslugsTravelTime();
                kills_per_hour = config.rockslugsKPH();
                superiors_per_heart = 1240;
                break;
            case "Cockatrice":
                zero_time = config.cockatriceZeroTime();
                travel_time = config.cockatriceTravelTime();
                kills_per_hour = config.cockatriceKPH();
                superiors_per_heart = 1192;
                break;
            case "Pyrefiends":
                zero_time = config.pyrefiendsZeroTime();
                travel_time = config.pyrefiendsTravelTime();
                kills_per_hour = config.pyrefiendsKPH();
                superiors_per_heart = 1144;
                break;
            case "Infernal Mages":
                zero_time = config.infernalMagesZeroTime();
                travel_time = config.infernalMagesTravelTime();
                kills_per_hour = config.infernalMagesKPH();
                superiors_per_heart = 960;
                break;
            case "Bloodveld":
                zero_time = config.bloodveldZeroTime();
                travel_time = config.bloodveldTravelTime();
                kills_per_hour = config.bloodveldKPH();
                superiors_per_heart = 896;
                break;
            case "Gryphons":
                zero_time = config.gryphonsZeroTime();
                travel_time = config.gryphonsTravelTime();
                kills_per_hour = config.gryphonsKPH();
                superiors_per_heart = 888;
                break;
            case "Jellies":
                zero_time = config.jelliesZeroTime();
                travel_time = config.jelliesTravelTime();
                kills_per_hour = config.jelliesKPH();
                superiors_per_heart = 872;
                if(config.jelliesWilderness()) kills_per_superior = (config.eliteCas()) ? 135 : 180;
                break;
            case "Custodian Stalkers":
                zero_time = config.custodianStalkersZeroTime();
                travel_time = config.custodianStalkersTravelTime();
                kills_per_hour = config.custodianStalkersKPH();
                superiors_per_heart = 504;
                break;
            case "Turoth":
                zero_time = config.turothZeroTime();
                travel_time = config.turothTravelTime();
                kills_per_hour = config.turothKPH();
                superiors_per_heart = 832;
                break;
            case "Warped Creatures":
                zero_time = config.warpedCreaturesZeroTime();
                travel_time = config.warpedCreaturesTravelTime();
                kills_per_hour = config.warpedCreaturesKPH();
                superiors_per_heart = 816;
                break;
            case "Cave Horrors":
                zero_time = config.caveHorrorsZeroTime();
                travel_time = config.caveHorrorsTravelTime();
                kills_per_hour = config.caveHorrorsKPH();
                superiors_per_heart = 784;
                break;
            case "Aberrant Spectres":
                zero_time = config.aberrantSpectresZeroTime();
                travel_time = config.aberrantSpectresTravelTime();
                kills_per_hour = config.aberrantSpectresKPH();
                superiors_per_heart = 760;
                break;
            case "Basilisks":
                zero_time = config.basilisksZeroTime();
                travel_time = config.basilisksTravelTime();
                kills_per_hour = config.basilisksKPH();
                superiors_per_heart = 1024;
                break;
            case "Wyrms":
                zero_time = config.wyrmsZeroTime();
                travel_time = config.wyrmsTravelTime();
                kills_per_hour = config.wyrmsKPH();
                superiors_per_heart = 0;
                break;
            case "Dust Devils":
                zero_time = config.dustDevilsZeroTime();
                travel_time = config.dustDevilsTravelTime();
                kills_per_hour = config.dustDevilsKPH();
                superiors_per_heart = 680;
                if(config.dustDevilsWilderness()) kills_per_superior = (config.eliteCas()) ? 135 : 180;
                break;
            case "Kurask":
                zero_time = config.kuraskZeroTime();
                travel_time = config.kuraskTravelTime();
                kills_per_hour = config.kuraskKPH();
                superiors_per_heart = 600;
                break;
            case "Venators":
                zero_time = config.venatorsZeroTime();
                travel_time = config.venatorsTravelTime();
                kills_per_hour = config.venatorsKPH();
                superiors_per_heart = 536;
                break;
            case "Gargoyles":
                zero_time = config.gargoylesZeroTime();
                travel_time = config.gargoylesTravelTime();
                kills_per_hour = config.gargoylesKPH();
                superiors_per_heart = 520;
                break;
            case "Aquanites":
                zero_time = config.aquanitesZeroTime();
                travel_time = config.aquanitesTravelTime();
                kills_per_hour = config.aquanitesKPH();
                superiors_per_heart = 472;
                break;
            case "Nechryael":
                zero_time = config.nechryaelZeroTime();
                travel_time = config.nechryaelTravelTime();
                kills_per_hour = config.nechryaelKPH();
                superiors_per_heart = 440;
                if(config.nechryaelWilderness()) kills_per_superior = (config.eliteCas()) ? 135 : 180;
                break;
            case "Drakes":
                zero_time = config.drakesZeroTime();
                travel_time = config.drakesTravelTime();
                kills_per_hour = config.drakesKPH();
                superiors_per_heart = 368;
                break;
            case "Abyssal Demons":
                zero_time = config.abyssalDemonsZeroTime();
                travel_time = config.abyssalDemonsTravelTime();
                kills_per_hour = config.abyssalDemonsKPH();
                superiors_per_heart = 352;
                if(config.abyssalDemonsWilderness()) kills_per_superior = (config.eliteCas()) ? 135 : 180;
                break;
            case "Dark Beasts":
                zero_time = config.darkBeastsZeroTime();
                travel_time = config.darkBeastsTravelTime();
                kills_per_hour = config.darkBeastsKPH();
                superiors_per_heart = 256;
                break;
            case "Araxytes":
                zero_time = config.araxytesZeroTime();
                travel_time = config.araxytesTravelTime();
                kills_per_hour = config.araxytesKPH();
                superiors_per_heart = 224;
                break;
            case "Smoke Devils":
                zero_time = config.smokeDevilsZeroTime();
                travel_time = config.smokeDevilsTravelTime();
                kills_per_hour = config.smokeDevilsKPH();
                superiors_per_heart = 200;
                break;
            case "Hydras":
                zero_time = config.hydrasZeroTime();
                travel_time = config.hydrasTravelTime();
                kills_per_hour = config.hydrasKPH();
                superiors_per_heart = 160;
                break;
        }
    }
}