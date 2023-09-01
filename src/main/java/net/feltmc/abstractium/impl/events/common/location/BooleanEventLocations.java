package net.feltmc.abstractium.impl.events.common.location;

import net.feltmc.abstractium.api.abstraction.def.MinecraftEnvironment;

public interface BooleanEventLocations {
    String CLIENT = MinecraftEnvironment.CLIENT.name().toLowerCase();
    String SERVER = MinecraftEnvironment.COMMON.name().toLowerCase();

}
