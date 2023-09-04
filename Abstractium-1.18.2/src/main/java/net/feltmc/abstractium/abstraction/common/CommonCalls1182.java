package net.feltmc.abstractium.abstraction.common;

import net.feltmc.abstractium.abstraction.common.itemgroup.ItemgroupHandler1182;
import net.feltmc.abstractium.abstraction.common.registration.Registrar1182;
import net.feltmc.abstractium.abstraction.common.worldgen.biome.BiomeGenerator1182;
import net.feltmc.abstractium.abstraction.common.worldgen.structure.StructureGenerator1182;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.SubAbstractionApi;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.itemgroup.AbstractItemgroupHandler;
import net.feltmc.abstractium.library.common.registration.AbstractRegistrar;
import net.feltmc.abstractium.library.common.worldgen.biome.AbstractBiomeGenerator;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureGenerator;

import java.util.List;

public interface CommonCalls1182 extends AbstractCommonCalls {

    @Override
    default String[] getSupportedVersions() {
        return new String[] {
                "1.18.2"
        };
    }

    @Override
    default List<SubAbstractionApi<?>> getSubAbstractions() {
        return List.of(getRegistrar(), getItemgroupHandler(), getStructureGenerator(), getBiomeGenerator());
    }

    @Override
    default SubAbstractionApi<AbstractRegistrar> getRegistrar() {
        return () -> Registrar1182.ACCESS.getInstance(getHandler());
    }

    @Override
    default SubAbstractionApi<AbstractItemgroupHandler> getItemgroupHandler() {
        return () -> ItemgroupHandler1182.ACCESS.getInstance(getHandler());
    }

    @Override
    default SubAbstractionApi<AbstractStructureGenerator> getStructureGenerator() {
        return () -> StructureGenerator1182.ACCESS.getInstance(getHandler());
    }

    @Override
    default SubAbstractionApi<AbstractBiomeGenerator> getBiomeGenerator() {
        return () -> BiomeGenerator1182.ACCESS.getInstance(getHandler());
    }
}
