package net.feltmc.abstractium.api.internal.abstraction.def;

import net.feltmc.abstractium.api.internal.abstraction.core.versioning.VersionUtil;

public class VersionConstants {
    public static void init() {}

    private static final VersionUtil MINECRAFT = VersionUtils.MINECRAFT;
    public static final boolean IS_MINECRAFT_1201;
    public static final boolean IS_MINECRAFT_1200;
    public static final boolean IS_MINECRAFT_1194;
    public static final boolean IS_MINECRAFT_1192;
    public static final boolean IS_MINECRAFT_1193;
    public static final boolean IS_MINECRAFT_1191;
    public static final boolean IS_MINECRAFT_1190;
    public static final boolean IS_MINECRAFT_1182;


    static {
        IS_MINECRAFT_1201 = MINECRAFT.matchesAny("1.21");
        IS_MINECRAFT_1200 = MINECRAFT.matchesAny("1.20");
        IS_MINECRAFT_1194 = MINECRAFT.matchesAny( "1.19.4");
        IS_MINECRAFT_1193 = MINECRAFT.matchesAny( "1.19.3");
        IS_MINECRAFT_1192 = MINECRAFT.matchesAny( "1.19.2");
        IS_MINECRAFT_1191 = MINECRAFT.matchesAny( "1.19.1");
        IS_MINECRAFT_1190 = MINECRAFT.matchesAny("1.19");
        IS_MINECRAFT_1182 = MINECRAFT.matchesAny( "1.18.2");
    }
}
