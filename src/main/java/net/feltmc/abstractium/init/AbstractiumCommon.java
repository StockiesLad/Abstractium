package net.feltmc.abstractium.init;

import net.fabricmc.api.ModInitializer;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.api.internal.abstraction.def.VersionConstants;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;

public class AbstractiumCommon implements ModInitializer {
    public static final AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment> COMMON_ABSTRACTION_HANDLER;

    static {
        COMMON_ABSTRACTION_HANDLER = AbstractiumHelper.createAbstraction(MinecraftEnvironment.COMMON);
    }
    @Override
    public void onInitialize() {
        VersionConstants.init();
    }
}
