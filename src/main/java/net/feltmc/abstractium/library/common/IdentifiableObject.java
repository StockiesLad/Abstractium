package net.feltmc.abstractium.library.common;

import net.minecraft.util.Identifier;

public record IdentifiableObject<T>(Identifier identifier, T obj) {
}
