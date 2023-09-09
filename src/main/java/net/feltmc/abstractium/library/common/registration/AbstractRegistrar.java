package net.feltmc.abstractium.library.common.registration;

import com.mojang.serialization.Codec;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.util.dynamic.Mimic;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.carver.CarverConfig;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.function.Consumer;

public interface AbstractRegistrar extends AbstractionApi<AbstractCommonCalls, MinecraftEnvironment> {
    Mimic getKeyFromEntry(Mimic registryEntry);
    <T> Mimic getEntryFromKey(Mimic registryKey);
    <B extends Block> B registerBlock(Identifier identifier, B block);
    <I extends Item> I registerItem(Identifier identifier, I item);
    void registerBoat(Identifier identifier, Item boat, Consumer<Item> returnValue);
    <P extends TrunkPlacer> TrunkPlacerType<P> registerTrunkPlacer(Identifier identifier, Codec<P> placerCodec);
    <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliagePlacer(Identifier identifier, Codec<P> placerCodec);
    <F extends Feature<?>> F registerFeature(Identifier identifier, F feature);
    Mimic registerConfiguredFeature(Identifier identifier, Mimic configuredFeature);
    Mimic registerPlacedFeature(Identifier identifier, Mimic placedFeature);
    <CC extends CarverConfig> Carver<CC> registerCarver(Identifier identifier, Carver<CC> carver);
    Mimic registerCarverConfig(Identifier identifier, ConfiguredCarver<?> configuredCarver);
    Mimic registerBiome(Identifier identifier, Biome biome);
}
