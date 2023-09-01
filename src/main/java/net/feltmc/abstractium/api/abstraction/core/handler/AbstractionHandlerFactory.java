package net.feltmc.abstractium.api.abstraction.core.handler;

import net.feltmc.abstractium.api.abstraction.core.versioning.VersionUtil;
import net.feltmc.abstractium.api.abstraction.def.DefaultAbstraction;
import net.feltmc.abstractium.api.abstraction.def.VersionUtils;
import net.feltmc.abstractium.api.event.core.AbstractEvent;
import net.feltmc.abstractium.util.obj_holders.MutableObjectHolder;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class AbstractionHandlerFactory {
    public static
    <Abstraction extends MethodAbstractionApi, Environment extends Enum<Environment>>
    AbstractionHandler<Abstraction, Environment> uniqueAbstraction(
            final String name,
            final List<String> abstractionModIds,
            final Environment environment,
            final VersionUtil versionUtil,
            final BiFunction<Abstraction, VersionUtil, AbstractionDirectory<Abstraction>> abstractionInstanceGetter
    )  {
        return new AbstractionHandler<>(name, abstractionModIds, environment, versionUtil, abstractionInstanceGetter);
    }

    public static
    <Abstraction extends MethodAbstractionApi, Environment extends Enum<Environment>>
    AbstractionHandler<Abstraction, Environment> genericAbstraction(
            final String name,
            final List<String> abstractionModIds,
            final Environment environment,
            final VersionUtil versionUtil
    )  {
        return new AbstractionHandler<>(name, abstractionModIds, environment, versionUtil, DefaultAbstraction::new);
    }

    public static <Abstraction extends MethodAbstractionApi, Environment extends Enum<Environment>>
    AbstractionHandler<Abstraction, Environment> minecraftAbstraction(
            final String name,
            final List<String> abstractionModIds,
            final Environment environment,
            final Consumer<AbstractEvent<MutableObjectHolder<Abstraction>>> base
    ) {
        return genericAbstraction(name, abstractionModIds, environment, VersionUtils.MINECRAFT);
    }
}