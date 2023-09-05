package net.feltmc.abstractium.library.common.worldgen.biome;

import net.feltmc.abstractium.library.common.IdentifiableMimic;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public record AbstractBiomeGenerationInfo(
        IdentifiableMimic fakeBiomeKey,
        MultiNoiseUtil.NoiseHypercube noiseHypercube
) {}
