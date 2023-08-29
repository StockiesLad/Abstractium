package net.feltmc.abstractium.impl.events.common.location;

import net.feltmc.abstractium.api.abstraction.def.Environment;

public interface BooleanEventLocations {
    String CLIENT = Environment.CLIENT.name().toLowerCase();
    String SERVER = Environment.SERVER.name().toLowerCase();

}
