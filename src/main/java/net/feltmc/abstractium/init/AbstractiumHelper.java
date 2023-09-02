package net.feltmc.abstractium.init;

import net.feltmc.abstractium.api.external.abstraction.AbstractionHandlerFactory;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;

import static net.feltmc.abstractium.init.AbstractiumConstants.INTERNAL_MOD_IDS;
import static net.feltmc.abstractium.init.AbstractiumConstants.MOD_ID;

class AbstractiumHelper {
    static <Abstraction extends AbstractionApi<Abstraction, MinecraftEnvironment>>
    AbstractionHandler<Abstraction, MinecraftEnvironment> createAbstraction(MinecraftEnvironment environment) {
        return AbstractionHandlerFactory.minecraftAbstraction(
                MOD_ID,
                INTERNAL_MOD_IDS,
                environment
        );
    }
}
