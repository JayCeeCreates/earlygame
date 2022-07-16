package jayceecreates.earlygame.init;

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

public class ItemsInit {
    
    public static final Item
        PLANT_FIBER,
        LASHING,
        FIRE_STARTER,
        SLINGSHOT,
        STONE_ROCK,
        ANDESITE_STONE_ROCK,
        DIORITE_STONE_ROCK,
        GRANITE_STONE_ROCK,
        DEEPSLATE_STONE_ROCK,
        CALCITE_STONE_ROCK,
        TUFF_STONE_ROCK,
        SANDSTONE_ROCK,
        RED_SANDSTONE_ROCK,
        FLINT_SHARD,
        FLINT_KNIFE,
        FLINT_PICKAXE,
        FLINT_AXE,
        FLINT_SAW,
        COPPER_NUGGET,
        COPPER_SWORD,
        COPPER_KNIFE,
        COPPER_SHOVEL,
        COPPER_PICKAXE,
        COPPER_AXE,
        COPPER_SAW,
        COPPER_HOE,
        IRON_KNIFE,
        IRON_SAW,
        GOLDEN_KNIFE,
        GOLDEN_SAW,
        DIAMOND_KNIFE,
        DIAMOND_SAW,
        NETHERITE_KNIFE,
        NETHERITE_SAW;

    public static final ArmorMaterial COPPER_ARMOR = new CopperArmorBase();

    private static void register(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier("earlygame", name), item);
    }

    public static void init() {

        // rocks
        register("stone_rock", ItemsInit.STONE_ROCK);
        register("andesite_rock", ItemsInit.ANDESITE_STONE_ROCK);
        register("diorite_rock", ItemsInit.DIORITE_STONE_ROCK);
        register("granite_rock", ItemsInit.GRANITE_STONE_ROCK);
        register("deepslate_rock", ItemsInit.DEEPSLATE_STONE_ROCK);
        register("calcite_rock", ItemsInit.CALCITE_STONE_ROCK);
        register("tuff_rock", ItemsInit.TUFF_STONE_ROCK);
        register("sandstone_rock", ItemsInit.SANDSTONE_ROCK);
        register("red_sandstone_rock", ItemsInit.RED_SANDSTONE_ROCK);

        // stone
        register("cobbled_andesite", new BlockItem(BlocksInit.COBBLED_ANDESITE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        register("cobbled_diorite", new BlockItem(BlocksInit.COBBLED_DIORITE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        register("cobbled_granite", new BlockItem(BlocksInit.COBBLED_GRANITE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        register("cobbled_calcite", new BlockItem(BlocksInit.COBBLED_CALCITE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        register("cobbled_tuff", new BlockItem(BlocksInit.COBBLED_TUFF, new Item.Settings().group(ModItemGroup.EARLYGAME)));

        // plant
        register("plant_fiber", PLANT_FIBER);
        register("lashing", LASHING);

        // fire starter
        register("fire_starter", FIRE_STARTER);
        register("slingshot", SLINGSHOT);

        // flint
        register("flint_shard", FLINT_SHARD);
        register("flint_pickaxe", FLINT_PICKAXE);
        register("flint_axe", FLINT_AXE);
        register("flint_knife", FLINT_KNIFE);
        register("flint_saw", FLINT_SAW);

        // copper
        register("copper_nugget", COPPER_NUGGET);
        register("copper_sword", COPPER_SWORD);
        register("copper_knife", COPPER_KNIFE);
        register("copper_shovel", COPPER_SHOVEL);
        register("copper_pickaxe", COPPER_PICKAXE);
        register("copper_axe", COPPER_AXE);
        register("copper_saw", COPPER_SAW);
        register("copper_hoe", COPPER_HOE);
        register("copper_helmet", new BaseArmor(COPPER_ARMOR, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        register("copper_chestplate", new BaseArmor(COPPER_ARMOR, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        register("copper_leggings", new BaseArmor(COPPER_ARMOR, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        register("copper_boots", new BaseArmor(COPPER_ARMOR, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroup.EARLYGAME)));

        // iron
        register("iron_knife", IRON_KNIFE);
        register("iron_saw", IRON_SAW);

        // gold
        register("golden_knife", GOLDEN_KNIFE);
        register("golden_saw", GOLDEN_SAW);

        // diamond
        register("diamond_knife", DIAMOND_KNIFE);
        register("diamond_saw", DIAMOND_SAW);

        // netherite (prefix is dumb please replace it with ancient prefix)
        register("netherite_knife", NETHERITE_KNIFE);
        register("netherite_saw", NETHERITE_SAW);

    }

    static {
        // plant
        PLANT_FIBER = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
        LASHING = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
    
        // tools
        FIRE_STARTER = new FireStarterItem(new Item.Settings().maxDamage(64).group(ModItemGroup.EARLYGAME));
        SLINGSHOT = new SlingshotItem(new Item.Settings().maxDamage(64).group(ModItemGroup.EARLYGAME));
    
        // rocks
        STONE_ROCK = new BlockItem(BlocksInit.STONE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
        ANDESITE_STONE_ROCK = new BlockItem(BlocksInit.ANDESITE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
        DIORITE_STONE_ROCK = new BlockItem(BlocksInit.DIORITE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
        GRANITE_STONE_ROCK = new BlockItem(BlocksInit.GRANITE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
        DEEPSLATE_STONE_ROCK = new BlockItem(BlocksInit.DEEPSLATE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
        CALCITE_STONE_ROCK = new BlockItem(BlocksInit.CALCITE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
        TUFF_STONE_ROCK = new BlockItem(BlocksInit.TUFF_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
        SANDSTONE_ROCK = new BlockItem(BlocksInit.SANDSTONE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
        RED_SANDSTONE_ROCK = new BlockItem(BlocksInit.RED_SANDSTONE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME));
    
        // flint
        FLINT_SHARD = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
        FLINT_KNIFE = new FlintKnife(new FlintToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
        FLINT_PICKAXE = new FlintPickaxe(new FlintToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
        FLINT_AXE = new FlintAxe(new FlintToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
        FLINT_SAW = new FlintSaw(new FlintToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
    
        // copper
        COPPER_NUGGET = new Item(new Item.Settings().group(ModItemGroup.EARLYGAME));
        COPPER_SWORD = new SwordBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
        COPPER_KNIFE = new KnifeBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
        COPPER_SHOVEL = new ShovelBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
        COPPER_PICKAXE = new PickaxeBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
        COPPER_AXE = new AxeBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
        COPPER_SAW = new SawBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
        COPPER_HOE = new HoeBase(new CopperToolBase(), new Item.Settings().group(ModItemGroup.EARLYGAME));
    
        // iron
        IRON_KNIFE = new KnifeBase(ToolMaterials.IRON, new Item.Settings().group(ModItemGroup.EARLYGAME));
        IRON_SAW = new SawBase(ToolMaterials.IRON, new Item.Settings().group(ModItemGroup.EARLYGAME));
    
        // gold
        GOLDEN_KNIFE = new KnifeBase(ToolMaterials.GOLD, new Item.Settings().group(ModItemGroup.EARLYGAME));
        GOLDEN_SAW = new SawBase(ToolMaterials.GOLD, new Item.Settings().group(ModItemGroup.EARLYGAME));
    
        // diamond
        DIAMOND_KNIFE = new KnifeBase(ToolMaterials.DIAMOND, new Item.Settings().group(ModItemGroup.EARLYGAME));
        DIAMOND_SAW = new SawBase(ToolMaterials.DIAMOND, new Item.Settings().group(ModItemGroup.EARLYGAME));
    
        // netherite
        NETHERITE_KNIFE = new KnifeBase(ToolMaterials.NETHERITE, new Item.Settings().group(ModItemGroup.EARLYGAME));
        NETHERITE_SAW = new SawBase(ToolMaterials.NETHERITE, new Item.Settings().group(ModItemGroup.EARLYGAME));
    }

}