package net.feltmc.abstractium.library.common.registration;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public interface AbstractRegistrar extends AbstractionApi<AbstractCommonCalls, MinecraftEnvironment> {
    void registerBlock();
    void registerItem();

    void registerBoat();

    void registerPlacer();
    void registerFeature();
    void registerCarver();

    void /*RegistryKey<Biome>*/ registerBiome(Identifier identifier, Biome biome);
}
