package net.feltmc.abstractium.api.internal.abstraction.core.interactive;

public interface AbstractionHandlerProvider<Abstraction extends AbstractionApi<Abstraction, Environment>, Environment extends Enum<Environment>> {
    AbstractionHandler<Abstraction, Environment> getHandler();
}
