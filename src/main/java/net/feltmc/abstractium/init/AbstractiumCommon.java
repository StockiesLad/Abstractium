package net.feltmc.abstractium.init;

import net.fabricmc.api.ModInitializer;
import net.feltmc.abstractium.api.abstraction.core.versioning.VersionConstants;

public class AbstractiumCommon implements ModInitializer {
    @Override
    public void onInitialize() {
        VersionConstants.init();
    }
}
