package net.feltmc.abstractium.abstraction_1182.common.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.worldgen.biome.AbstractBiomeGenerationInfo;
import net.feltmc.abstractium.library.common.worldgen.biome.AbstractBiomeGenerator;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractBiomes;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.Regions;

import java.util.List;
import java.util.function.Consumer;

import static net.feltmc.abstractium.library.common.CommonMimicTypes.biome;
import static net.feltmc.abstractium.library.common.CommonMimicTypes.registryKey;

@SuppressWarnings("unchecked")
public interface BiomeGenerator1182 extends AbstractBiomeGenerator {
    AbstractiumAccess<BiomeGenerator1182, AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment>> ACCESS = new AbstractiumAccess<>(handler -> () -> handler);

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }

    @Override
    default void generateBiomes(List<AbstractBiomeGenerationInfo> biomes, Identifier identifier, int weight, AbstractBiomes biome) {
        Regions.register(identifier, new Region(identifier, TerrablenderBiomeMutator.mutate(biome), weight) {
            @Override
            public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
                for (AbstractBiomeGenerationInfo info : biomes) {
                    info.fakeBiomeKey().verify(registryKey(biome()));
                    addBiome(mapper, info.noiseHypercube(), (RegistryKey<Biome>) info.fakeBiomeKey().mimic().instance());
                }
            }
        });
    }
}
