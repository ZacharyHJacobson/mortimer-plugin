package com.mortimercalculator;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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

    /**
     * Creates a box of text for use at the bottom of the side panel.
     * This box will be updated with suggestions, such as what task to pick and bracelet to use.
     * @return the suggestion JPanel
     */
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

    /**
     * Calculates the number of ticks wasted on the way to an imbued heart by picking a given task.
     * This is calculated by comparing the time to obtain the heart if the task was repeated forever,
     * comparing it to the average heart length, and scaling to the task duration.
     * @param task_stats data for the task's monster
     * @param length_modifier negative if length is reduced, positive if increased, 0 if other modifier is present instead
     * @param drop_modifier the percentage increase, ie +300% would be 300, not 3
     * @param number_assigned number assigned; 0 if unknown, average length will be calculated using TaskStats
     * @param slaughter slaughter bracelet if true, expeditious if false; if false and ticks wasted is negative, recalculates with slaughter
     * @return the expected ticks wasted by picking the task, negative if spamming the task would be faster than Mortimer
     */
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

    /**
     * average kills per task given the minimum and maximum within a TaskStats object and length modifier if present
     * @param task_stats data for the task's monster
     * @param length_modifier negative if length is reduced, positive if increased, 0 if other modifier is present instead
     * @return average kills per task
     */
    private float killsPerTask(TaskStats task_stats, int length_modifier)
    {
        float task_length = (float)(task_stats.assign_min + task_stats.assign_max)/2;
        task_length += length_modifier;
        return task_length;
    }

    /**
     * Modifies the expected kills per task depending on which bracelet is worn
     * @param number_assigned pre-bracelet kills expected
     * @param slaughter slaughter bracelet if true, expeditious if false
     * @return bracelet-modified expected kills per task
     */
    private float applyBracelet(float number_assigned, boolean slaughter)
    {
        return number_assigned * (float)((slaughter) ? (4.0/3.0) : (.8));
    }

    /**
     * Calculates the expected time between accepting a task and accepting the next task, including
     * banking, travel, and completing the task.
     * @param task_stats data for the task's monster
     * @param number_killed_with_bracelet average monsters killed during the task
     * @return ticks taken to complete the task truncated
     */
    private int timePerTask(TaskStats task_stats, float number_killed_with_bracelet)
    {
        int time = config.prepTime() + task_stats.travel_time;
        time += (int)(number_killed_with_bracelet/task_stats.kills_per_hour * 6000);	//! let users input eventually
        return time;
    }

    /**
     * Calculates the expected number of times the task would need to be picked to hit the rate for one imbued heart.
     * @param base_superiors_per_heart task-specific droprate before modifier
     * @param number_killed_with_bracelet average monsters killed during the task
     * @param drop_modifier the percentage increase, ie +300% would be 300, not 3
     * @return expected tasks per heart
     */
    private float tasksPerHeart(int base_superiors_per_heart, float number_killed_with_bracelet, int drop_modifier)
    {
        int kills_per_superior = (config.eliteCas()) ? 150 : 200;
        float superiors_per_task = number_killed_with_bracelet/kills_per_superior;
        float modified_superiors_per_heart = (float)((base_superiors_per_heart * 100.0) / (100.0 + drop_modifier));
        return modified_superiors_per_heart/superiors_per_task;
    }

    /**
     * update a specific taskbox in the side panel
     * @param id taskbox id, 0 1 or 2
     * @param name task name
     * @param modifier modifier name
     * @param magnitude positive or negative variant of the modifier
     */
    public void update_task(int id, String name, String modifier, int magnitude)
    {
        taskboxes[id].update_task(name, modifier, magnitude);
    }

    /**
     * update the suggestion box JPanel with what the best task is and what bracelet to use
     * @return index of the best task
     */
    public int update()
    {
        int[] ticks_wasted = {99999999, 99999999, 99999999};
        int valid_tasks = 0;
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
                    valid_tasks += 1;
                    taskboxes[box].ticks_wasted.setVisible(config.showTimeWasted());
                    TaskStats task_stats = new TaskStats(taskboxes[box].getName());
                    ticks_wasted[box] = calcTicksWasted(task_stats, taskboxes[box].getLengthModifier(), taskboxes[box].getDropModifier(), 0, false);
                    taskboxes[box].ticks_wasted.setText(Integer.toString(ticks_wasted[box]));
                }
            }
        }
        if(valid_tasks > 1)
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
            return(best_rating_index);
        }
        return -1;
    }

    /**
     * set of modifiable aspects of a single slayer task, the calculator's panel has three Taskboxes
     */
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

            monster_box = new JComboBox<>(MortimerConstants.MONSTERS);
            monster_box.setFont(FontManager.getRunescapeBoldFont());
            monster_box.setForeground(Color.yellow);
            monster_box.addActionListener(event -> update());
            task_box.add(monster_box);

            modifier_box = new JComboBox<>(MortimerConstants.MODIFIERS);
            modifier_box.setFont(FontManager.getRunescapeFont());
            modifier_box.setForeground(Color.yellow);
            modifier_box.addActionListener(event -> update());
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
                        } catch (Exception ignored) {}
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
            magnitude.addActionListener(event -> update());
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
            for(int name_index = 0; name_index < MortimerConstants.MONSTERS.length; name_index++)
            {
                if(Objects.equals(MortimerConstants.MONSTERS[name_index], name))
                    monster_box.setSelectedIndex(name_index);
            }

            for(int modifier_index = 0; modifier_index < MortimerConstants.MODIFIERS.length; modifier_index++)
            {
                if(Objects.equals(MortimerConstants.MODIFIERS[modifier_index], modifier))
                    modifier_box.setSelectedIndex(modifier_index);
            }

            magnitude.setValue(new_magnitude);
        }
    }
}
