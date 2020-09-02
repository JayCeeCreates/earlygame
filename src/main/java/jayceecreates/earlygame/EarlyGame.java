package jayceecreates.earlygame;

import jayceecreates.earlygame.block.*;
import jayceecreates.earlygame.utils.DisableWoodStoneTools;
import jayceecreates.earlygame.utils.RequiredTool;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EarlyGame implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("EarlyGame");

    public static final ItemGroup EARLYGAME = FabricItemGroupBuilder.build(
        new Identifier("earlygame", "eggroup"),
        () -> new ItemStack(Items.FLINT));
    
    // rocks
    public static final Block STONE_ROCK_BLOCK = new RockBlock();
    public static final Block ANDESITE_ROCK_BLOCK = new RockBlock();
    public static final Block DIORITE_ROCK_BLOCK = new RockBlock();
    public static final Block GRANITE_ROCK_BLOCK = new RockBlock();
    
    // cobblestone
    public static final Block ANDESITE_COBBLESTONE = new Cobblestone();
    public static final Block DIORITE_COBBLESTONE = new Cobblestone();
    public static final Block GRANITE_COBBLESTONE = new Cobblestone();

    // copper
    public static final Block COPPER_ORE = new CopperOre();
    public static final Block COPPER_BLOCK = new CopperBlock();
    public static final Item COPPER_INGOT = new Item(new Item.Settings().group(EarlyGame.EARLYGAME));
    public static final Item COPPER_NUGGET = new Item(new Item.Settings().group(EarlyGame.EARLYGAME));

    // stick
    public static final Block STICK_TWIG_BLOCK = new StickTwigBlock();

    public static ConfiguredFeature<?, ?> COPPER_ORE_GEN = Feature.ORE
        .configure(new OreFeatureConfig(
            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            COPPER_ORE.getDefaultState(),
            9))
        .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 64)))
        .spreadHorizontally()
        .repeat(20);

    @Override
    public void onInitialize() {

        // rocks
        Registry.register(Registry.ITEM, new Identifier("earlygame", "stone_rock"), new BlockItem(STONE_ROCK_BLOCK, new Item.Settings().group(EarlyGame.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "andesite_rock"), new BlockItem(ANDESITE_ROCK_BLOCK, new Item.Settings().group(EarlyGame.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "diorite_rock"), new BlockItem(DIORITE_ROCK_BLOCK, new Item.Settings().group(EarlyGame.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "granite_rock"), new BlockItem(GRANITE_ROCK_BLOCK, new Item.Settings().group(EarlyGame.EARLYGAME)));
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "stone_rock_block"), STONE_ROCK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "andesite_rock_block"), ANDESITE_ROCK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "diorite_rock_block"), DIORITE_ROCK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "granite_rock_block"), GRANITE_ROCK_BLOCK);

        // cobblestone
        Registry.register(Registry.ITEM, new Identifier("earlygame", "andesite_cobblestone"), new BlockItem(ANDESITE_COBBLESTONE, new Item.Settings().group(EarlyGame.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "diorite_cobblestone"), new BlockItem(DIORITE_COBBLESTONE, new Item.Settings().group(EarlyGame.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "granite_cobblestone"), new BlockItem(GRANITE_COBBLESTONE, new Item.Settings().group(EarlyGame.EARLYGAME)));
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "andesite_cobblestone"), ANDESITE_COBBLESTONE);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "diorite_cobblestone"), DIORITE_COBBLESTONE);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "granite_cobblestone"), GRANITE_COBBLESTONE);

        // copper
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_ore"), new BlockItem(COPPER_ORE, new Item.Settings().group(EarlyGame.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_block"), new BlockItem(COPPER_BLOCK, new Item.Settings().group(EarlyGame.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_ingot"), COPPER_INGOT);
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_nugget"), COPPER_NUGGET);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "copper_ore"), COPPER_ORE);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "copper_block"), COPPER_BLOCK);
        
        // stick
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "stick_twig"), STICK_TWIG_BLOCK);
        BlockRenderLayerMap.INSTANCE.putBlock(STICK_TWIG_BLOCK, RenderLayer.getCutout());

        // world gen
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("earlygame", "copper_ore_gen"), COPPER_ORE_GEN);
        
        // noBreak
        RequiredTool.noBreak(Material.WOOD, FabricToolTags.AXES, "You need an axe to cut wood!"); // wood cutting
        RequiredTool.noBreak(Material.NETHER_WOOD, FabricToolTags.AXES, "You need an axe to cut wood!"); // wood cutting
        RequiredTool.noBreak(Material.BAMBOO, FabricToolTags.AXES, "You need an axe to cut wood!"); // bamboo cutting
        RequiredTool.noBreak(Material.STONE, FabricToolTags.PICKAXES, "You need a pickaxe to mine!"); // mining
        RequiredTool.noBreak(Material.REPAIR_STATION, FabricToolTags.PICKAXES, "You need a pickaxe to mine!"); // mining
        RequiredTool.noBreak(Material.METAL, FabricToolTags.PICKAXES, "You need a pickaxe to mine!"); // mining

        // noStoneWoodTier
        DisableWoodStoneTools.noStoneWoodTier();

    }

    
}