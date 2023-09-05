package net.feltmc.abstractium.abstraction.common.worldgen.structure;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.registration.FakeRegistryEntry;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractBiomes;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureGenerator;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.List;

@SuppressWarnings("unchecked")
public interface StructureGenerator1182 extends AbstractStructureGenerator {
    AbstractiumAccess<StructureGenerator1182, AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment>> ACCESS = new AbstractiumAccess<>(handler -> () -> handler);

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }

    @Override
    default void generateCarver(FakeRegistryEntry<ConfiguredCarver<?>> carver, AbstractBiomes context, GenerationStep.Carver carverStep) {
        BiomeModifications.addCarver(BiomeModificationMutator.mutate(context), carverStep, (RegistryKey<ConfiguredCarver<?>>) carver);
    }

    @Override
    default void generateFeature(FakeRegistryEntry<PlacedFeature> feature, AbstractBiomes predicate, GenerationStep.Feature featureStep) {
        BiomeModifications.addFeature(BiomeModificationMutator.mutate(predicate), featureStep, (RegistryKey<PlacedFeature>) feature);

    }
}
