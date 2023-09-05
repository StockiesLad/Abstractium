package net.feltmc.abstractium.abstraction.common.registration;

import com.mojang.serialization.Codec;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import com.terraformersmc.terraform.tree.placer.PlacerTypes;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.IdentifiableMimic;
import net.feltmc.abstractium.library.common.registration.AbstractRegistrar;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.carver.CarverConfig;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.feltmc.abstractium.library.common.CommonMimicTypes.*;
import static net.minecraft.util.registry.BuiltinRegistries.CONFIGURED_FEATURE;

@SuppressWarnings({"unchecked"})
public interface Registrar1182 extends AbstractRegistrar {
    AbstractiumAccess<Registrar1182, AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment>> ACCESS = new AbstractiumAccess<>(handler -> () -> handler);

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }

    @Override
    default <B extends Block> B registerBlock(Identifier identifier, B block) {
        Registry.register(Registry.BLOCK, identifier, block);
        return block;
    }

    @Override
    default <I extends Item> I registerItem(Identifier identifier, I item) {
        Registry.register(Registry.ITEM, identifier, item);
        return item;
    }

    @Override
    default void registerBoat(Identifier identifier, Item boat, Consumer<Item> itemConsumer) {
        Supplier<TerraformBoatType> type = () -> () -> boat;
        itemConsumer.accept(TerraformBoatItemHelper.registerBoatItem(identifier, type));
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, identifier, type.get());
    }

    @Override
    default <P extends TrunkPlacer> TrunkPlacerType<P> registerTrunkPlacer(Identifier identifier, Codec<P> placerCodec) {
        return PlacerTypes.registerTrunkPlacer(identifier, placerCodec);
    }

    @Override
    default <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliagePlacer(Identifier identifier, Codec<P> placerCodec) {
        return PlacerTypes.registerFoliagePlacer(identifier, placerCodec);
    }

    @Override
    default <FC extends FeatureConfig, F extends Feature<FC>> F registerFeature(Identifier identifier , F feature) {
        return Registry.register(Registry.FEATURE, identifier, feature);
    }

    @Override
    default <FC extends FeatureConfig, F extends Feature<FC>> IdentifiableMimic registerConfiguredFeature(Identifier identifier, F feature, FC config) {
        return IdentifiableMimic.create(identifier, registryEntry(configuredFeature(any(), any())), Registry.register(CONFIGURED_FEATURE, identifier, new ConfiguredFeature<>(feature, config)));
    }

    @Override
    default IdentifiableMimic registerPlacedFeature(Identifier identifier, IdentifiableMimic configuredFeatureRegistryEntry, List<PlacementModifier> modifiers) {
        configuredFeatureRegistryEntry.verify(registryEntry(configuredFeature(any(), any())));
        return IdentifiableMimic.create(identifier, registryEntry(placedFeature()), BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, identifier, new PlacedFeature((RegistryEntry<ConfiguredFeature<?, ?>>) configuredFeatureRegistryEntry.mimic().instance(), modifiers)));
    }

    @Override
    default <CC extends CarverConfig> Carver<CC> registerCarver(Identifier identifier, Carver<CC> carver) {
        return Registry.register(Registry.CARVER, identifier, carver);
    }

    @Override
    default IdentifiableMimic registerCarverConfig(Identifier identifier, ConfiguredCarver<?> configuredCarver) {
        return IdentifiableMimic.create(identifier, registryEntry(configuredCarver(any())), BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_CARVER, identifier, configuredCarver));
    }

    @Override
    default IdentifiableMimic registerBiome(Identifier identifier, Biome biome) {
        RegistryKey<Biome> key = RegistryKey.of(Registry.BIOME_KEY, identifier);
        BuiltinRegistries.add(BuiltinRegistries.BIOME, key, biome);
        return IdentifiableMimic.create(identifier, registryKey(biome()), key);
    }
}
