package jayceecreates.earlygame.utils;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public enum WoodType {
    // logs
    OAK_LOG(Blocks.OAK_LOG, Blocks.OAK_PLANKS),
    SPRUCE_LOG(Blocks.SPRUCE_LOG, Blocks.SPRUCE_PLANKS),
    BIRCH_LOG(Blocks.BIRCH_LOG, Blocks.BIRCH_PLANKS),
    JUNGLE_LOG(Blocks.JUNGLE_LOG, Blocks.JUNGLE_PLANKS),
    ACACIA_LOG(Blocks.ACACIA_LOG, Blocks.ACACIA_PLANKS),
    DARK_OAK_LOG(Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_PLANKS),
    CRIMSON_STEM(Blocks.CRIMSON_STEM, Blocks.CRIMSON_PLANKS),
    WARPED_STEM(Blocks.WARPED_STEM, Blocks.WARPED_PLANKS),
    STRIPPED_OAK_LOG(Blocks.STRIPPED_OAK_LOG, Blocks.OAK_PLANKS),
    STRIPPED_SPRUCE_LOG(Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_PLANKS),
    STRIPPED_BIRCH_LOG(Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_PLANKS),
    STRIPPED_JUNGLE_LOG(Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_PLANKS),
    STRIPPED_ACACIA_LOG(Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_PLANKS),
    STRIPPED_DARK_OAK_LOG(Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_PLANKS),
    STRIPPED_CRIMSON_STEM(Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_PLANKS),
    STRIPPED_WARPED_STEM(Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_PLANKS),

    // four-sided wood
    OAK_WOOD(Blocks.OAK_WOOD, Blocks.OAK_PLANKS),
    SPRUCE_WOOD(Blocks.SPRUCE_WOOD, Blocks.SPRUCE_PLANKS),
    BIRCH_WOOD(Blocks.BIRCH_WOOD, Blocks.BIRCH_PLANKS),
    JUNGLE_WOOD(Blocks.JUNGLE_WOOD, Blocks.JUNGLE_PLANKS),
    ACACIA_WOOD(Blocks.ACACIA_WOOD, Blocks.ACACIA_PLANKS),
    DARK_OAK_WOOD(Blocks.DARK_OAK_WOOD, Blocks.DARK_OAK_PLANKS),
    CRIMSON_HYPHAE(Blocks.CRIMSON_HYPHAE, Blocks.CRIMSON_PLANKS),
    WARPED_HYPHAE(Blocks.WARPED_HYPHAE, Blocks.WARPED_PLANKS),
    STRIPPED_OAK_WOOD(Blocks.STRIPPED_OAK_WOOD, Blocks.OAK_PLANKS),
    STRIPPED_SPRUCE_WOOD(Blocks.STRIPPED_SPRUCE_WOOD, Blocks.SPRUCE_PLANKS),
    STRIPPED_BIRCH_WOOD(Blocks.STRIPPED_BIRCH_WOOD, Blocks.BIRCH_PLANKS),
    STRIPPED_JUNGLE_WOOD(Blocks.STRIPPED_JUNGLE_WOOD, Blocks.JUNGLE_PLANKS),
    STRIPPED_ACACIA_WOOD(Blocks.STRIPPED_ACACIA_WOOD, Blocks.ACACIA_PLANKS),
    STRIPPED_DARK_OAK_WOOD(Blocks.STRIPPED_DARK_OAK_WOOD, Blocks.DARK_OAK_PLANKS),
    STRIPPED_CRIMSON_HYPHAE(Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.CRIMSON_PLANKS),
    STRIPPED_WARPED_HYPHAE(Blocks.STRIPPED_WARPED_HYPHAE, Blocks.WARPED_PLANKS);

    private final Block inputBlock;
    private final Block outputBlock;

    private WoodType(Block inputBlock, Block outputBlock) {
        this.inputBlock = inputBlock;
        this.outputBlock = outputBlock;
    }

    public Block getInputBlock() {
        return this.inputBlock;
    }

    public Block getOutputBlock() {
        return this.outputBlock;
    }

    public static WoodType getType(int i) {
        WoodType[] types = values();
        if (i < 0 || i >= types.length) {
            i = 0;
        }

        return types[i];
    }

    public static WoodType getType(Block block) {
        WoodType[] types = values();

        for(int i = 0; i < types.length; ++i) {
            if (types[i].getInputBlock() == block) {
                return types[i];
            }
        }

        return types[0];
    }
}