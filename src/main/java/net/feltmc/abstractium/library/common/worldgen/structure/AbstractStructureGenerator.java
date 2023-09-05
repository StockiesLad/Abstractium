package net.feltmc.abstractium.library.common.worldgen.structure;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.IdentifiableMimic;
import net.minecraft.world.gen.GenerationStep;

public interface AbstractStructureGenerator extends AbstractionApi<AbstractCommonCalls, MinecraftEnvironment> {
    void generateCarver(
            IdentifiableMimic carver,
            AbstractBiomes contexts,
            GenerationStep.Carver carverStep
    );

    void generateFeature(
            IdentifiableMimic feature,
            AbstractBiomes predicate,
            GenerationStep.Feature featureStep
    );
}
