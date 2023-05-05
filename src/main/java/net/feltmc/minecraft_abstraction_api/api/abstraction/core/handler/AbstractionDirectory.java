package net.feltmc.minecraft_abstraction_api.api.abstraction.core.handler;

import net.feltmc.minecraft_abstraction_api.api.abstraction.core.versioning.SupportedVersions;
import net.feltmc.minecraft_abstraction_api.api.abstraction.core.versioning.VersionProvider;
import net.feltmc.minecraft_abstraction_api.api.abstraction.core.versioning.VersionUtil;

public interface AbstractionDirectory<T extends MethodAbstractionApi> extends VersionProvider, SupportedVersions {
    @Override
    default String getVersion() {
        return getVersionUtil().providedVersion;
    }

    @Override
    default String[] getSupportedVersions() {
        return getAbstractedEntries().getSupportedVersions();
    }

    VersionUtil getVersionUtil();

    T getAbstractedEntries();
}
