package been_fun.sculkstaffmod.creativemodetab;

import been_fun.sculkstaffmod.SculkStaff;
import been_fun.sculkstaffmod.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab SCULK_STAFF_STAFFS = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(SculkStaff.MOD_ID, "sculk_staff_staffs"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SCULK_STAFF))
                    .title(Component.translatable("creativemodetab.sculkstaffmod.sculk_staff_staffs"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.SCULK_STAFF);
                        output.accept(ModItems.WIND_STAFF);
                    }).build());

    public static final CreativeModeTab SCULK_INGREDIENTS = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(SculkStaff.MOD_ID, "sculk_ingredients"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SCULK_BONES))
                    .title(Component.translatable("creativemodetab.sculkstaffmod.sculk_ingredients"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.SCULK_CATALYST_BONES);
                        output.accept(ModItems.SCULK_SHRIEKER_BONES);
                        output.accept(ModItems.SCULK_BONES);
                        output.accept(ModItems.WARDEN_HEART);
                        output.accept(ModItems.WARDEN_TENDRIL);
                        output.accept(ModItems.TRAPPED_SOULS);
                        output.accept(ModItems.LIGHT_CORE);
                    }).build());

    public static void registerModCreativeModeTabs() {
        SculkStaff.LOGGER.info("Registering Creative Mode Tabs for " + SculkStaff.MOD_ID);
    }
}