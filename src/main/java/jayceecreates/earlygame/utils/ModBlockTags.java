package jayceecreates.earlygame.utils;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public final class ModBlockTags {
    public static final Tag<Block> ROCK_PLACEABLE_ON = register("rock_placeable_on");
	public static final Tag<Block> ROCKS = register("rocks");
	public static final Tag<Block> SLOW_DIGGING = register("slow_digging");
	public static final Tag<Block> BLACKLISTED_BLOCKS = register("blacklisted_blocks");

	private ModBlockTags() { }

	private static Tag<Block> register(String id) {
		return TagRegistry.block(new Identifier("earlygame", id));
	}
}
