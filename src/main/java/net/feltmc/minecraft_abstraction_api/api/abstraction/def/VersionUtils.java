package net.feltmc.minecraft_abstraction_api.api.abstraction.def;

import net.feltmc.minecraft_abstraction_api.api.abstraction.core.versioning.VersionUtil;

public class VersionUtils {
    public static final VersionUtil.GameSpecific MINECRAFT = new VersionUtil.GameSpecific(
            "minecraft",
            VersionUtil.VersionPackage::ofFmjVersion,
            VersionUtil.MatchingStrategy.EQUALS,
            VersionUtil.ExceptionStrategy.NO_EXCEPTION
    );
}
