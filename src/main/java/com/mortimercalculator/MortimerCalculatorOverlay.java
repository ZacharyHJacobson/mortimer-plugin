package com.mortimercalculator;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;

public class MortimerCalculatorOverlay extends Overlay
{
    private final Client client;
    private final MortimerCalculatorPlugin plugin;
    private final MortimerCalculatorConfig config;

    @Inject
    private MortimerCalculatorOverlay(Client client, MortimerCalculatorPlugin mortimerCalculatorPlugin, MortimerCalculatorConfig mortimerCalculatorConfig)
    {
        this.client = client;
        this.plugin = mortimerCalculatorPlugin;
        this.config = mortimerCalculatorConfig;

        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if(plugin.mortimer_open && plugin.best_rating_index > -1 && plugin.task_widgets[plugin.best_rating_index] != null)
        {
            if(plugin.task_widgets[plugin.best_rating_index].isHidden())
            {
                if(config.hideWhenAway()) plugin.removeNavPanel();
            }
            else
            {
                Rectangle bestTaskRect = plugin.task_widgets[plugin.best_rating_index].getBounds();
                graphics.setColor(Color.GREEN);
                graphics.draw(bestTaskRect);
            }
        }
        return null;
    }
}
