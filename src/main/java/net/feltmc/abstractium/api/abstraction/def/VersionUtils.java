package net.feltmc.abstractium.api.abstraction.def;

import net.feltmc.abstractium.api.abstraction.core.versioning.ExceptionStrategy;
import net.feltmc.abstractium.api.abstraction.core.versioning.MatchingStrategy;
import net.feltmc.abstractium.api.abstraction.core.versioning.VersionPackage;
import net.feltmc.abstractium.api.abstraction.core.versioning.VersionUtil;

public class VersionUtils {
    public static final VersionUtil MINECRAFT = new VersionUtil(
            "minecraft",
            VersionPackage::ofFmjVersion,
            MatchingStrategy.EQUALS,
            ExceptionStrategy.NO_EXCEPTION
    );
}
