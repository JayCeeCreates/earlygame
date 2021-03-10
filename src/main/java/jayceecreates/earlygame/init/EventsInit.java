package jayceecreates.earlygame.init;

import jayceecreates.earlygame.utils.DisableWoodStoneTools;
import jayceecreates.earlygame.utils.FlintKnapEvent;
import jayceecreates.earlygame.utils.FlintKnifeKnapEvent;
import jayceecreates.earlygame.utils.RecipeRemover;
import jayceecreates.earlygame.utils.WoodCuttingEvent;

public class EventsInit {
    public static void init() {
        DisableWoodStoneTools.noStoneWoodTier();
        FlintKnapEvent.knapEvent();
        FlintKnifeKnapEvent.knifeKnapEvent();
        WoodCuttingEvent.chopEvent();
        RecipeRemover.removeRecipe();
    }
}
