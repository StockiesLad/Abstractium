package net.feltmc.abstractium.api.internal.abstraction.core.interactive;

import java.util.List;

public interface AbstractionEntrypoint{
    <Abstraction extends AbstractionApi<Abstraction, Environment>, Environment extends Enum<Environment>> void register(
            List<Abstraction> abstractions,
            AbstractionHandler<Abstraction, Environment> parent
    );

    default <Abstraction extends AbstractionApi<Abstraction, Environment>, Environment extends Enum<Environment>> void loadClasses(
            AbstractionHandler<Abstraction, Environment> handler
    ) {}
}
