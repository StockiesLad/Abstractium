package net.feltmc.abstractium.api.internal.abstraction.core.interactive;

import net.feltmc.abstractium.api.internal.abstraction.core.versioning.VersionUtil;
import net.feltmc.abstractium.api.internal.abstraction.core.versioning.Versionable;
import net.feltmc.abstractium.init.AbstractiumConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.fabricmc.loader.api.FabricLoader.getInstance;

@SuppressWarnings({"unchecked", "TypeParameterHidesVisibleType"})
public final class AbstractionHandler<Abstraction extends AbstractionApi<Abstraction, Environment>, Environment extends Enum<Environment>> implements Versionable {
    public final List<String> abstractionModIds;
    public final Environment environment;
    public final String entrypointName;
    public final VersionUtil versionUtil;
    public final Abstraction abstraction;
    public final List<String> allRegisteredVerions;

    public AbstractionHandler(
            final String namespace,
            final List<String> abstractionModIds,
            final Environment environment,
            final VersionUtil versionUtil
    ) {
        final List<Abstraction> abstractions = new ArrayList<>();
        final String entrypointName = namespace.toLowerCase() + "_" + environment.name().toLowerCase();

        this.abstractionModIds = abstractionModIds;
        this.environment = environment;
        this.entrypointName = entrypointName;
        this.versionUtil = versionUtil;
        this.allRegisteredVerions = new ArrayList<>();

        getInstance().getEntrypointContainers(entrypointName, AbstractionEntrypoint.class)
                .forEach(container -> abstractionModIds.forEach(abstractionModId -> {
                    if (container.getProvider().getMetadata().getId().equals(abstractionModId)) {
                        final var entrypoint = container.getEntrypoint();
                        entrypoint.loadClasses(this);
                        entrypoint.register(abstractions, this);
                    }
                }));
        abstractions.forEach(abstraction -> allRegisteredVerions.addAll(abstraction.getSupportedVersions()));

        List<Abstraction> supportedAbstractions = new ArrayList<>();
        for (Abstraction supportedAbstraction : abstractions) {
            if (supportedAbstraction.isOnCorrectVersion(versionUtil))
                supportedAbstractions.add(supportedAbstraction);
        }

        if (supportedAbstractions.size() == 0) {
            throw new NullPointerException("There aren't any supported abstractions for (" + this + "). REGISTERED_" +
                    "CANDIDATES={" + abstractions +"}");
        }
        if (supportedAbstractions.size() > 1) {
            throw new UnsupportedOperationException("There are multiple supported abstractions for " + this);
        }

        this.abstraction = supportedAbstractions.get(0);

        final var outOfDateAbstractions = abstraction.getOutOfDateAbstractions(versionUtil);
        if (!outOfDateAbstractions.isEmpty())
            throw new NullPointerException("Sub-abstractions are not up to date! BROKEN_ABSTRACTIONS={" +
                    outOfDateAbstractions +"}");

        AbstractiumConstants.LOGGER.info("Successfully registered abstraction: " + this);
    }

    @Override
    public List<String> getSupportedVersions() {
        return abstraction.getSupportedVersions();
    }

    public <Abstraction extends AbstractionApi<Abstraction, Environment>, Environment extends Enum<Environment>>
    AbstractionHandler<Abstraction, Environment> generify() {
        return (AbstractionHandler<Abstraction, Environment>) this;
    }

    @Override
    public String toString() {
        return "AbstractionHandler[Env={" + environment.name() +"}, EntrypointName={" + entrypointName +"}, " +
                "EntrypointModIds={" + Arrays.toString(abstractionModIds.toArray()) + "}, VersionUtil={" +
                versionUtil + "}, AllRegisteredVersions={" + allRegisteredVerions + "}]@" + hashCode();
    }
}
