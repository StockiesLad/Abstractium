package net.feltmc.abstractium.library.client;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.client.render.AbstractRenderCalls;

import java.util.List;

public interface AbstractClientCalls extends AbstractionApi<AbstractClientCalls, MinecraftEnvironment> {
    @Override
    default List<AbstractionApi<?, ?>> getSubAbstractions() {
        return List.of(getRenderCalls());
    }

    AbstractRenderCalls getRenderCalls();
}
