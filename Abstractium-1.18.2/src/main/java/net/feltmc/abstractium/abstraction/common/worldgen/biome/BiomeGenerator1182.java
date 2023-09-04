package net.feltmc.abstractium.abstraction.common.worldgen.biome;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.worldgen.biome.AbstractBiomeGenerator;
import net.feltmc.abstractium.util.access.AbstractiumAccess;

public interface BiomeGenerator1182 extends AbstractBiomeGenerator {
    AbstractiumAccess<BiomeGenerator1182, AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment>> ACCESS = new AbstractiumAccess<>(handler -> () -> handler);

    @Override
    default void generateBiome() {

    }
}
