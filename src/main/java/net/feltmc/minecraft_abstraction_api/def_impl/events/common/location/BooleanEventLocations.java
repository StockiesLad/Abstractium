package net.feltmc.minecraft_abstraction_api.def_impl.events.common.location;

public interface BooleanEventLocations {
    String CLIENT = MinecraftEnvironment.CLIENT.name().toLowerCase();
    String SERVER = MinecraftEnvironment.SERVER.name().toLowerCase();

    enum MinecraftEnvironment {
        CLIENT,
        SERVER
    }
}
