package net.feltmc.abstractium.library.common.worldgen.biome;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.worldgen.structure.AbstractBiomes;
import net.minecraft.util.Identifier;

import java.util.List;

public interface AbstractBiomeGenerator extends AbstractionApi<AbstractCommonCalls, MinecraftEnvironment> {
    void generateBiomes(List<AbstractBiomeGenerationInfo> infos, Identifier identifier, int weight, AbstractBiomes context);
}
