package net.feltmc.abstractium.abstraction.common.worldgen.structure;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureGenerator;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.minecraft.world.gen.GenerationStep;

import java.util.List;

public interface StructureGenerator1182 extends AbstractStructureGenerator {
    AbstractiumAccess<StructureGenerator1182, AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment>> ACCESS = new AbstractiumAccess<>(handler -> () -> handler);

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }

    @Override
    default void generateCarver(GenerationStep.Carver carverStep) {

    }

    @Override
    default void generateFeature(GenerationStep.Feature featureStep) {

    }
}
