package net.feltmc.abstractium.library.common.worldgen.structure;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.worldgen.biome.AbstractBiomes;
import net.feltmc.abstractium.util.dynamic.Mimic;
import net.minecraft.world.gen.GenerationStep;

public interface AbstractStructureGenerator extends AbstractionApi<AbstractCommonCalls, MinecraftEnvironment> {
    void generateCarver(
            Mimic carver,
            AbstractBiomes contexts,
            GenerationStep.Carver carverStep
    );

    void generateFeature(
            Mimic feature,
            AbstractBiomes predicate,
            GenerationStep.Feature featureStep
    );
}
