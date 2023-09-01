package net.feltmc.abstractium.api.abstraction.core.handler;

import net.feltmc.abstractium.api.abstraction.core.versioning.VersionUtil;
import net.feltmc.abstractium.api.abstraction.def.DefaultAbstraction;
import net.feltmc.abstractium.api.abstraction.def.VersionUtils;

import java.util.List;
import java.util.function.BiFunction;

public class MultiAbstractionHandlerFactory {
    public static <Abstraction extends MethodAbstractionApi, Environment extends Enum<Environment>>
    MultiAbstractionHandler<Abstraction, Environment> uniqueMultiAbstraction(
            final String name,
            final List<String> abstractionModIds,
            final VersionUtil versionUtil,
            final BiFunction<Abstraction, VersionUtil, AbstractionDirectory<Abstraction>> abstractionInstanceGetter
    )  {
        return new MultiAbstractionHandler<>(name, abstractionModIds, versionUtil, abstractionInstanceGetter);
    }

    public static <Abstraction extends MethodAbstractionApi, Environment extends Enum<Environment>>
    MultiAbstractionHandler<Abstraction, Environment> genericMultiAbstraction(
            final String name,
            final List<String> abstractionModIds,
            final VersionUtil versionUtil
    )  {
        return new MultiAbstractionHandler<>(name, abstractionModIds, versionUtil, DefaultAbstraction::new);
    }

    public static <Abstraction extends MethodAbstractionApi, Environment extends Enum<Environment>>
    MultiAbstractionHandler<Abstraction, Environment> minecraftMultiAbstraction(
            final String name,
            final List<String> abstractionModIds
    ) {
        return genericMultiAbstraction(name, abstractionModIds, VersionUtils.MINECRAFT);
    }
}
