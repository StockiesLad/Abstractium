package net.feltmc.abstractium.api.abstraction.def;

import net.feltmc.abstractium.api.abstraction.core.handler.AbstractionDirectory;
import net.feltmc.abstractium.api.abstraction.core.handler.MethodAbstractionApi;
import net.feltmc.abstractium.api.abstraction.core.versioning.VersionUtil;

public class DefaultAbstraction<Abstraction extends MethodAbstractionApi> implements AbstractionDirectory<Abstraction> {
    private final VersionUtil versionUtil;
    private final Abstraction abstraction;

    public DefaultAbstraction(Abstraction abstraction, VersionUtil versionUtil) {
        this.abstraction = abstraction;
        this.versionUtil = versionUtil;
    }

    @Override
    public VersionUtil getVersionUtil() {
        return versionUtil;
    }

    @Override
    public Abstraction getAbstractedEntries() {
        return abstraction;
    }
}
