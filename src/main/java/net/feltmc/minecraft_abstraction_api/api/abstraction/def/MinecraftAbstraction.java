package net.feltmc.minecraft_abstraction_api.api.abstraction.def;

import net.feltmc.minecraft_abstraction_api.api.abstraction.core.handler.AbstractionDirectory;
import net.feltmc.minecraft_abstraction_api.api.abstraction.core.versioning.VersionUtil;
import net.feltmc.minecraft_abstraction_api.api.abstraction.core.handler.MethodAbstractionApi;

public class MinecraftAbstraction<A extends MethodAbstractionApi> implements AbstractionDirectory<A> {
    private final VersionUtil.GameSpecific versionUtil;
    private final A abstractedClient;

    public MinecraftAbstraction(A clientCalls) {
        abstractedClient = clientCalls;
        versionUtil = VersionUtils.MINECRAFT;
    }

    @Override
    public VersionUtil.GameSpecific getVersionUtil() {
        return versionUtil;
    }

    @Override
    public A getAbstractedEntries() {
        return abstractedClient;
    }
}
