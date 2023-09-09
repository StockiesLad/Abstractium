package net.feltmc.abstractium.abstraction_1182.common;

import net.feltmc.abstractium.abstraction_1182.common.itemgroup.ItemgroupHandler1182;
import net.feltmc.abstractium.abstraction_1182.common.registration.Registrar1182;
import net.feltmc.abstractium.abstraction_1182.common.worldgen.biome.BiomeGenerator1182;
import net.feltmc.abstractium.abstraction_1182.common.worldgen.structure.StructureCreator1182;
import net.feltmc.abstractium.abstraction_1182.common.worldgen.structure.StructureGenerator1182;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.itemgroup.AbstractItemgroupHandler;
import net.feltmc.abstractium.library.common.registration.AbstractRegistrar;
import net.feltmc.abstractium.library.common.worldgen.biome.AbstractBiomeGenerator;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureCreator;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureGenerator;

import java.util.List;

public interface CommonCalls1182 extends AbstractCommonCalls {

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }

    @Override
    default AbstractRegistrar getRegistrar() {
        return Registrar1182.ACCESS.getInstance(getHandler());
    }

    @Override
    default AbstractItemgroupHandler getItemgroupHandler() {
        return ItemgroupHandler1182.ACCESS.getInstance(getHandler());
    }

    @Override
    default AbstractStructureGenerator getStructureGenerator() {
        return StructureGenerator1182.ACCESS.getInstance(getHandler());
    }

    @Override
    default AbstractStructureCreator getStructureCreator() {
        return StructureCreator1182.ACCESS.getInstance(getHandler());
    }

    @Override
    default AbstractBiomeGenerator getBiomeGenerator() {
        return BiomeGenerator1182.ACCESS.getInstance(getHandler());
    }
}
