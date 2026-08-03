package com.mortimercalculator;

/**
 * data structure to hold stats for a specific monster that can be assigned as a slayer task
 */
public class TaskStats
{
    int travel_time;
    int kills_per_hour;
    int superiors_per_heart;

    public TaskStats(String task_name)
    {
        switch(task_name)
        {
            case "Crawling Hands":
                travel_time = 7;
                kills_per_hour = 1565;
                superiors_per_heart = 1376;
                break;
            case "Cave Crawlers":
                travel_time = 5;
                kills_per_hour = 1384;
                superiors_per_heart = 1336;
                break;
            case "Banshees":
                travel_time = 27;
                kills_per_hour = 1333;
                superiors_per_heart = 1288;
                break;
            case "Rockslugs":
                travel_time = 32;
                kills_per_hour = 1125;
                superiors_per_heart = 1240;
                break;
            case "Cockatrice":
                travel_time = 39;
                kills_per_hour = 818;
                superiors_per_heart = 1192;
                break;
            case "Pyrefiends":
                travel_time = 21;
                kills_per_hour = 857;
                superiors_per_heart = 1144;
                break;
            case "Infernal Mages":
                travel_time = 47;
                kills_per_hour = 642;
                superiors_per_heart = 960;
                break;
            case "Bloodveld":
                travel_time = 45;
                kills_per_hour = 600;
                superiors_per_heart = 896;
                break;
            case "Gryphons":
                travel_time = 56;
                kills_per_hour = 600;
                superiors_per_heart = 888;
                break;
            case "Jellies":
                travel_time = 44;
                kills_per_hour = 840;
                superiors_per_heart = 872;
                break;
            case "Custodian Stalkers":
                travel_time = 86;
                kills_per_hour = 440;
                superiors_per_heart = 504;
                break;
            case "Turoth":
                travel_time = 50;
                kills_per_hour = 383;
                superiors_per_heart = 832;
                break;
            case "Warped Creatures":
                travel_time = 70;
                kills_per_hour = 457;
                superiors_per_heart = 816;
                break;
            case "Cave Horrors":
                travel_time = 75;
                kills_per_hour = 610;
                superiors_per_heart = 784;
                break;
            case "Aberrant Spectres":
                travel_time = 34;
                kills_per_hour = 500;
                superiors_per_heart = 760;
                break;
            case "Basilisks":
                travel_time = 38;
                kills_per_hour = 450;
                superiors_per_heart = 1024;
                break;
            case "Wyrms":
                travel_time = 20;
                kills_per_hour = 920;
                superiors_per_heart = 0;
                break;
            case "Dust Devils":
                travel_time = 49;
                kills_per_hour = 780;
                superiors_per_heart = 680;
                break;
            case "Kurask":
                travel_time = 70;
                kills_per_hour = 290;
                superiors_per_heart = 600;
                break;
            case "Venators":
                travel_time = 60;
                kills_per_hour = 107;
                superiors_per_heart = 536;
                break;
            case "Gargoyles":
                travel_time = 17;
                kills_per_hour = 380;
                superiors_per_heart = 520;
                break;
            case "Aquanites":
                travel_time = 50;
                kills_per_hour = 200;
                superiors_per_heart = 472;
                break;
            case "Nechryael":
                travel_time = 42;
                kills_per_hour = 520;
                superiors_per_heart = 440;
                break;
            case "Drakes":
                travel_time = 55;
                kills_per_hour = 155;
                superiors_per_heart = 368;
                break;
            case "Abyssal Demons":
                travel_time = 47;
                kills_per_hour = 650;
                superiors_per_heart = 352;
                break;
            case "Dark Beasts":
                travel_time = 17;
                kills_per_hour = 205;
                superiors_per_heart = 256;
                break;
            case "Araxytes":
                travel_time = 20;
                kills_per_hour = 769;
                superiors_per_heart = 224;
                break;
            case "Smoke Devils":
                travel_time = 50;
                kills_per_hour = 800;
                superiors_per_heart = 200;
                break;
            case "Hydras":
                travel_time = 45;
                kills_per_hour = 149;
                superiors_per_heart = 160;
                break;
        }
    }
}