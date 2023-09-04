package net.feltmc.abstractium.abstraction.common.registration;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.registration.AbstractRegistrar;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import java.util.List;

public interface Registrar1182 extends AbstractRegistrar {
    AbstractiumAccess<Registrar1182, AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment>> ACCESS = new AbstractiumAccess<>(handler -> () -> handler);

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }

    @Override
    default void registerBlock() {

    }

    @Override
    default void registerItem() {

    }

    @Override
    default void registerBoat() {

    }

    @Override
    default void registerPlacer() {

    }

    @Override
    default void registerFeature() {

    }

    @Override
    default void registerCarver() {

    }

    @Override
    default void registerBiome(Identifier identifier, Biome biome) {

    }
}
