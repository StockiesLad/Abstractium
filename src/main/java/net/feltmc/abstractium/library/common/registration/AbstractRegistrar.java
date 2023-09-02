package net.feltmc.abstractium.library.common.registration;

import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public interface AbstractRegistrar {
    void registerBlock();
    void registerItem();

    void registerBoat();

    void registerPlacer();
    void registerFeature();
    void registerCarver();

    void /*RegistryKey<Biome>*/ registerBiome(Identifier identifier, Biome biome);

}
