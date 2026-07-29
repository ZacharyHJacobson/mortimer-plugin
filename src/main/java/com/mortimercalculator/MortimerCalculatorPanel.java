package com.mortimercalculator;

import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.NumberFormat;

@Getter(AccessLevel.PACKAGE)
public class MortimerCalculatorPanel extends PluginPanel
{
    private final MortimerCalculatorPlugin plugin;
    private final MortimerCalculatorConfig config;

    private final JPanel[] taskboxes = new JPanel[3];
    private final JLabel[] ticks_wasted_labels = new JLabel[3];
    private final JPanel suggestion_box;


    @Inject
    private MortimerCalculatorPanel(MortimerCalculatorPlugin plugin, MortimerCalculatorConfig config)
    {
        this.plugin = plugin;
        this.config = config;

        setBackground(ColorScheme.DARK_GRAY_COLOR);

        for(int box = 0; box < 3; box++)
        {
            JPanel new_taskbox = CreateTaskBox(box);
            add(new_taskbox);
            taskboxes[box] = new_taskbox;
        }
        suggestion_box = CreateSuggestionBox();
        add(suggestion_box);
    }

    private JPanel CreateTaskBox(int box)
    {
        JPanel task_box = new JPanel()
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
        JComboBox<String> monster_box = new JComboBox<>(monsters_list);
        monster_box.setFont(FontManager.getRunescapeBoldFont());
        monster_box.setForeground(Color.yellow);
        task_box.add(monster_box);

        String[] modifier_list = {"Points","Assigned","Clue Chance", "Superior Unique Chance", "Slayer XP"};
        JComboBox<String> modifier_box = new JComboBox<>(modifier_list);
        modifier_box.setFont(FontManager.getRunescapeFont());
        modifier_box.setForeground(Color.yellow);
        task_box.add(modifier_box);

        JFormattedTextField magnitude = new JFormattedTextField(NumberFormat.getIntegerInstance());
        magnitude.setFont(FontManager.getRunescapeFont());
        magnitude.setForeground(Color.yellow);
        magnitude.setValue(0);
        magnitude.setHorizontalAlignment(SwingConstants.LEFT);
        task_box.add(magnitude);

        JLabel ticks_wasted = new JLabel("-67");
        ticks_wasted.setVisible(config.showTimeWasted());
        ticks_wasted.setFont(FontManager.getRunescapeSmallFont());
        ticks_wasted.setForeground(Color.yellow);
        ticks_wasted_labels[box] = ticks_wasted;
        task_box.add(ticks_wasted);

        return task_box;
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

        JLabel output = new JLabel("Nechs ig");
        output.setFont(FontManager.getRunescapeBoldFont());
        output.setForeground(Color.yellow);
        suggestion_box.add(output);

        return suggestion_box;
    }

    public void update()
    {
        for(JLabel label : ticks_wasted_labels)
        {
            label.setVisible(config.showTimeWasted());
        }
    }
}
