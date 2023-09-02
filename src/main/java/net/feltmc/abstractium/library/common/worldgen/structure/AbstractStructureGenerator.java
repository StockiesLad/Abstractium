package net.feltmc.abstractium.library.common.worldgen.structure;

import net.minecraft.world.gen.GenerationStep;

public interface AbstractStructureGenerator {
    void generateCarver(
            //RegistryEntry<ConfiguredCarver<?>> carver,
            //Predicate<BiomeSelectionContext> predicate,
            GenerationStep.Carver carverStep
    );

    void generateFeature(
            //RegistryEntry<PlacedFeature> feature,
            //Predicate<BiomeSelectionContext> predicate,
            GenerationStep.Feature featureStep
    );
}
