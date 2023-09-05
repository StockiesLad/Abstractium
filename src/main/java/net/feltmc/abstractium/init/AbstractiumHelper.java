package net.feltmc.abstractium.init;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandlerFactory;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;

class AbstractiumHelper {
    static <Abstraction extends AbstractionApi<Abstraction, MinecraftEnvironment>>
    AbstractionHandler<Abstraction, MinecraftEnvironment> createAbstraction(MinecraftEnvironment environment) {
        return AbstractionHandlerFactory.minecraftAbstraction(
                AbstractiumConstants.MOD_ID,
                AbstractiumConstants.INTERNAL_MOD_IDS,
                environment
        );
    }
}
