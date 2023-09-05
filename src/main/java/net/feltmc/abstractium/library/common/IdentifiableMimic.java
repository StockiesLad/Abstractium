package net.feltmc.abstractium.library.common;

import net.feltmc.abstractium.util.obj_holders.Mimic;
import net.minecraft.util.Identifier;

public record IdentifiableMimic(Identifier identifier, Mimic mimic) {
    public static IdentifiableMimic create(Identifier identifier, String type, Object instance) {
        return new IdentifiableMimic(identifier, new Mimic(type, instance));
    }

    public void verify(String type) {
        if (!this.mimic().type().equals(type)) {
            throw new NullPointerException(
                    this.identifier() + " has the incorrect type! " +
                            "REQUIRED_TYPE=" + type + ", " +
                            "CURRENT_TYPE=" + this.mimic().type() + "."
            );
        }
    }
}
