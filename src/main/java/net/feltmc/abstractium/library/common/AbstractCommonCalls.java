package net.feltmc.abstractium.library.common;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.SubAbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.itemgroup.AbstractItemgroupHandler;
import net.feltmc.abstractium.library.common.registration.AbstractRegistrar;
import net.feltmc.abstractium.library.common.worldgen.biome.AbstractBiomeGenerator;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureGenerator;

public interface AbstractCommonCalls extends AbstractionApi<AbstractCommonCalls, MinecraftEnvironment> {
    SubAbstractionApi<AbstractRegistrar> getRegistrar();
    SubAbstractionApi<AbstractItemgroupHandler> getItemgroupHandler();
    SubAbstractionApi<AbstractStructureGenerator> getStructureGenerator();
    SubAbstractionApi<AbstractBiomeGenerator> getBiomeGenerator();
}
