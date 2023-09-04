package net.feltmc.abstractium.abstraction.client;

import net.feltmc.abstractium.abstraction.client.rendering.RenderCalls1182;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.SubAbstractionApi;
import net.feltmc.abstractium.library.client.AbstractClientCalls;
import net.feltmc.abstractium.library.client.render.AbstractRenderCalls;

import java.util.List;

public interface ClientCalls1182 extends AbstractClientCalls {

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }

    @Override
    default List<SubAbstractionApi<?>> getSubAbstractions() {
        return List.of(getRenderCalls());
    }

    @Override
    default SubAbstractionApi<AbstractRenderCalls> getRenderCalls() {
        return () -> RenderCalls1182.ACCESS.getInstance(getHandler());
    }
}
