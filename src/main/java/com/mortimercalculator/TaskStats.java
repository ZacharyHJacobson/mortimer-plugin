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
    String location;
    String complete_using;

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
                location = MortimerConstants.LOCATION_TOWER;
                complete_using = MortimerConstants.WEAPON_BLOWPIPE;
                break;
            case "Cave Crawlers":
                zero_time = config.caveCrawlersZeroTime();
                travel_time = config.caveCrawlersTravelTime();
                kills_per_hour = config.caveCrawlersKPH();
                superiors_per_heart = 1336;
                location = MortimerConstants.LOCATION_FREMENNIK;
                complete_using = MortimerConstants.WEAPON_BLOWPIPE;
                break;
            case "Banshees":
                zero_time = config.bansheesZeroTime();
                travel_time = config.bansheesTravelTime();
                kills_per_hour = config.bansheesKPH();
                superiors_per_heart = 1288;
                location = MortimerConstants.LOCATION_TOWER;
                complete_using = MortimerConstants.WEAPON_BLOWPIPE;
                break;
            case "Rockslugs":
                zero_time = config.rockslugsZeroTime();
                travel_time = config.rockslugsTravelTime();
                kills_per_hour = config.rockslugsKPH();
                superiors_per_heart = 1240;
                location = MortimerConstants.LOCATION_YNYSDAIL;
                complete_using = MortimerConstants.WEAPON_BLOWPIPE;
                break;
            case "Cockatrice":
                zero_time = config.cockatriceZeroTime();
                travel_time = config.cockatriceTravelTime();
                kills_per_hour = config.cockatriceKPH();
                superiors_per_heart = 1192;
                location = MortimerConstants.LOCATION_FREMENNIK;
                complete_using = MortimerConstants.WEAPON_DARTS;
                break;
            case "Pyrefiends":
                zero_time = config.pyrefiendsZeroTime();
                travel_time = config.pyrefiendsTravelTime();
                kills_per_hour = config.pyrefiendsKPH();
                superiors_per_heart = 1144;
                location = MortimerConstants.LOCATION_FREMENNIK;
                complete_using = MortimerConstants.WEAPON_BLOWPIPE;
                break;
            case "Infernal Mages":
                zero_time = config.infernalMagesZeroTime();
                travel_time = config.infernalMagesTravelTime();
                kills_per_hour = config.infernalMagesKPH();
                superiors_per_heart = 960;
                location = MortimerConstants.LOCATION_TOWER;
                complete_using = MortimerConstants.WEAPON_BLOWPIPE;
                break;
            case "Bloodveld":
                zero_time = config.bloodveldZeroTime();
                travel_time = config.bloodveldTravelTime();
                kills_per_hour = config.bloodveldKPH();
                superiors_per_heart = 896;
                location = MortimerConstants.LOCATION_MEIYERDITCH;
                complete_using = MortimerConstants.WEAPON_VENATOR + MortimerConstants.WEAPON_CANNON;
                break;
            case "Gryphons":
                zero_time = config.gryphonsZeroTime();
                travel_time = config.gryphonsTravelTime();
                kills_per_hour = config.gryphonsKPH();
                superiors_per_heart = 888;
                location = MortimerConstants.LOCATION_CONCH;
                complete_using = MortimerConstants.WEAPON_VENATOR + MortimerConstants.WEAPON_CANNON;
                break;
            case "Jellies":
                zero_time = config.jelliesZeroTime();
                if(config.wildernessPresets())
                {
                    travel_time = MortimerConstants.JELLIES_WILDERNESS_TRAVEL;
                    kills_per_hour = MortimerConstants.JELLIES_WILDERNESS_KPH;
                }
                else
                {
                    travel_time = config.jelliesTravelTime();
                    kills_per_hour = config.jelliesKPH();
                }
                superiors_per_heart = 872;
                if(config.jelliesWilderness() || config.wildernessPresets())
                {
                    kills_per_superior = (config.eliteCas()) ? 135 : 180;
                    location = MortimerConstants.LOCATION_WILDERNESS;
                    complete_using = MortimerConstants.WEAPON_VENATOR + MortimerConstants.WEAPON_CANNON;
                }
                else
                {
                    location = MortimerConstants.LOCATION_CATACOMBS;
                    complete_using = MortimerConstants.WEAPON_BARRAGE;
                }
                break;
            case "Custodian Stalkers":
                zero_time = config.custodianStalkersZeroTime();
                travel_time = config.custodianStalkersTravelTime();
                kills_per_hour = config.custodianStalkersKPH();
                superiors_per_heart = 504;
                location = MortimerConstants.LOCATION_STALKER;
                complete_using = MortimerConstants.WEAPON_VENATOR + MortimerConstants.WEAPON_CANNON;
                break;
            case "Turoth":
                zero_time = config.turothZeroTime();
                travel_time = config.turothTravelTime();
                kills_per_hour = config.turothKPH();
                superiors_per_heart = 832;
                location = MortimerConstants.LOCATION_FREMENNIK;
                complete_using = MortimerConstants.WEAPON_LEAFY;
                break;
            case "Warped Creatures":
                zero_time = config.warpedCreaturesZeroTime();
                travel_time = config.warpedCreaturesTravelTime();
                kills_per_hour = config.warpedCreaturesKPH();
                superiors_per_heart = 816;
                location = MortimerConstants.LOCATION_POISON;
                complete_using = MortimerConstants.WEAPON_VENATOR + MortimerConstants.WEAPON_CANNON;
                break;
            case "Cave Horrors":
                zero_time = config.caveHorrorsZeroTime();
                travel_time = config.caveHorrorsTravelTime();
                kills_per_hour = config.caveHorrorsKPH();
                superiors_per_heart = 784;
                location = MortimerConstants.LOCATION_MOS;
                complete_using = MortimerConstants.WEAPON_BLOWPIPE;
                break;
            case "Aberrant Spectres":
                zero_time = config.aberrantSpectresZeroTime();
                travel_time = config.aberrantSpectresTravelTime();
                kills_per_hour = config.aberrantSpectresKPH();
                superiors_per_heart = 760;
                location = MortimerConstants.LOCATION_TOWER;
                complete_using = MortimerConstants.WEAPON_BLOWPIPE;
                break;
            case "Basilisks":
                zero_time = config.basilisksZeroTime();
                travel_time = config.basilisksTravelTime();
                kills_per_hour = config.basilisksKPH();
                superiors_per_heart = 1024;
                location = MortimerConstants.LOCATION_FREMENNIK;
                complete_using = MortimerConstants.WEAPON_DARTS;
                break;
            case "Wyrms":
                zero_time = config.wyrmsZeroTime();
                travel_time = config.wyrmsTravelTime();
                kills_per_hour = config.wyrmsKPH();
                superiors_per_heart = 0;
                location = MortimerConstants.LOCATION_WYRMSCRAIG;
                complete_using = MortimerConstants.WEAPON_BLOWPIPE + MortimerConstants.WEAPON_CANNON;
                break;
            case "Dust Devils":
                zero_time = config.dustDevilsZeroTime();
                if(config.wildernessPresets())
                {
                    travel_time = MortimerConstants.DUST_DEVILS_WILDERNESS_TRAVEL;
                    kills_per_hour = MortimerConstants.DUST_DEVILS_WILDERNESS_KPH;
                }
                else
                {
                    travel_time = config.dustDevilsTravelTime();
                    kills_per_hour = config.dustDevilsKPH();
                }
                superiors_per_heart = 680;
                if(config.dustDevilsWilderness() || config.wildernessPresets())
                {
                    kills_per_superior = (config.eliteCas()) ? 135 : 180;
                    location = MortimerConstants.LOCATION_WILDERNESS;
                    complete_using = MortimerConstants.WEAPON_BARRAGE + MortimerConstants.WEAPON_CANNON;
                }
                else
                {
                    location = MortimerConstants.LOCATION_CATACOMBS;
                    complete_using = MortimerConstants.WEAPON_BARRAGE;
                }
                break;
            case "Kurask":
                zero_time = config.kuraskZeroTime();
                travel_time = config.kuraskTravelTime();
                kills_per_hour = config.kuraskKPH();
                superiors_per_heart = 600;
                location = MortimerConstants.LOCATION_IORWERTH;
                complete_using = MortimerConstants.WEAPON_LEAFY;
                break;
            case "Venators":
                zero_time = config.venatorsZeroTime();
                travel_time = config.venatorsTravelTime();
                kills_per_hour = config.venatorsKPH();
                superiors_per_heart = 536;
                location = MortimerConstants.LOCATION_VAMPYRIUM;
                complete_using = MortimerConstants.WEAPON_SUNSPEAR;
                break;
            case "Gargoyles":
                zero_time = config.gargoylesZeroTime();
                travel_time = config.gargoylesTravelTime();
                kills_per_hour = config.gargoylesKPH();
                superiors_per_heart = 520;
                location = MortimerConstants.LOCATION_TOWER;
                complete_using = MortimerConstants.WEAPON_SCYTHE;
                break;
            case "Aquanites":
                zero_time = config.aquanitesZeroTime();
                travel_time = config.aquanitesTravelTime();
                kills_per_hour = config.aquanitesKPH();
                superiors_per_heart = 472;
                location = MortimerConstants.LOCATION_YNYSDAIL;
                complete_using = MortimerConstants.WEAPON_BLOWPIPE;
                break;
            case "Nechryael":
                zero_time = config.nechryaelZeroTime();
                if(config.wildernessPresets())
                {
                    travel_time = MortimerConstants.NECHRYAEL_WILDERNESS_TRAVEL;
                    kills_per_hour = MortimerConstants.NECHRYAEL_WILDERNESS_KPH;
                }
                else
                {
                    travel_time = config.nechryaelTravelTime();
                    kills_per_hour = config.nechryaelKPH();
                }
                superiors_per_heart = 440;
                if(config.nechryaelWilderness() || config.wildernessPresets())
                {
                    kills_per_superior = (config.eliteCas()) ? 135 : 180;
                    location = MortimerConstants.LOCATION_WILDERNESS;
                    complete_using = MortimerConstants.WEAPON_BARRAGE + MortimerConstants.WEAPON_CANNON;
                }
                else
                {
                    location = MortimerConstants.LOCATION_CATACOMBS;
                    complete_using = MortimerConstants.WEAPON_BARRAGE;
                }
                break;
            case "Drakes":
                zero_time = config.drakesZeroTime();
                travel_time = config.drakesTravelTime();
                kills_per_hour = config.drakesKPH();
                superiors_per_heart = 368;
                location = MortimerConstants.LOCATION_KARUULM;
                complete_using = MortimerConstants.WEAPON_DHL + MortimerConstants.WEAPON_CANNON;
                break;
            case "Abyssal Demons":
                zero_time = config.abyssalDemonsZeroTime();
                if(config.wildernessPresets())
                {
                    travel_time = MortimerConstants.ABYSSAL_DEMONS_WILDERNESS_TRAVEL;
                    kills_per_hour = MortimerConstants.ABYSSAL_DEMONS_WILDERNESS_KPH;
                }
                else
                {
                    travel_time = config.abyssalDemonsTravelTime();
                    kills_per_hour = config.abyssalDemonsKPH();
                }
                superiors_per_heart = 352;
                if(config.abyssalDemonsWilderness() || config.wildernessPresets())
                {
                    kills_per_superior = (config.eliteCas()) ? 135 : 180;
                    location = MortimerConstants.LOCATION_WILDERNESS;
                    complete_using = MortimerConstants.WEAPON_BARRAGE + MortimerConstants.WEAPON_CANNON;
                }
                else
                {
                    location = MortimerConstants.LOCATION_CATACOMBS;
                    complete_using = MortimerConstants.WEAPON_BARRAGE;
                }
                break;
            case "Dark Beasts":
                zero_time = config.darkBeastsZeroTime();
                travel_time = config.darkBeastsTravelTime();
                kills_per_hour = config.darkBeastsKPH();
                superiors_per_heart = 256;
                location = MortimerConstants.LOCATION_MOURNER;
                complete_using = MortimerConstants.WEAPON_SCYTHE + MortimerConstants.WEAPON_CANNON;
                break;
            case "Araxytes":
                zero_time = config.araxytesZeroTime();
                travel_time = config.araxytesTravelTime();
                kills_per_hour = config.araxytesKPH();
                superiors_per_heart = 224;
                location = MortimerConstants.LOCATION_SPIDER;
                complete_using = MortimerConstants.WEAPON_VENATOR + MortimerConstants.WEAPON_CANNON;
                break;
            case "Smoke Devils":
                zero_time = config.smokeDevilsZeroTime();
                travel_time = config.smokeDevilsTravelTime();
                kills_per_hour = config.smokeDevilsKPH();
                superiors_per_heart = 200;
                location = MortimerConstants.LOCATION_SMOKE;
                complete_using = MortimerConstants.WEAPON_BARRAGE + MortimerConstants.WEAPON_CANNON;
                break;
            case "Hydras":
                zero_time = config.hydrasZeroTime();
                travel_time = config.hydrasTravelTime();
                kills_per_hour = config.hydrasKPH();
                superiors_per_heart = 160;
                location = MortimerConstants.LOCATION_KARUULM;
                complete_using = MortimerConstants.WEAPON_BLOWPIPE;
                break;
        }
    }
}