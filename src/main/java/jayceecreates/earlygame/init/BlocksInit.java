package jayceecreates.earlygame.init;

import jayceecreates.earlygame.block.*;
import jayceecreates.earlygame.item.ModItemGroup;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksInit {
    
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

    // stick
    public static final Block STICK_TWIG_BLOCK = new StickTwigBlock();

    public static void init() {

        // rocks
        Registry.register(Registry.ITEM, new Identifier("earlygame", "stone_rock"), new BlockItem(STONE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "andesite_rock"), new BlockItem(ANDESITE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "diorite_rock"), new BlockItem(DIORITE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "granite_rock"), new BlockItem(GRANITE_ROCK_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "stone_rock_block"), STONE_ROCK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "andesite_rock_block"), ANDESITE_ROCK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "diorite_rock_block"), DIORITE_ROCK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "granite_rock_block"), GRANITE_ROCK_BLOCK);

        // cobblestone
        Registry.register(Registry.ITEM, new Identifier("earlygame", "andesite_cobblestone"), new BlockItem(ANDESITE_COBBLESTONE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "diorite_cobblestone"), new BlockItem(DIORITE_COBBLESTONE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "granite_cobblestone"), new BlockItem(GRANITE_COBBLESTONE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "andesite_cobblestone"), ANDESITE_COBBLESTONE);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "diorite_cobblestone"), DIORITE_COBBLESTONE);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "granite_cobblestone"), GRANITE_COBBLESTONE);

        // copper
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_ore"), new BlockItem(COPPER_ORE, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        Registry.register(Registry.ITEM, new Identifier("earlygame", "copper_block"), new BlockItem(COPPER_BLOCK, new Item.Settings().group(ModItemGroup.EARLYGAME)));
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "copper_ore"), COPPER_ORE);
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "copper_block"), COPPER_BLOCK);
        
        // stick
        Registry.register(Registry.BLOCK, new Identifier("earlygame", "stick_twig"), STICK_TWIG_BLOCK);
        BlockRenderLayerMap.INSTANCE.putBlock(STICK_TWIG_BLOCK, RenderLayer.getCutout());

    }

    
}