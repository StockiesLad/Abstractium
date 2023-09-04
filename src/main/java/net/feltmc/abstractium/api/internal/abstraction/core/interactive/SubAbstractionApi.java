package net.feltmc.abstractium.api.internal.abstraction.core.interactive;

public interface SubAbstractionApi<SubAbstraction extends AbstractionApi <?, ?>> {
    SubAbstraction getAbstraction();
}
