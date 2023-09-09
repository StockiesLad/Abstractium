package net.feltmc.abstractium.abstraction_1182.client;

import net.feltmc.abstractium.abstraction_1182.client.rendering.RenderCalls1182;
import net.feltmc.abstractium.library.client.AbstractClientCalls;
import net.feltmc.abstractium.library.client.render.AbstractRenderCalls;

import java.util.List;

public interface ClientCalls1182 extends AbstractClientCalls {

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }

    @Override
    default AbstractRenderCalls getRenderCalls() {
        return RenderCalls1182.ACCESS.getInstance(getHandler());
    }
}
