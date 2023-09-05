package net.feltmc.abstractium.library.common.worldgen.structure;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.registration.FakeRegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

public interface AbstractStructureGenerator extends AbstractionApi<AbstractCommonCalls, MinecraftEnvironment> {
    void generateCarver(
            FakeRegistryEntry<ConfiguredCarver<?>> carver,
            AbstractBiomes contexts,
            GenerationStep.Carver carverStep
    );

    void generateFeature(
            FakeRegistryEntry<PlacedFeature> feature,
            AbstractBiomes predicate,
            GenerationStep.Feature featureStep
    );
}
