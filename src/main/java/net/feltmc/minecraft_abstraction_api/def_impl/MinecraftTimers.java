package net.feltmc.minecraft_abstraction_api.def_impl;

import net.feltmc.minecraft_abstraction_api.util.TickTimer;

import static net.feltmc.minecraft_abstraction_api.def_impl.events.common.location.BooleanEventLocations.MinecraftEnvironment.CLIENT;
import static net.feltmc.minecraft_abstraction_api.def_impl.events.common.location.BooleanEventLocations.MinecraftEnvironment.SERVER;

@SuppressWarnings("unused")
public interface MinecraftTimers {
    TickTimer CLIENT_TIMER = new TickTimer(CLIENT);
    TickTimer SERVER_TIMER = new TickTimer(SERVER);
}
