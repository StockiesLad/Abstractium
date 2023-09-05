package net.feltmc.abstractium.abstraction.common.worldgen.biome;

import net.feltmc.abstractium.library.common.worldgen.structure.AbstractBiomes;
import terrablender.api.RegionType;

public class TerrablenderBiomeMutator {
    public static RegionType mutate(AbstractBiomes selectionContext) {
        return switch (selectionContext) {
            default -> throw new NullPointerException("Terrablender only supports Overworld and Nether!");
            case OVERWORLD -> RegionType.OVERWORLD;
            case NETHER -> RegionType.NETHER;
        };
    }
}
