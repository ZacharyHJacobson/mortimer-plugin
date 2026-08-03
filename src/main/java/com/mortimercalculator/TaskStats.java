package com.mortimercalculator;

/**
 * data structure to hold stats for a specific monster that can be assigned as a slayer task
 */
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
                travel_time = 20;
                kills_per_hour = 920;
                superiors_per_heart = 0;
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
                break;
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
                assign_min = 110;
                assign_max = 135;
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