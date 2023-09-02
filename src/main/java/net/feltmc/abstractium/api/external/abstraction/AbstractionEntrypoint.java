package net.feltmc.abstractium.api.external.abstraction;

import net.feltmc.abstractium.api.internal.abstraction.core.handler.AbstractionHandler;

import java.util.List;

public interface AbstractionEntrypoint {
    <Abstraction extends AbstractionApi<Abstraction>, Environment extends Enum<Environment>> void register(
            List<Abstraction> clientAbstractionEvent,
            AbstractionHandler<Abstraction, Environment> parent
    );

    default <Abstraction extends AbstractionApi<Abstraction>, Environment extends Enum<Environment>> void loadClasses(
            AbstractionHandler<Abstraction, Environment> handler
    ) {}
}
