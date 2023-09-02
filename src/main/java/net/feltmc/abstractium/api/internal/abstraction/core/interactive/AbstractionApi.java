package net.feltmc.abstractium.api.internal.abstraction.core.interactive;

import net.feltmc.abstractium.api.internal.abstraction.core.versioning.SupportedVersions;

public interface AbstractionApi<Abstraction extends AbstractionApi<Abstraction, Environment>, Environment extends Enum<Environment>> extends SupportedVersions {
    AbstractionHandler<Abstraction, Environment> getHandler();
}
