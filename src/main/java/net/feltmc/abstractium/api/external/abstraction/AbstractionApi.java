package net.feltmc.abstractium.api.external.abstraction;

import net.feltmc.abstractium.api.internal.abstraction.core.handler.AbstractVersionHandler;
import net.feltmc.abstractium.api.internal.abstraction.core.versioning.SupportedVersions;

public interface AbstractionApi<Abstraction extends AbstractionApi<Abstraction>> extends SupportedVersions {
    AbstractVersionHandler<Abstraction> getHandler();
}
