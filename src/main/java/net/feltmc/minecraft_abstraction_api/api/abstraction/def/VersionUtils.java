package net.feltmc.minecraft_abstraction_api.api.abstraction.def;

import net.feltmc.minecraft_abstraction_api.api.abstraction.core.versioning.ExceptionStrategy;
import net.feltmc.minecraft_abstraction_api.api.abstraction.core.versioning.MatchingStrategy;
import net.feltmc.minecraft_abstraction_api.api.abstraction.core.versioning.VersionPackage;
import net.feltmc.minecraft_abstraction_api.api.abstraction.core.versioning.VersionUtil;

public class VersionUtils {
    public static final VersionUtil MINECRAFT = new VersionUtil(
            "minecraft",
            VersionPackage::ofFmjVersion,
            MatchingStrategy.EQUALS,
            ExceptionStrategy.NO_EXCEPTION
    );
}
