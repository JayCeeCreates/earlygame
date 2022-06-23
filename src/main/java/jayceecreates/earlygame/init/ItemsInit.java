package jayceecreates.earlygame.init;

import jayceecreates.earlygame.EarlyGame;
import jayceecreates.earlygame.armor.BaseArmor;
import jayceecreates.earlygame.armor.CopperArmorBase;
import jayceecreates.earlygame.item.*;
import jayceecreates.earlygame.item.tool.base_tools.*;
import jayceecreates.earlygame.item.tool.flint_tier.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static jayceecreates.earlygame.init.BlocksInit.*;

public class ItemsInit {

    // plant
    public static final Item PLANT_FIBER = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item LASHING = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));

    // tools
    public static final Item FIRE_STARTER = new FireStarterItem(new Item.Settings().maxDamage(64).group(ModItemGroup.EARLYGAME));
    public static final Item SLINGSHOT = new SlingshotItem(new Item.Settings().maxDamage(64).group(ModItemGroup.EARLYGAME));

    // rocks
    public static final Item STONE_ROCK = new BlockItem(BlocksInit.STONE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item ANDESITE_STONE_ROCK = new BlockItem(BlocksInit.ANDESITE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item DIORITE_STONE_ROCK = new BlockItem(BlocksInit.DIORITE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item GRANITE_STONE_ROCK = new BlockItem(BlocksInit.GRANITE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item DEEPSLATE_STONE_ROCK = new BlockItem(BlocksInit.DEEPSLATE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item CALCITE_STONE_ROCK = new BlockItem(BlocksInit.CALCITE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item TUFF_STONE_ROCK = new BlockItem(BlocksInit.TUFF_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item SANDSTONE_ROCK = new BlockItem(BlocksInit.SANDSTONE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item RED_SANDSTONE_ROCK = new BlockItem(BlocksInit.RED_SANDSTONE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));

    // flint
    public static final Item FLINT_SHARD = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item FLINT_KNIFE = new FlintKnife(new FlintToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item FLINT_PICKAXE = new FlintPickaxe(new FlintToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item FLINT_AXE = new FlintAxe(new FlintToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item FLINT_SAW = new FlintSaw(new FlintToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));

    // copper
    public static final Item COPPER_NUGGET = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final ArmorMaterial COPPER_ARMOR = new CopperArmorBase();
    public static final Item COPPER_SWORD = new SwordBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item COPPER_KNIFE = new KnifeBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item COPPER_SHOVEL = new ShovelBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item COPPER_PICKAXE = new PickaxeBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item COPPER_AXE = new AxeBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item COPPER_SAW = new SawBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item COPPER_HOE = new HoeBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));

    // iron
    public static final Item IRON_KNIFE = new KnifeBase(ToolMaterials.IRON, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item IRON_SAW = new SawBase(ToolMaterials.IRON, new Item.Settings().group(ModItemGroup.EARLYGAME));

    // gold
    public static final Item GOLDEN_KNIFE = new KnifeBase(ToolMaterials.GOLD, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item GOLDEN_SAW = new SawBase(ToolMaterials.GOLD, new Item.Settings().group(ModItemGroup.EARLYGAME));

    // diamond
    public static final Item DIAMOND_KNIFE = new KnifeBase(ToolMaterials.DIAMOND, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item DIAMOND_SAW = new SawBase(ToolMaterials.DIAMOND, new Item.Settings().group(ModItemGroup.EARLYGAME));

    // netherite
    public static final Item NETHERITE_KNIFE = new KnifeBase(ToolMaterials.NETHERITE, new Item.Settings().group(ModItemGroup.EARLYGAME));
    public static final Item NETHERITE_SAW = new SawBase(ToolMaterials.NETHERITE, new Item.Settings().group(ModItemGroup.EARLYGAME));

    private static void add(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(EarlyGame.MOD_ID, name), item);
    }

    public static void init() {

        // rocks
        add("stone_rock", STONE_ROCK);
        add("andesite_rock", ANDESITE_STONE_ROCK);
        add("diorite_rock", DIORITE_STONE_ROCK);
        add("granite_rock", GRANITE_STONE_ROCK);
        add("deepslate_rock", DEEPSLATE_STONE_ROCK);
        add("calcite_rock", CALCITE_STONE_ROCK);
        add("tuff_rock", TUFF_STONE_ROCK);
        add("sandstone_rock", SANDSTONE_ROCK);
        add("red_sandstone_rock", RED_SANDSTONE_ROCK);

        // cobblestone
        add("cobbled_andesite", new BlockItem(COBBLED_ANDESITE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        add("cobbled_diorite", new BlockItem(COBBLED_DIORITE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        add("cobbled_granite", new BlockItem(COBBLED_GRANITE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        add("cobbled_calcite", new BlockItem(COBBLED_CALCITE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        add("cobbled_tuff", new BlockItem(COBBLED_TUFF, new Item.Settings().group(ModItemGroup.EARLYGAME)));

        // plant
        add("plant_fiber", PLANT_FIBER);
        add("lashing", LASHING);

        // fire starter
        add("fire_starter", FIRE_STARTER);
        add("slingshot", SLINGSHOT);

        // flint
        add("flint_shard", FLINT_SHARD);
        add("flint_pickaxe", FLINT_PICKAXE);
        add("flint_axe", FLINT_AXE);
        add("flint_knife", FLINT_KNIFE);
        add("flint_saw", FLINT_SAW);

        // copper
        add("copper_nugget", COPPER_NUGGET);
        add("copper_helmet", new BaseArmor(COPPER_ARMOR, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        add("copper_chestplate", new BaseArmor(COPPER_ARMOR, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        add("copper_leggings", new BaseArmor(COPPER_ARMOR, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        add("copper_boots", new BaseArmor(COPPER_ARMOR, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        add("copper_sword", COPPER_SWORD);
        add("copper_knife", COPPER_KNIFE);
        add("copper_shovel", COPPER_SHOVEL);
        add("copper_pickaxe", COPPER_PICKAXE);
        add("copper_axe", COPPER_AXE);
        add("copper_saw", COPPER_SAW);
        add("copper_hoe", COPPER_HOE);

        // iron
        add("iron_knife", IRON_KNIFE);
        add("iron_saw", IRON_SAW);

        // gold
        add("golden_knife", GOLDEN_KNIFE);
        add("golden_saw", GOLDEN_SAW);

        // diamond
        add("diamond_knife", DIAMOND_KNIFE);
        add("diamond_saw", DIAMOND_SAW);

        // netherite (prefix is dumb please replace it with ancient prefix)
        add("netherite_knife", NETHERITE_KNIFE);
        add("netherite_saw", NETHERITE_SAW);

    }

    
}