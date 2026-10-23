package been_fun.sculkstaffmod.item;

import been_fun.sculkstaffmod.SculkStaff;
import been_fun.sculkstaffmod.item.custom.SculkStaffItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;

    }

    public class SculkStaffItems implements ModInitializer {
        @Override
        public void onInitialize() {
            ModItems.initialize();
        }
    }

    public static void initialize() {
    }

    public class ModItemIds {
        public static ResourceKey<Item> create(String name) {
            // Create the item key.
            return ResourceKey.create(Registries.ITEM, SculkStaff.id(name));
        }
        public static ResourceKey<Item> getRK(Item item) {
            return BuiltInRegistries.ITEM.getResourceKey(item).get();
        }
    }

    public static final Item SCULK_CATALYST_BONES = registerItem("sculk_catalyst_bones", properties ->
            new Item(properties.stacksTo(16)));
    public static final Item SCULK_SHRIEKER_BONES = registerItem("sculk_shrieker_bones", properties ->
            new Item(properties.stacksTo(16)));
    public static final Item SCULK_BONES = registerItem("sculk_bones", properties ->
            new Item(properties.stacksTo(32)));
    public static final Item WARDEN_HEART = registerItem("warden_heart", properties ->
            new Item(properties.stacksTo(16)));
    public static final Item WARDEN_TENDRIL = registerItem("warden_tendril", properties ->
            new Item(properties.stacksTo(16)));
    public static final Item TRAPPED_SOULS = registerItem("trapped_souls", properties ->
            new Item(properties.stacksTo(16)));

    public static final Item SCULK_STAFF = registerItem("sculk_staff_item", properties ->
            new SculkStaffItem(properties.stacksTo(1).useCooldown(0.25f)));


    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(SculkStaff.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(SculkStaff.MOD_ID,name)))));
    }

    public static void registerModItems() {
        SculkStaff.LOGGER.info("Registering Mod Items for " + SculkStaff.MOD_ID);
    }
}