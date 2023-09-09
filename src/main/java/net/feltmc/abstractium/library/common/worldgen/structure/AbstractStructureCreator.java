package net.feltmc.abstractium.library.common.worldgen.structure;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.util.dynamic.Mimic;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public interface AbstractStructureCreator extends AbstractionApi<AbstractCommonCalls, MinecraftEnvironment> {
    <FC extends FeatureConfig, F extends Feature<FC>> Mimic createConfiguredFeature(FC featureConfig, F feature);
    Mimic createPlacedFeature(Mimic configuredFeatureRegistryEntry, List<PlacementModifier> modifiers);
}
