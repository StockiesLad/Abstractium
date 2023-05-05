package net.feltmc.minecraft_abstraction_api.api.abstraction.common.location;

import net.feltmc.minecraft_abstraction_api.api.abstraction.def.Environment;

public interface BooleanEventLocations {
    String CLIENT = Environment.CLIENT.name().toLowerCase();
    String SERVER = Environment.SERVER.name().toLowerCase();

}
