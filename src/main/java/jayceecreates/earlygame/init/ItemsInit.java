package jayceecreates.earlygame.init;

import jayceecreates.earlygame.armor.BaseArmor;
import jayceecreates.earlygame.armor.CopperArmorBase;
import jayceecreates.earlygame.item.*;
import jayceecreates.earlygame.item.tool.copper_tier.*;
import jayceecreates.earlygame.item.tool.flint_tier.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemsInit {

    // plant
    public static final Item PLANT_FIBER = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item LASHING = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));

    // flint
    public static final Item FLINT_SHARD = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item FLINT_KNIFE = new FlintKnife(new FlintToolBase());
    public static final Item FLINT_PICKAXE = new FlintPickaxe(new FlintToolBase());
    public static final Item FLINT_AXE = new FlintAxe(new FlintToolBase());

    // copper
    public static final Item COPPER_INGOT = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item COPPER_NUGGET = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final ArmorMaterial COPPER_ARMOR = new CopperArmorBase();
    public static final Item COPPER_SWORD = new CopperSword(new CopperToolBase());
    public static final Item COPPER_KNIFE = new CopperKnife(new CopperToolBase());
    public static final Item COPPER_SHOVEL = new CopperShovel(new CopperToolBase());
    public static final Item COPPER_PICKAXE = new CopperPickaxe(new CopperToolBase());
    public static final Item COPPER_AXE = new CopperAxe(new CopperToolBase());
    public static final Item COPPER_HOE = new CopperHoe(new CopperToolBase());

    public static void init() {

        // plant
        Registry.register(Registry.ITEM, new Identifier("earlygame", "plant_fiber"), PLANT_FIBER);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "lashing"), LASHING);

        // flint
        Registry.register(Registry.ITEM, new Identifier("earlygame", "flint_shard"), FLINT_SHARD);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "flint_pickaxe"), FLINT_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "flint_axe"), FLINT_AXE);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "flint_knife"), FLINT_KNIFE);

        // copper
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_ingot"), COPPER_INGOT);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_nugget"), COPPER_NUGGET);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_helmet"), new BaseArmor(COPPER_ARMOR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_chestplate"), new BaseArmor(COPPER_ARMOR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_leggings"), new BaseArmor(COPPER_ARMOR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_boots"), new BaseArmor(COPPER_ARMOR, EquipmentSlot.FEET));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_sword"), COPPER_SWORD);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_knife"), COPPER_KNIFE);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_shovel"), COPPER_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_pickaxe"), COPPER_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_axe"), COPPER_AXE);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_hoe"), COPPER_HOE);

    }

    
}