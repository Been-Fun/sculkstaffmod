package been_fun.sculkstaffmod;

import been_fun.sculkstaffmod.datagen.ModModelProvider;
import been_fun.sculkstaffmod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SculkStaffDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();


		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);}
}
