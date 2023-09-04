package net.feltmc.abstractium.library.common.worldgen.structure;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandlerProvider;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.minecraft.world.gen.GenerationStep;

public interface AbstractStructureGenerator extends AbstractionHandlerProvider<AbstractCommonCalls, MinecraftEnvironment> {
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
