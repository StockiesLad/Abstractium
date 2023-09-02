package net.feltmc.abstractium.api.external.abstraction;

import net.feltmc.abstractium.api.internal.abstraction.core.handler.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.core.versioning.VersionUtil;
import net.feltmc.abstractium.api.internal.abstraction.def.VersionUtils;

import java.util.List;

public class AbstractionHandlerFactory {
    public static
    <Abstraction extends AbstractionApi<Abstraction>, Environment extends Enum<Environment>>
    AbstractionHandler<Abstraction, Environment> genericAbstraction(
            final String name,
            final List<String> abstractionModIds,
            final Environment environment,
            final VersionUtil versionUtil
    )  {
        return new AbstractionHandler<>(name, abstractionModIds, environment, versionUtil);
    }

    public static <Abstraction extends AbstractionApi<Abstraction>, Environment extends Enum<Environment>>
    AbstractionHandler<Abstraction, Environment> minecraftAbstraction(
            final String name,
            final List<String> abstractionModIds,
            final Environment environment
    ) {
        return genericAbstraction(name, abstractionModIds, environment, VersionUtils.MINECRAFT);
    }
}
