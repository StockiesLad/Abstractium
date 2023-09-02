package net.feltmc.abstractium.api.internal.abstraction.core.handler;

import net.feltmc.abstractium.api.external.abstraction.AbstractionApi;
import net.feltmc.abstractium.api.external.abstraction.AbstractionEntrypoint;
import net.feltmc.abstractium.api.internal.abstraction.core.versioning.VersionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.fabricmc.loader.api.FabricLoader.getInstance;

public final class AbstractionHandler<Abstraction extends AbstractionApi<Abstraction>, Environment extends Enum<Environment>> extends AbstractVersionHandler<Abstraction> {
    public final List<String> abstractionModIds;
    public final Environment environment;
    public final String entrypointName;
    public final VersionUtil versionUtil;
    public final Abstraction abstraction;

    public AbstractionHandler(
            final String namespace,
            final List<String> abstractionModIds,
            final Environment environment,
            final VersionUtil versionUtil
    ) {
        final List<Abstraction> abstractions = new ArrayList<>();
        final String entrypointName = namespace.toLowerCase() + "_" + environment.name().toLowerCase();

        getInstance().getEntrypointContainers(entrypointName, AbstractionEntrypoint.class)
                .forEach(container -> abstractionModIds.forEach(abstractionModId -> {
                    if (container.getProvider().getMetadata().getId().equals(abstractionModId)) {
                        final var entrypoint = container.getEntrypoint();
                        entrypoint.loadClasses(this);
                        entrypoint.register(abstractions, this);
                    }
                }));

        List<Abstraction> supportedAbstractions = new ArrayList<>();
        for (Abstraction supportedAbstraction : abstractions) {
            if (isSupported(supportedAbstraction))
                supportedAbstractions.add(supportedAbstraction);
        }

        this.abstractionModIds = abstractionModIds;
        this.environment = environment;
        this.entrypointName = entrypointName;
        this.versionUtil = versionUtil;

        if (supportedAbstractions.size() == 0) {
            throw new NullPointerException("There aren't any supported abstractions for " + this);
        }
        if (supportedAbstractions.size() > 1) {
            throw new UnsupportedOperationException("There are multiple supported abstractions for " + this);
        }
        this.abstraction = supportedAbstractions.get(0);

    }

    @Override
    protected Abstraction getAbstraction() {
        return abstraction;
    }

    @Override
    protected VersionUtil getVersionUtil() {
        return versionUtil;
    }

    @Override
    public String toString() {
        return "AbstractionHandler[Env={" + environment.name() +"}, EntrypointName={" + entrypointName +"}, " +
                "EntrypointModIds={" + Arrays.toString(abstractionModIds.toArray()) + "}, VersionUtil={" +
                versionUtil + "}]@" + hashCode();
    }
}
