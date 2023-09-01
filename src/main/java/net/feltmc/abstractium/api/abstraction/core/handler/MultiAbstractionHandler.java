package net.feltmc.abstractium.api.abstraction.core.handler;

import net.feltmc.abstractium.api.abstraction.core.versioning.VersionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static net.feltmc.abstractium.api.abstraction.core.handler.AbstractionHandlerFactory.*;

public class MultiAbstractionHandler<Abstraction extends MethodAbstractionApi, Environment extends Enum<Environment>> {
    private final Map<Environment, AbstractionHandler<Abstraction, Environment>> abstractions;
    private final String name;
    private final List<String> abstractionModIds;
    private final VersionUtil versionUtil;
    private final BiFunction<Abstraction, VersionUtil, AbstractionDirectory<Abstraction>> abstractionInstanceGetter;

    MultiAbstractionHandler(
            final String name,
            final List<String> abstractionModIds,
            final VersionUtil versionUtil,
            BiFunction<Abstraction, VersionUtil, AbstractionDirectory<Abstraction>>abstractionInstanceGetter
    ) {
        this.abstractions = new HashMap<>();
        this.name = name;
        this.abstractionModIds = abstractionModIds;
        this.versionUtil = versionUtil;
        this.abstractionInstanceGetter = abstractionInstanceGetter;

    }

    public void createAbstraction(Environment environment) {
        abstractions.put(
                environment,
                uniqueAbstraction(
                        name,
                        abstractionModIds,
                        environment,
                        versionUtil,
                        abstractionInstanceGetter
                )
        );
    }

    public AbstractionHandler<Abstraction, Environment> getAbstraction(Environment environment) {
        return abstractions.get(environment);
    }
}
