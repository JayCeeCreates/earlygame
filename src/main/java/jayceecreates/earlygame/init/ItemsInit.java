package jayceecreates.earlygame.init;

import jayceecreates.earlygame.item.FlintToolBase;
import jayceecreates.earlygame.item.ModItemGroup;
import jayceecreates.earlygame.item.tool.FlintAxe;
import jayceecreates.earlygame.item.tool.FlintKnife;
import jayceecreates.earlygame.item.tool.FlintPickaxe;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemsInit {

    // flint
    public static final Item FLINT_PICKAXE = new FlintPickaxe(new FlintToolBase());
    public static final Item FLINT_AXE = new FlintAxe(new FlintToolBase());
    public static final Item FLINT_KNIFE = new FlintKnife(new FlintToolBase());

    // copper
    public static final Item COPPER_INGOT = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item COPPER_NUGGET = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));

    // other
    public static final Item LASHING = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));

    public static void init() {

        // flint
        Registry.register(Registry.ITEM, new Identifier("earlygame", "flint_pickaxe"), FLINT_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "flint_axe"), FLINT_AXE);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "flint_knife"), FLINT_KNIFE);

        // copper
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_ingot"), COPPER_INGOT);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_nugget"), COPPER_NUGGET);

        // other
        Registry.register(Registry.ITEM, new Identifier("earlygame", "lashing"), LASHING);

    }

    
}