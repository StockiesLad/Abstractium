package net.feltmc.abstractium.api.abstraction.def;

import net.feltmc.abstractium.api.abstraction.core.handler.AbstractionDirectory;
import net.feltmc.abstractium.api.abstraction.core.versioning.VersionUtil;
import net.feltmc.abstractium.api.abstraction.core.handler.MethodAbstractionApi;

public class MinecraftAbstraction<A extends MethodAbstractionApi> implements AbstractionDirectory<A> {
    private final VersionUtil versionUtil;
    private final A abstractedClient;

    public MinecraftAbstraction(A clientCalls) {
        abstractedClient = clientCalls;
        versionUtil = VersionUtils.MINECRAFT;
    }

    @Override
    public VersionUtil getVersionUtil() {
        return versionUtil;
    }

    @Override
    public A getAbstractedEntries() {
        return abstractedClient;
    }
}
