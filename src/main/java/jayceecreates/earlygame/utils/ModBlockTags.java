package jayceecreates.earlygame.utils;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ModBlockTags {
    public static final TagKey<Block> ROCK_PLACEABLE_ON = register("rock_placeable_on");
	public static final TagKey<Block> ROCKS = register("rocks");
	public static final TagKey<Block> SLOW_DIGGING = register("slow_digging");
	public static final TagKey<Block> BLACKLISTED_BLOCKS = register("blacklisted_blocks");

	private ModBlockTags() { }

	private static TagKey<Block> register(String id) {
		return TagKey.of(Registry.BLOCK_KEY, new Identifier("earlygame", id));
	}
}
