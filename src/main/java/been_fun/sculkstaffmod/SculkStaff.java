package been_fun.sculkstaffmod;

import been_fun.sculkstaffmod.creativemodetab.ModCreativeModeTabs;
import been_fun.sculkstaffmod.item.ModItems;
import been_fun.sculkstaffmod.loot.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SculkStaff implements ModInitializer {
	public static final String MOD_ID = "sculkstaffmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModItems.registerModItems();

		LootTableEvents.MODIFY.register(ModLootTableModifiers::modifyLootTables);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
