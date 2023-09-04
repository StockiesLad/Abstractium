package net.feltmc.abstractium.api.internal.abstraction.core.interactive;

public interface SubAbstractionApi<Provider extends AbstractionHandlerProvider<?, ?>>
{
    Provider getAbstraction();
}
