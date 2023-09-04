package net.feltmc.abstractium.api.internal.abstraction.core.versioning;

import java.util.List;

public interface Versionable {
    List<String> getSupportedVersions();

    default boolean isOnCorrectVersion(final VersionUtil versionUtil) {
        for (final String version : getSupportedVersions())
            if (versionUtil.matches(version))
                return true;
        return false;
    }
}
