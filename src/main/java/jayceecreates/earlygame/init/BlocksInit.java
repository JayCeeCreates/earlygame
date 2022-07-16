package jayceecreates.earlygame.init;

import jayceecreates.earlygame.EarlyGame;
import jayceecreates.earlygame.block.*;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksInit {
    
    public static final Block
        STONE_ROCK_BLOCK,
        ANDESITE_ROCK_BLOCK,
        DIORITE_ROCK_BLOCK,
        GRANITE_ROCK_BLOCK,
        DEEPSLATE_ROCK_BLOCK,
        CALCITE_ROCK_BLOCK,
        TUFF_ROCK_BLOCK,
        SANDSTONE_ROCK_BLOCK,
        RED_SANDSTONE_ROCK_BLOCK,
        COBBLED_ANDESITE,
        COBBLED_DIORITE,
        COBBLED_GRANITE,
        COBBLED_CALCITE,
        COBBLED_TUFF,
        STICK_TWIG_BLOCK;

    private static void register(String name, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(EarlyGame.MOD_ID, name), block);
    }

    public static void init() {
        // rocks
        register("stone_rock_block", STONE_ROCK_BLOCK);
        register("andesite_rock_block", ANDESITE_ROCK_BLOCK);
        register("diorite_rock_block", DIORITE_ROCK_BLOCK);
        register("granite_rock_block", GRANITE_ROCK_BLOCK);
        register("deepslate_rock_block", DEEPSLATE_ROCK_BLOCK);
        register("calcite_rock_block", CALCITE_ROCK_BLOCK);
        register("tuff_rock_block", TUFF_ROCK_BLOCK);
        register("sandstone_rock_block", SANDSTONE_ROCK_BLOCK);
        register("red_sandstone_rock_block", RED_SANDSTONE_ROCK_BLOCK);

        // cobblestone
        register("cobbled_andesite", COBBLED_ANDESITE);
        register("cobbled_diorite", COBBLED_DIORITE);
        register("cobbled_granite", COBBLED_GRANITE);
        register("cobbled_calcite", COBBLED_CALCITE);
        register("cobbled_tuff", COBBLED_TUFF);

        // stick
        register("stick_twig", STICK_TWIG_BLOCK);
    }

    static {
        // rocks
        STONE_ROCK_BLOCK = new RockBlock();
        ANDESITE_ROCK_BLOCK = new RockBlock();
        DIORITE_ROCK_BLOCK = new RockBlock();
        GRANITE_ROCK_BLOCK = new RockBlock();
        DEEPSLATE_ROCK_BLOCK = new RockBlock();
        CALCITE_ROCK_BLOCK = new RockBlock();
        TUFF_ROCK_BLOCK = new RockBlock();
        SANDSTONE_ROCK_BLOCK = new RockBlock();
        RED_SANDSTONE_ROCK_BLOCK = new RockBlock();
        
        // cobblestone
        COBBLED_ANDESITE = new CobblestoneBlock();
        COBBLED_DIORITE = new CobblestoneBlock();
        COBBLED_GRANITE = new CobblestoneBlock();
        COBBLED_CALCITE = new CobbledCalciteBlock();
        COBBLED_TUFF = new CobbledTuffBlock();

        // stick
        STICK_TWIG_BLOCK = new StickTwigBlock();
    }
}