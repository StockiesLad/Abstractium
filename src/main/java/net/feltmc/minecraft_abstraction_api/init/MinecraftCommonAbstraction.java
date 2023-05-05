package net.feltmc.minecraft_abstraction_api.init;

import net.fabricmc.api.ModInitializer;
import net.feltmc.minecraft_abstraction_api.api.abstraction.core.versioning.VersionConstants;

public class MinecraftCommonAbstraction implements ModInitializer {
    @Override
    public void onInitialize() {
        VersionConstants.init();
    }
}
