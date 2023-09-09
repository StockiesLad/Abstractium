package net.feltmc.abstractium.library.common;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.itemgroup.AbstractItemgroupHandler;
import net.feltmc.abstractium.library.common.registration.AbstractRegistrar;
import net.feltmc.abstractium.library.common.worldgen.biome.AbstractBiomeGenerator;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureCreator;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureGenerator;

import java.util.List;

public interface AbstractCommonCalls extends AbstractionApi<AbstractCommonCalls, MinecraftEnvironment> {
    @Override
    default List<AbstractionApi<?, ?>> getSubAbstractions() {
        return List.of(
                getRegistrar(),
                getItemgroupHandler(),
                getStructureGenerator(),
                getStructureCreator(),
                getBiomeGenerator()
        );
    }

    AbstractRegistrar getRegistrar();
    AbstractItemgroupHandler getItemgroupHandler();
    AbstractStructureGenerator getStructureGenerator();
    AbstractStructureCreator getStructureCreator();
    AbstractBiomeGenerator getBiomeGenerator();
}
