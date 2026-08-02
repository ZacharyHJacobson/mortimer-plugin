package com.mortimercalculator;

import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;

public class MortimerCalculatorOverlay extends Overlay
{
    private final MortimerCalculatorPlugin plugin;
    private Widget task_widget;

    @Inject
    private MortimerCalculatorOverlay(MortimerCalculatorPlugin mortimerCalculatorPlugin)
    {
        this.plugin = mortimerCalculatorPlugin;

        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
    }

    public void updateTaskWidget(Widget new_task_widget)
    {
        task_widget = new_task_widget;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if(plugin.mortimer_open && task_widget != null)
        {
            if(task_widget.isHidden())
            {
                plugin.mortimerClosed();
            }
            else
            {
                Rectangle bestTaskRect = task_widget.getBounds();
                graphics.setColor(Color.GREEN);
                graphics.draw(bestTaskRect);
            }
        }
        return null;
    }
}
