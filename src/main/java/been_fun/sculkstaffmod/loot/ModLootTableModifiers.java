package been_fun.sculkstaffmod.loot;

import been_fun.sculkstaffmod.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

public class ModLootTableModifiers {
    public static void modifyLootTables(ResourceKey<LootTable> key, FabricLootTableBuilder builder,
                                        LootTableSource source, HolderLookup.Provider provider) {
        if (key.identifier().equals(Identifier.withDefaultNamespace("entities/warden"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f))
                    .add(LootItem.lootTableItem(ModItems.WARDEN_HEART))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());


            builder.pool(poolBuilder.build());

        }

        if (key.identifier().equals(Identifier.withDefaultNamespace("entities/warden"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.25f))
                    .add(LootItem.lootTableItem(ModItems.WARDEN_TENDRIL))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)).build());


            builder.pool(poolBuilder.build());
        }

        if (key.identifier().equals(Identifier.withDefaultNamespace("chests/ancient_city"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.01f))
                    .add(LootItem.lootTableItem(ModItems.TRAPPED_SOULS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());

            builder.pool(poolBuilder.build());
        }
    }
}
