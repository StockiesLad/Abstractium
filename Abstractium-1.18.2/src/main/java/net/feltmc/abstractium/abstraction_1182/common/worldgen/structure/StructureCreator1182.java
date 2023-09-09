package net.feltmc.abstractium.abstraction_1182.common.worldgen.structure;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureCreator;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.feltmc.abstractium.util.dynamic.Mimic;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

import static net.feltmc.abstractium.library.common.CommonTypeObjects.configuredFeature;
import static net.feltmc.abstractium.library.common.CommonTypeObjects.registryEntry;
import static net.feltmc.abstractium.util.dynamic.TypeObject.*;

public interface StructureCreator1182 extends AbstractStructureCreator {
    AbstractiumAccess<StructureCreator1182, AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment>> ACCESS = new AbstractiumAccess<>(handler -> () -> handler);

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }

    @Override
    default <FC extends FeatureConfig, F extends Feature<FC>> Mimic createConfiguredFeature(FC featureConfig, F feature) {
        return new Mimic("StructureCreator1182#createConfiguredFeature," + featureConfig + feature, configuredFeature(ofWildcard(of("FeatureConfig")), ofWildcard(ofGenerics("Feature", of("FeatureConfig")))), new ConfiguredFeature<>(feature, featureConfig));
    }

    @Override
    default Mimic createPlacedFeature(Mimic configuredFeatureRegistryEntry, List<PlacementModifier> modifiers) {
        return new Mimic("StructureCreator1182#createPlacedFeature," + configuredFeatureRegistryEntry, of("PlacedFeature"), new PlacedFeature(configuredFeatureRegistryEntry.cast(registryEntry(configuredFeature(ofWildcard(), ofWildcard()))), modifiers));
    }
}
