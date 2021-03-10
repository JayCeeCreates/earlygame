package jayceecreates.earlygame.utils;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public final class ModItemTags {
	public static final Tag<Item> WOODEN_TOOLS = register("wooden_tools");
	public static final Tag<Item> STONE_TOOLS = register("stone_tools");
    public static final Tag<Item> AXES = register("axes");
	public static final Tag<Item> SAWS = register("saws");
	public static final Tag<Item> KNIVES = register("knives");
	public static final Tag<Item> ROCKS = register("rocks");

	private ModItemTags() { }

	private static Tag<Item> register(String id) {
		return TagRegistry.item(new Identifier("earlygame", id));
	}
}
