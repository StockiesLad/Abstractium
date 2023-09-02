package net.feltmc.abstractium.api.internal.abstraction.def;

import net.feltmc.abstractium.api.internal.abstraction.core.versioning.strategy.ExceptionStrategy;
import net.feltmc.abstractium.api.internal.abstraction.core.versioning.strategy.MatchingStrategy;
import net.feltmc.abstractium.api.internal.abstraction.core.versioning.VersionPackage;
import net.feltmc.abstractium.api.internal.abstraction.core.versioning.VersionUtil;

public class VersionUtils {
    public static final VersionUtil MINECRAFT = new VersionUtil(
            "minecraft",
            VersionPackage::ofFmjVersion,
            MatchingStrategy.EQUALS,
            ExceptionStrategy.NO_EXCEPTION
    );
}
