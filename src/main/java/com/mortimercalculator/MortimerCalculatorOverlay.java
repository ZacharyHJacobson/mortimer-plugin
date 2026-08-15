package com.mortimercalculator;

import lombok.Setter;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;

public class MortimerCalculatorOverlay extends Overlay
{
    private Color highlight_color = Color.GREEN;

    private final MortimerCalculatorPlugin plugin;
    Widget[] task_widgets = new Widget[3];
    private int best_task_id;
    @Setter
    private MortimerCalculatorPanel panel;

    @Inject
    private MortimerCalculatorOverlay(MortimerCalculatorPlugin mortimerCalculatorPlugin)
    {
        this.plugin = mortimerCalculatorPlugin;

        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
    }

    public void setHighlightedTaskIndex(int new_best_task_index, Color new_highlight_color)
    {
        highlight_color = new_highlight_color;
        best_task_id = new_best_task_index;
    }

    /**
     * Parse the Mortimer task selection widget and keep track of the subwidgets for each task.
     * @param task_widget parent widget for Mortimer's overlay
     */
    public void setTaskWidget(Widget task_widget)
    {
        Widget[] subwidgets = task_widget.getDynamicChildren();
        int matches = 0;
        for(int x = 1; x < subwidgets.length- 4; x++)
        {
            // quantity subwidget is one index after the task name and four subwidgets before the modifier subwidget
            if(subwidgets[x].getText().contains("Amount: "))
            {
                panel.update_task(matches,
                        subwidgets[x-1].getText().split(">")[1],
                        Integer.parseInt(subwidgets[x].getText().split("Amount: ")[1].split(" to ")[0]),
                        Integer.parseInt(subwidgets[x].getText().split(" to ")[1]),
                        subwidgets[x+4].getText().substring(subwidgets[x+4].getText().indexOf(" ") + 1),
                        Integer.parseInt(subwidgets[x+4].getText().split(" ")[0].split("%")[0]));
                task_widgets[matches] = subwidgets[x-2];
                matches++;
            }
        }
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if(plugin.mortimer_open && task_widgets[best_task_id] != null)
        {
            if(task_widgets[best_task_id].isHidden())
            {
                plugin.mortimerClosed();
            }
            else
            {
                Rectangle bestTaskRect = task_widgets[best_task_id].getBounds();
                graphics.setColor(highlight_color);
                graphics.draw(bestTaskRect);
            }
        }
        return null;
    }
}
