package been_fun.sculkstaffmod.datagen;

import been_fun.sculkstaffmod.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

        itemModelGenerators.declareCustomModelItem(ModItems.SCULK_STAFF);

        itemModelGenerators.generateFlatItem(ModItems.SCULK_CATALYST_BONES, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SCULK_SHRIEKER_BONES, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SCULK_BONES, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WARDEN_HEART, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WARDEN_TENDRIL, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TRAPPED_SOULS, ModelTemplates.FLAT_ITEM);


    }
}
