package net.feltmc.abstractium.abstraction_1182.common;

import net.feltmc.abstractium.abstraction_1182.common.itemgroup.ItemgroupHandler1182;
import net.feltmc.abstractium.abstraction_1182.common.registration.Registrar1182;
import net.feltmc.abstractium.abstraction_1182.common.worldgen.biome.BiomeGenerator1182;
import net.feltmc.abstractium.abstraction_1182.common.worldgen.structure.StructureGenerator1182;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.itemgroup.AbstractItemgroupHandler;
import net.feltmc.abstractium.library.common.registration.AbstractRegistrar;
import net.feltmc.abstractium.library.common.worldgen.biome.AbstractBiomeGenerator;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractStructureGenerator;

public class CommonCalls1182 extends AbstractCommonCalls {
    public CommonCalls1182(AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment> handler) {
        super(handler);
    }

    @Override
    public String[] getSupportedVersions() {
        return new String[] {
                "1.18.2"
        };
    }

    @Override
    public AbstractRegistrar getRegistrar() {
        return Registrar1182.ACCESS.getInstance(getHandler());
    }

    @Override
    public AbstractItemgroupHandler getItemgroupHandler() {
        return ItemgroupHandler1182.ACCESS.getInstance(getHandler());
    }

    @Override
    public AbstractStructureGenerator getStructureGenerator() {
        return StructureGenerator1182.ACCESS.getInstance(getHandler());
    }

    @Override
    public AbstractBiomeGenerator getBiomeGenerator() {
        return BiomeGenerator1182.ACCESS.getInstance(getHandler());
    }
}
