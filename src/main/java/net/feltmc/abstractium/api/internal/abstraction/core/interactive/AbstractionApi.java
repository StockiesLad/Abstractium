package net.feltmc.abstractium.api.internal.abstraction.core.interactive;

import net.feltmc.abstractium.api.internal.abstraction.core.versioning.SupportedVersions;

@SuppressWarnings({"TypeParameterHidesVisibleType", "unchecked"})
public interface AbstractionApi<Abstraction extends AbstractionApi<Abstraction, Environment>, Environment extends Enum<Environment>> extends SupportedVersions {
    AbstractionHandler<Abstraction, Environment> getHandler();

    default  <Abstraction extends AbstractionApi<Abstraction, ?>> Abstraction generify() {
        return (Abstraction) this;
    }

    default void loadClasses() {}
}
