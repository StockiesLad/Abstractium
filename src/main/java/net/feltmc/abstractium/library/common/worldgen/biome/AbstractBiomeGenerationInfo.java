package net.feltmc.abstractium.library.common.worldgen.biome;

import net.feltmc.abstractium.library.common.IdentifiableObject;
import net.feltmc.abstractium.library.common.registration.FakeRegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public record AbstractBiomeGenerationInfo(
        IdentifiableObject<FakeRegistryKey<Biome>> fakeBiomeKey,
        MultiNoiseUtil.NoiseHypercube noiseHypercube
) {}
