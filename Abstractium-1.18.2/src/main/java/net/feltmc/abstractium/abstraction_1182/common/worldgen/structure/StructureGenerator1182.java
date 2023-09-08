package net.feltmc.abstractium.abstraction_1182.common.worldgen.structure;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractBiomes;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureGenerator;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.feltmc.abstractium.util.dynamic.Mimic;
import net.minecraft.world.gen.GenerationStep;

import java.util.List;

import static net.feltmc.abstractium.library.common.CommonTypeObjects.*;

public interface StructureGenerator1182 extends AbstractStructureGenerator {
    AbstractiumAccess<StructureGenerator1182, AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment>> ACCESS = new AbstractiumAccess<>(handler -> () -> handler);

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }

    @Override
    default void generateCarver(Mimic carver, AbstractBiomes context, GenerationStep.Carver carverStep) {
        BiomeModifications.addCarver(BiomeModificationMutator.mutate(context), carverStep, carver.cast(configuredCarver(wildcard())));
    }

    @Override
    default void generateFeature(Mimic feature, AbstractBiomes predicate, GenerationStep.Feature featureStep) {
        BiomeModifications.addFeature(BiomeModificationMutator.mutate(predicate), featureStep, feature.cast(registryKey(placedFeature())));
    }
}
