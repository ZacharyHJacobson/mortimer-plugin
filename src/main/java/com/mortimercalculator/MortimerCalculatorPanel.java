package com.mortimercalculator;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.util.SwingUtil;
import net.runelite.http.api.chat.Task;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.Objects;

@Getter(AccessLevel.PACKAGE)
public class MortimerCalculatorPanel extends PluginPanel
{
    private final MortimerCalculatorPlugin plugin;
    private final MortimerCalculatorConfig config;

    private final Taskbox[] taskboxes = new Taskbox[3];
    private final JPanel suggestion_box;
    private JLabel output_box = null;

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

    public class Taskbox
    {
        public JPanel task_box;
        public JLabel ticks_wasted;
        private final JComboBox<String> monster_box;
        private final JComboBox<String> modifier_box;
        private final JFormattedTextField magnitude;

        public Taskbox()
        {
            task_box = new JPanel()
            {
                @Override protected void paintComponent(Graphics graphics)
                {
                    Graphics2D g = (Graphics2D) graphics.create();
                    g.setPaint(ColorScheme.DARKER_GRAY_COLOR);
                    g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                    g.dispose();
                }
            };
            task_box.setLayout(new BoxLayout(task_box, BoxLayout.Y_AXIS));
            task_box.setBorder(new EmptyBorder(10, 10, 10, 10));

            String[] monsters_list = {"none", "Aberrant Spectres", "Abyssal Demons", "Aquanites", "Araxytes", "Banshees", "Basilisks", "Bloodveld", "Cave Crawlers", "Cave Horrors", "Cockatrice", "Crawling Hands", "Custodian Stalkers", "Dark Beasts", "Drakes", "Dust Devils", "Gargoyles", "Gryphons", "Hydras", "Infernal Mages", "Jellies", "Kurask", "Nechryael", "Pyrefiends", "Rockslugs", "Smoke Devils", "Turoth", "Venators", "Warped Creatures", "Wyrms"};
            monster_box = new JComboBox<>(monsters_list);
            monster_box.setFont(FontManager.getRunescapeBoldFont());
            monster_box.setForeground(Color.yellow);
            monster_box.addActionListener(event -> {update();});
            task_box.add(monster_box);

            String[] modifier_list = {"Slayer points","Assigned","Clue chance", "Superior unique chance", "Slayer XP"};
            modifier_box = new JComboBox<>(modifier_list);
            modifier_box.setFont(FontManager.getRunescapeFont());
            modifier_box.setForeground(Color.yellow);
            modifier_box.addActionListener(event -> {update();});
            task_box.add(modifier_box);

            magnitude = new JFormattedTextField(NumberFormat.getIntegerInstance());
            magnitude.setFont(FontManager.getRunescapeFont());
            magnitude.setForeground(Color.yellow);
            magnitude.setValue(0);
            magnitude.setHorizontalAlignment(SwingConstants.LEFT);
            magnitude.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    update_immediately();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    update_immediately();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    update_immediately();
                }

                private void update_immediately()
                {
                    SwingUtilities.invokeLater(() -> {
                        try{
                            magnitude.commitEdit();
                            update();
                        } catch (Exception e) {}
                    });
                }
            });
            magnitude.addFocusListener(new FocusAdapter()
            {
                public void focusLost(FocusEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        magnitude.validate();
                        update();
                    });
                }
            });
            magnitude.addActionListener(event -> {update();});
            task_box.add(magnitude);

            ticks_wasted = new JLabel("");
            ticks_wasted.setVisible(config.showTimeWasted());
            ticks_wasted.setFont(FontManager.getRunescapeSmallFont());
            ticks_wasted.setForeground(Color.yellow);
            task_box.add(ticks_wasted);
        }

        public String getName()
        {
            return(monster_box.getSelectedItem().toString());
        }

        public int getLengthModifier()
        {
            if(!Objects.equals(modifier_box.getSelectedItem().toString(), "Assigned")) return 0;
            Number num = (Number) magnitude.getValue();
            return num.intValue();
        }

        public int getDropModifier()
        {
            if(!Objects.equals(modifier_box.getSelectedItem().toString(), "Superior unique chance")) return 0;
            Number num = (Number) magnitude.getValue();
            return num.intValue();
        }

        public void update_task(String name, String modifier, int new_magnitude)
        {
            String[] monsters_list = {"none", "Aberrant Spectres", "Abyssal Demons", "Aquanites", "Araxytes", "Banshees", "Basilisks", "Bloodveld", "Cave Crawlers", "Cave Horrors", "Cockatrice", "Crawling Hands", "Custodian Stalkers", "Dark Beasts", "Drakes", "Dust Devils", "Gargoyles", "Gryphons", "Hydras", "Infernal Mages", "Jellies", "Kurask", "Nechryael", "Pyrefiends", "Rockslugs", "Smoke Devils", "Turoth", "Venators", "Warped Creatures", "Wyrms"};
            for(int name_index = 0; name_index < monsters_list.length; name_index++)
            {
                if(Objects.equals(monsters_list[name_index], name))
                monster_box.setSelectedIndex(name_index);
            }

            String[] modifier_list = {"Slayer points","Assigned","Clue Chance", "Superior unique chance", "Slayer XP"};
            for(int modifier_index = 0; modifier_index < modifier_list.length; modifier_index++)
            {
                if(Objects.equals(modifier_list[modifier_index], modifier))
                    modifier_box.setSelectedIndex(modifier_index);
            }

            magnitude.setValue(new_magnitude);
        }
    }

    @Inject
    private MortimerCalculatorPanel(MortimerCalculatorPlugin plugin, MortimerCalculatorConfig config)
    {
        this.plugin = plugin;
        this.config = config;

        setBackground(ColorScheme.DARK_GRAY_COLOR);

        for(int box_number = 0; box_number < 3; box_number++)
        {
            Taskbox box = new Taskbox();
            taskboxes[box_number] = box;
            add(box.task_box);
        }
        suggestion_box = CreateSuggestionBox();
        add(suggestion_box);
    }
    
    private JPanel CreateSuggestionBox()
    {
        JPanel suggestion_box = new JPanel()
        {
            @Override protected void paintComponent(Graphics graphics)
            {
                Graphics2D g = (Graphics2D) graphics.create();
                g.setPaint(ColorScheme.DARKER_GRAY_COLOR);
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g.dispose();
            }
        };
        suggestion_box.setLayout(new BoxLayout(suggestion_box, BoxLayout.Y_AXIS));
        suggestion_box.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel output = new JLabel("Input two or more tasks");
        output.setFont(FontManager.getRunescapeBoldFont());
        output.setForeground(Color.yellow);
        suggestion_box.add(output);
        this.output_box = output;

        return suggestion_box;
    }

    private int calcTicksWasted(TaskStats task_stats, int length_modifier, int drop_modifier, float number_assigned, boolean slaughter)
    {
        if(number_assigned == 0) number_assigned = killsPerTask(task_stats, length_modifier);
        float number_killed_with_bracelet = applyBracelet(number_assigned, slaughter);
        int task_completion_time = timePerTask(task_stats, number_killed_with_bracelet);
        if(task_stats.superiors_per_heart == 0) return task_completion_time;
        float tasks_per_heart = tasksPerHeart(task_stats.superiors_per_heart, number_killed_with_bracelet, drop_modifier);
        int time_per_heart = config.timeToHeart();
        float task_time_per_heart = task_completion_time * tasks_per_heart;
        if((task_time_per_heart < time_per_heart) && (!slaughter))
        {
            return calcTicksWasted(task_stats, length_modifier, drop_modifier, number_assigned, true);
        }
        return (int)(task_completion_time * (1 - (time_per_heart/task_time_per_heart)));
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
        int time = config.prepTime() + task_stats.travel_time;
        time += (int)(number_killed_with_bracelet/task_stats.kills_per_hour * 6000);	//! let users input eventually
        return time;
    }

    private float tasksPerHeart(int base_superiors_per_heart, float number_killed_with_bracelet, int drop_modifier)
    {
        int kills_per_superior = (config.eliteCas()) ? 150 : 200;
        float superiors_per_task = number_killed_with_bracelet/kills_per_superior;
        float modified_superiors_per_heart = (float)((base_superiors_per_heart * 100.0) / (100.0 + drop_modifier));
        return modified_superiors_per_heart/superiors_per_task;
    }

    public void update_task(int id, String name, String modifier, int magnitude)
    {
        taskboxes[id].update_task(name, modifier, magnitude);
    }

    public void update()
    {
        int[] ticks_wasted = {99999999, 99999999, 99999999};
        int numer_valid = 0;
        for(int box = 0; box < 3; box++)
        {
            if(taskboxes[box] != null && taskboxes[box].getName() != null)
            {
                if(Objects.equals(taskboxes[box].getName(), "none"))
                {
                    taskboxes[box].ticks_wasted.setText("");
                }
                else
                {
                    numer_valid += 1;
                    taskboxes[box].ticks_wasted.setVisible(config.showTimeWasted());
                    TaskStats task_stats = new TaskStats(taskboxes[box].getName());
                    ticks_wasted[box] = calcTicksWasted(task_stats, taskboxes[box].getLengthModifier(), taskboxes[box].getDropModifier(), 0, false);
                    taskboxes[box].ticks_wasted.setText(Integer.toString(ticks_wasted[box]));
                }
            }
        }
        if(numer_valid > 1)
        {
            int best_rating = 99999999;
            int best_rating_index = -1;
            // choose the best option and generate output
            for(int rating = 0; rating < 3; rating++)
            {
                if(ticks_wasted[rating] < best_rating)
                {
                    best_rating = ticks_wasted[rating];
                    best_rating_index = rating;
                }
            }
            String final_output = "<html>Choose ";
            final_output += taskboxes[best_rating_index].getName();
            final_output += ", and use ";
            final_output += best_rating < 0 ? "a <b>slaughter</b> bracelet.<br><br><B>USE</B> your slayer cape after the task." : "an <b>expeditious</b> bracelet.<br><br><B>DO NOT</B> use your slayer cape after the task.";
            final_output += "</html>";
            output_box.setText(final_output);
            plugin.best_rating_index = best_rating_index;
        }
    }
}
