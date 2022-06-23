package jayceecreates.earlygame.init;

import jayceecreates.earlygame.EarlyGame;
import jayceecreates.earlygame.block.*;
import jayceecreates.earlygame.item.ModItemGroup;
import net.minecraft.block.Block;
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
    public static final Block DEEPSLATE_ROCK_BLOCK = new RockBlock();
    public static final Block CALCITE_ROCK_BLOCK = new RockBlock();
    public static final Block TUFF_ROCK_BLOCK = new RockBlock();
    public static final Block SANDSTONE_ROCK_BLOCK = new RockBlock();
    public static final Block RED_SANDSTONE_ROCK_BLOCK = new RockBlock();
    
    // cobblestone
    public static final Block COBBLED_ANDESITE = new CobblestoneBlock();
    public static final Block COBBLED_DIORITE = new CobblestoneBlock();
    public static final Block COBBLED_GRANITE = new CobblestoneBlock();
    public static final Block COBBLED_CALCITE = new CobbledCalciteBlock();
    public static final Block COBBLED_TUFF = new CobbledTuffBlock();

    // stick
    public static final Block STICK_TWIG_BLOCK = new StickTwigBlock();

    private static void add(String name, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(EarlyGame.MOD_ID, name), block);
    }

    public static void init() {
        // rocks
        add("stone_rock_block", STONE_ROCK_BLOCK);
        add("andesite_rock_block", ANDESITE_ROCK_BLOCK);
        add("diorite_rock_block", DIORITE_ROCK_BLOCK);
        add("granite_rock_block", GRANITE_ROCK_BLOCK);
        add("deepslate_rock_block", DEEPSLATE_ROCK_BLOCK);
        add("calcite_rock_block", CALCITE_ROCK_BLOCK);
        add("tuff_rock_block", TUFF_ROCK_BLOCK);
        add("sandstone_rock_block", SANDSTONE_ROCK_BLOCK);
        add("red_sandstone_rock_block", RED_SANDSTONE_ROCK_BLOCK);

        // cobblestone
        add("cobbled_andesite", COBBLED_ANDESITE);
        add("cobbled_diorite", COBBLED_DIORITE);
        add("cobbled_granite", COBBLED_GRANITE);
        add("cobbled_calcite", COBBLED_CALCITE);
        add("cobbled_tuff", COBBLED_TUFF);

        // stick
        add("stick_twig", STICK_TWIG_BLOCK);
    }

    
}