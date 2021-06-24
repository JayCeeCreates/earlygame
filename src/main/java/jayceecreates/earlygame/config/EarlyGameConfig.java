package jayceecreates.earlygame.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "earlygame")
public class EarlyGameConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip(count = 5)
    public boolean warningMessage = false;

    @ConfigEntry.Gui.Tooltip(count = 6)
    @ConfigEntry.Gui.RequiresRestart
    public boolean generateStones = true;

    @ConfigEntry.Gui.Tooltip(count = 6)
    @ConfigEntry.Gui.RequiresRestart
    public boolean generateSticks = true;

    @ConfigEntry.Gui.Tooltip(count = 4)
    public boolean harderGroundBlocks = true;

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip(count = 5)
    public Crafting crafting = new Crafting();

    public static final class Crafting implements ConfigData {
        @ConfigEntry.Gui.Tooltip(count = 4)
        public boolean enableWoodenTools = false;
        
        @ConfigEntry.Gui.Tooltip(count = 4)
        public boolean enableStoneTools = false;
        
        @ConfigEntry.Gui.Tooltip(count = 4)
        public boolean enablePlanksAndSticks = false;
        
        private Crafting() {}
    }

    @ConfigEntry.Gui.Tooltip(count = 4)
    public double damageProbability = 2.5;

    @ConfigEntry.Gui.Tooltip(count = 4)
    public double flintConsumeProb = 0.3;

    @ConfigEntry.Gui.Tooltip(count = 4)
    public double flintSuccessProb = 0.7;

    @ConfigEntry.Gui.Tooltip(count = 4)
    public double woodChoppingProb = 0.5;

    @ConfigEntry.Gui.Tooltip(count = 4)
    public double fireStartProb = 0.3;

}
