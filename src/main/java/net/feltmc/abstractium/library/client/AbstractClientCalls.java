package net.feltmc.abstractium.library.client;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.client.render.AbstractRenderCalls;

public abstract class AbstractClientCalls implements AbstractionApi<AbstractClientCalls, MinecraftEnvironment> {
    private final AbstractionHandler<AbstractClientCalls, MinecraftEnvironment> handler;

    public AbstractClientCalls(AbstractionHandler<AbstractClientCalls, MinecraftEnvironment> handler) {
        this.handler = handler;
    }

    @Override
    public AbstractionHandler<AbstractClientCalls, MinecraftEnvironment> getHandler() {
        return handler;
    }

    public abstract AbstractRenderCalls getRenderCalls();
}
