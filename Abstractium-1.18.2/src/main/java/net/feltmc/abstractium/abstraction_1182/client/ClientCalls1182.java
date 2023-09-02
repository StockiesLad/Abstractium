package net.feltmc.abstractium.abstraction_1182.client;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.client.AbstractClientCalls;
import net.feltmc.abstractium.library.client.render.AbstractRenderCalls;
import net.feltmc.abstractium.abstraction_1182.client.rendering.RenderCalls1182;

public class ClientCalls1182 extends AbstractClientCalls {
    public ClientCalls1182(AbstractionHandler<AbstractClientCalls, MinecraftEnvironment> handler) {
        super(handler);
    }

    @Override
    public String[] getSupportedVersions() {
        return new String[] {
                "1.18.2"
        };
    }

    @Override
    public AbstractRenderCalls getRenderCalls() {
        return RenderCalls1182.ACCESS.getInstance(getHandler());
    }
}
