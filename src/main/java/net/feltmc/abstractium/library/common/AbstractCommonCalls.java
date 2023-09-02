package net.feltmc.abstractium.library.common;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.itemgroup.AbstractItemgroupHandler;
import net.feltmc.abstractium.library.common.registration.AbstractRegistrar;
import net.feltmc.abstractium.library.common.worldgen.biome.AbstractBiomeGenerator;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureGenerator;

public abstract class AbstractCommonCalls implements AbstractionApi<AbstractCommonCalls, MinecraftEnvironment> {
    private final AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment> handler;

    public AbstractCommonCalls(AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment> handler) {
        this.handler = handler;
    }

    @Override
    public AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment> getHandler() {
        return handler;
    }

    public abstract AbstractRegistrar getRegistrar();
    public abstract AbstractItemgroupHandler getItemgroupHandler();
    public abstract AbstractStructureGenerator getStructureGenerator();
    public abstract AbstractBiomeGenerator getBiomeGenerator();
}
