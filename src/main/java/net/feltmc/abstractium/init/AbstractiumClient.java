package net.feltmc.abstractium.init;

import net.fabricmc.api.ClientModInitializer;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.client.AbstractClientCalls;

public class AbstractiumClient implements ClientModInitializer {
    public static final AbstractionHandler<AbstractClientCalls, MinecraftEnvironment> CLIENT_ABSTRACTION_HANDLER;

    static {
        CLIENT_ABSTRACTION_HANDLER = AbstractiumHelper.createAbstraction(MinecraftEnvironment.CLIENT);
    }
    @Override
    public void onInitializeClient() {}
}
