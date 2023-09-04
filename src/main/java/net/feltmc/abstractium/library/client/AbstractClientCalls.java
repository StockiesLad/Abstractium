package net.feltmc.abstractium.library.client;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.SubAbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.client.render.AbstractRenderCalls;

public interface AbstractClientCalls extends AbstractionApi<AbstractClientCalls, MinecraftEnvironment> {
    SubAbstractionApi<AbstractRenderCalls> getRenderCalls();
}
