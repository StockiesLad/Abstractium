package net.feltmc.abstractium.abstraction_1182.common;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;

public class CommonCalls1182 extends AbstractCommonCalls {
    public CommonCalls1182(AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment> handler) {
        super(handler);
    }

    @Override
    public String[] getSupportedVersions() {
        return new String[] {
                "1.18.2"
        };
    }
}
