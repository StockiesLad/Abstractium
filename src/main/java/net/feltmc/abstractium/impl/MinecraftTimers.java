package net.feltmc.abstractium.impl;

import net.feltmc.abstractium.util.TickTimer;

import static net.feltmc.abstractium.api.abstraction.def.Environment.CLIENT;
import static net.feltmc.abstractium.api.abstraction.def.Environment.SERVER;

@SuppressWarnings("unused")
public interface MinecraftTimers {
    static void init() {}
    TickTimer CLIENT_TIMER = new TickTimer(CLIENT);
    TickTimer SERVER_TIMER = new TickTimer(SERVER);
}
