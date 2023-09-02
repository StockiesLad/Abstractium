package net.feltmc.abstractium.api.internal.abstraction.core.handler;

import net.feltmc.abstractium.api.external.abstraction.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.core.versioning.SupportedVersions;
import net.feltmc.abstractium.api.internal.abstraction.core.versioning.VersionUtil;

public abstract class AbstractVersionHandler<Abstraction extends AbstractionApi<Abstraction>> implements SupportedVersions {
    protected abstract Abstraction getAbstraction();

    protected abstract VersionUtil getVersionUtil();

    public String getVersion() {
        return getVersionUtil().providedVersion;
    }

    public boolean isSupported(final String[] supportedVersions) {
        for (String supportedVersion : supportedVersions)
            if (getVersionUtil().matchesAny(supportedVersion))
                return true;
        return false;
    }

    public boolean isSupported() {
        return isSupported(getSupportedVersions());
    }

    public boolean isSupported(final Abstraction abstraction) {
        return isSupported(getSupportedVersions(abstraction));
    }

    @Override
    public String[] getSupportedVersions() {
        return getAbstraction().getSupportedVersions();
    }

    public String[] getSupportedVersions(final Abstraction abstraction) {
        return abstraction.getSupportedVersions();
    }
}
