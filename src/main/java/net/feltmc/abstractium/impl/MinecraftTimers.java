package net.feltmc.abstractium.impl;

import net.feltmc.abstractium.util.TickTimer;

import static net.feltmc.abstractium.api.abstraction.def.MinecraftEnvironment.CLIENT;
import static net.feltmc.abstractium.api.abstraction.def.MinecraftEnvironment.COMMON;

@SuppressWarnings("unused")
public interface MinecraftTimers {
    static void init() {}
    TickTimer CLIENT_TIMER = new TickTimer(CLIENT);
    TickTimer SERVER_TIMER = new TickTimer(COMMON);
}
