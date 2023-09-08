package net.feltmc.abstractium.library.common;

import net.feltmc.abstractium.util.dynamic.TypeObject;

import static net.feltmc.abstractium.util.dynamic.TypeObject.*;

public interface CommonTypeObjects {
    static TypeObject wildcard() {
        return ofWildcard();
    }

    static TypeObject registryEntry(TypeObject type) {
        return ofGenerics("RegistryEntry", type);
    }

    static TypeObject registryKey(TypeObject type) {
        return ofGenerics("RegistryKey", type);
    }

    static TypeObject biome() {
        return of("Biome");
    }

    static TypeObject configuredFeature(TypeObject type0, TypeObject type1) {
        return ofGenerics("ConfiguredFeature", type0, type1);

    }

    static TypeObject placedFeature() {
        return of("PlacedFeature");
    }

    static TypeObject configuredCarver(TypeObject type) {
        return ofGenerics("ConfiguredCarver", type);
    }
}
