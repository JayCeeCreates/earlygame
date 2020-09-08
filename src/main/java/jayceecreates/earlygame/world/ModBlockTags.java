package jayceecreates.earlygame.world;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public final class ModBlockTags {
    public static final Tag<Block> ROCK_PLACEABLE_ON = register("rock_placeable_on");

	private ModBlockTags() { }

	private static Tag<Block> register(String id) {
		return TagRegistry.block(new Identifier("earlygame", id));
	}
}
