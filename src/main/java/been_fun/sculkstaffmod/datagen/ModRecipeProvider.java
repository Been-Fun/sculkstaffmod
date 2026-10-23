package been_fun.sculkstaffmod.datagen;

import been_fun.sculkstaffmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {

        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {

                shaped(RecipeCategory.MISC, ModItems.SCULK_SHRIEKER_BONES)
                        .pattern("AAA")
                        .pattern("ABA")
                        .pattern("AAA")
                        .define('A', Items.BONE)
                        .define('B', Items.SCULK_SHRIEKER)
                        .unlockedBy(getHasName(Items.SCULK_SHRIEKER), has(Items.SCULK_SHRIEKER))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.SCULK_CATALYST_BONES)
                        .pattern("AAA")
                        .pattern("ABA")
                        .pattern("AAA")
                        .define('A', Items.BONE)
                        .define('B', Items.SCULK_CATALYST)
                        .unlockedBy(getHasName(Items.SCULK_CATALYST), has(Items.SCULK_CATALYST))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.SCULK_BONES)
                        .requires(ModItems.SCULK_SHRIEKER_BONES, 4)
                        .requires(ModItems.SCULK_CATALYST_BONES, 4)
                        .unlockedBy(getHasName(ModItems.SCULK_CATALYST_BONES), has(ModItems.SCULK_CATALYST_BONES))
                        .unlockedBy(getHasName(ModItems.SCULK_SHRIEKER_BONES), has(ModItems.SCULK_SHRIEKER_BONES))
                        .save(output);


                shaped(RecipeCategory.MISC, ModItems.WARDEN_HEART)
                        .pattern("ABA")
                        .pattern("BCB")
                        .pattern("ABA")
                        .define('A', Items.SCULK_CATALYST)
                        .define('B', Items.SCULK)
                        .define('C', Items.RECOVERY_COMPASS)
                        .unlockedBy(getHasName(Items.RECOVERY_COMPASS), has(Items.RECOVERY_COMPASS))
                        .unlockedBy(getHasName(Items.SCULK_CATALYST), has(Items.SCULK_CATALYST))
                        .unlockedBy(getHasName(Items.SCULK), has(Items.SCULK))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.WARDEN_TENDRIL)
                        .pattern("ABA")
                        .pattern("BCB")
                        .pattern("ABA")
                        .define('A', Items.SCULK_SENSOR)
                        .define('B', Items.SCULK)
                        .define('C', Items.RECOVERY_COMPASS)
                        .unlockedBy(getHasName(Items.RECOVERY_COMPASS), has(Items.RECOVERY_COMPASS))
                        .unlockedBy(getHasName(Items.SCULK_SENSOR), has(Items.SCULK_SENSOR))
                        .unlockedBy(getHasName(Items.SCULK), has(Items.SCULK))
                        .save(output);


                shaped(RecipeCategory.TOOLS, ModItems.SCULK_STAFF)
                        .pattern("BCB")
                        .pattern(" D ")
                        .pattern(" A ")
                        .define('A', ModItems.SCULK_BONES)
                        .define('B', ModItems.WARDEN_TENDRIL)
                        .define('C', ModItems.WARDEN_HEART)
                        .define('D', ModItems.TRAPPED_SOULS)
                        .unlockedBy(getHasName(ModItems.SCULK_BONES), has(ModItems.SCULK_BONES))
                        .unlockedBy(getHasName(ModItems.WARDEN_TENDRIL), has(ModItems.WARDEN_TENDRIL))
                        .unlockedBy(getHasName(ModItems.WARDEN_HEART), has(ModItems.WARDEN_HEART))
                        .unlockedBy(getHasName(Items.NETHERITE_BLOCK), has(Items.NETHERITE_BLOCK))
                        .save(output);

            }
        };
    }

    @Override
    public String getName(){
        return "Sculk Staff Mod Recipes";
    }
}
