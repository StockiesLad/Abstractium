package net.feltmc.abstractium.library.common.worldgen.biome;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandlerProvider;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;

public interface AbstractBiomeGenerator extends AbstractionHandlerProvider<AbstractCommonCalls, MinecraftEnvironment> {
    void generateBiome();
}
