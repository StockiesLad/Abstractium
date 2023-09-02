package net.feltmc.abstractium.api.external.event.events.location;

import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;

public interface BooleanEventLocations {
    String CLIENT = MinecraftEnvironment.CLIENT.name().toLowerCase();
    String SERVER = MinecraftEnvironment.COMMON.name().toLowerCase();

}
