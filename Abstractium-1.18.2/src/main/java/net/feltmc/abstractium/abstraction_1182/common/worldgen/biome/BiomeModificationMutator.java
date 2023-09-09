package net.feltmc.abstractium.abstraction_1182.common.worldgen.biome;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.feltmc.abstractium.library.common.worldgen.biome.AbstractBiomes;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.dimension.DimensionOptions;

import java.util.function.Predicate;

public class BiomeModificationMutator {
    public static Predicate<BiomeSelectionContext> mutate(AbstractBiomes selectionContext) {
        return context -> switch (selectionContext) {
            case ALL -> true;
            case VANILLA -> (context.getBiomeKey().getValue().getNamespace().equals("minecraft") && BuiltinRegistries.BIOME.containsId(context.getBiomeKey().getValue()));
            case OVERWORLD -> context.canGenerateIn(DimensionOptions.OVERWORLD);
            case NETHER -> context.canGenerateIn(DimensionOptions.NETHER);
            case END -> context.canGenerateIn(DimensionOptions.END);
        };
    }
}
