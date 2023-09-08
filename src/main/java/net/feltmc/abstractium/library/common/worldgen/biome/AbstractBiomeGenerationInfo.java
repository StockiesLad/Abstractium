package net.feltmc.abstractium.library.common.worldgen.biome;

import net.feltmc.abstractium.util.dynamic.Mimic;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public record AbstractBiomeGenerationInfo(
        Mimic biomeKey,
        MultiNoiseUtil.NoiseHypercube noiseHypercube
) {}
