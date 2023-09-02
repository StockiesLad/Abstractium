package net.feltmc.abstractium.library.common;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;

public abstract class AbstractCommonCalls implements AbstractionApi<AbstractCommonCalls, MinecraftEnvironment> {
    private final AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment> handler;

    public AbstractCommonCalls(AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment> handler) {
        this.handler = handler;
    }

    @Override
    public AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment> getHandler() {
        return handler;
    }


}
