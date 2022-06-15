package jayceecreates.earlygame.utils;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ModItemTags {
	public static final TagKey<Item> WOODEN_TOOLS = register("wooden_tools");
	public static final TagKey<Item> STONE_TOOLS = register("stone_tools");
    public static final TagKey<Item> AXES = register("axes");
	public static final TagKey<Item> SAWS = register("saws");
	public static final TagKey<Item> KNIVES = register("knives");
	public static final TagKey<Item> ROCKS = register("rocks");

	private ModItemTags() { }

	private static TagKey<Item> register(String id) {
		return TagKey.of(Registry.ITEM_KEY, new Identifier("earlygame", id));
	}
}
