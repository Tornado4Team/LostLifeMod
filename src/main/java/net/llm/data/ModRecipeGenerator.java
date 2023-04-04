package net.llm.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.llm.block.ModBlocks;
import net.llm.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(ModItems.FOSSIL), RecipeCategory.MISC, ModItems.FOSSIL,
                0.7f, 200, "lostlifemod");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FOSSIL, RecipeCategory.DECORATIONS,
                ModBlocks.CENOZOIC_FOSSIL_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FOSSIL, RecipeCategory.DECORATIONS,
                ModBlocks.PALEOZOIC_FOSSIL_BLOCK);

        // JUST AN EXAMPLE
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FOSSIL)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('C', ModItems.FOSSIL)
                .criterion(FabricRecipeProvider.hasItem(Items.STONE),
                        FabricRecipeProvider.conditionsFromItem(Items.STONE))
                .criterion(FabricRecipeProvider.hasItem(ModItems.FOSSIL),
                        FabricRecipeProvider.conditionsFromItem(ModItems.FOSSIL))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.FOSSIL)));
    }
}