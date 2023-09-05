package net.feltmc.abstractium.library.common;

public interface CommonMimicTypes {
    static String any() {
        return "?";
    }

    static String registryEntry(String type) {
        return "RegistryEntry<" + type + ">";
    }

    static String registryKey(String type) {
        return "RegistryKey<" + type + ">";
    }

    static String biome() {
        return "Biome";
    }

    static String configuredFeature(String type0, String type1) {
        return "ConfiguredFeature<" + type0 + "," + type1 +">";
    }

    static String placedFeature() {
        return "PlacedFeature";
    }

    static String configuredCarver(String type) {
        return "ConfiguredCarver<" + type + ">";
    }
}
