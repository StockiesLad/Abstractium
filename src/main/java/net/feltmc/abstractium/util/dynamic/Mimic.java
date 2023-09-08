package net.feltmc.abstractium.util.dynamic;

import net.minecraft.util.Identifier;

public record Mimic(String identity, TypeObject objectType, Object instance) {
    public Mimic(Identifier identifier, TypeObject objectType, Object instance) {
        this(identifier.toString(), objectType, instance);
    }

    public <T> T cast(TypeObject staticType) {
        return staticType.castFromObjectTypeOrThrow(this);
    }
}
