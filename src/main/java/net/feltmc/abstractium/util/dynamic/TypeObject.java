package net.feltmc.abstractium.util.dynamic;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public final class TypeObject {
    private final String name;
    private final List<TypeObject> generics;
    private final List<TypeObject> parents;

    private TypeObject(String name, List<TypeObject> generics, List<TypeObject> parents) {
        this.name = name;
        this.generics = generics;
        this.parents = parents;
    }

    public static TypeObject ofWildcard() {
        return new TypeObject("?", List.of(), List.of());
    }
    public static TypeObject ofWildcard(TypeObject... parents) {
        return new TypeObject("?", List.of(), List.of(parents));
    }

    public static TypeObject of(String name) {
        checkForIllegalWildcard(name);
        return new TypeObject(name, List.of(), List.of());
    }

    public static TypeObject of(String name, List<TypeObject> generics, List<TypeObject> parents) {
        checkForIllegalWildcard(name);
        return new TypeObject(name, generics, parents);
    }

    public static TypeObject ofGenerics(String name, TypeObject... generics) {
        checkForIllegalWildcard(name);
        return new TypeObject(name, Arrays.asList(generics), List.of());
    }

    public static TypeObject ofParents(String name, TypeObject... parents) {
        checkForIllegalWildcard(name);
        return new TypeObject(name, List.of(), Arrays.asList(parents));
    }

    private static void checkForIllegalWildcard(String name) {
        if (name.equals("?"))
            throw new IllegalArgumentException("Creating wildcards without usage of ofWildcard() is forbidden!");
    }

    public static boolean matches(TypeObject staticType, TypeObject objectType) {
        return matches(staticType, objectType, null);
    }

    /*
     * Static wildcard accepts any common parent/object with the object type;
     * Static generic can only accept the same object
     */
    private static boolean matches(TypeObject staticType, TypeObject objectType, StringBuilder tracer) {
        if (staticType == null || objectType == null) {
            throw new TypeObjectException("Cannot use null TypeObjects");
        }
        if (tracer != null) {
            tracer  .append("\n")
                    .append("       STATIC : ").append(staticType.asString()).append("\n")
                    .append("       OBJECT : ").append(objectType.asString()).append("\n");
        }
        if (staticType.name.equals(objectType.name) && staticType.generics.size() == objectType.generics.size() && !staticType.isWildcard() && !objectType.isWildcard()) {
            if (staticType.generics.size() == 0) {
                return true;
            }
            for (int i = 0; i < staticType.generics.size(); i++) {
                if (!matches(staticType.generics.get(i), objectType.generics.get(i), tracer))
                    return false;
            }
            return true;
        }
        if (staticType.isWildcard()) {
            if (staticType.parents.isEmpty()) {
                return true;
            }
            for (TypeObject wildcardParent : staticType.parents) {
                if (matches(wildcardParent, objectType, tracer)) {
                    return true;
                }
                for (TypeObject objectTypeParent : objectType.parents) {
                    if (matches(wildcardParent, objectTypeParent, tracer)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void checkOrThrow(TypeObject staticType, TypeObject objectType) {
        final StringBuilder trace = new StringBuilder();
        trace   .append("\n   Cannot cast types:")
                .append("\n       STATIC : ").append(staticType.asString())
                .append("\n       OBJECT : ").append(objectType.asString())
                .append("\n")
                .append("\n   Type Trace:");
        if (!matches(staticType, objectType, trace)) {
            trace.append("\nSTACKTRACE:");
            throw new TypeObjectException(trace.toString());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T castOrThrow(TypeObject staticType, TypeObject objectType, Object instance) {
        checkOrThrow(staticType, objectType);
        return (T) instance;
    }

    public <T> T castToStaticTypeOrThrow(TypeObject staticType, Object instance) {
        return castOrThrow(staticType, this, instance);
    }

    public <T> T castFromObjectTypeOrThrow(TypeObject objectType, Object instance) {
        return castOrThrow(this, objectType, instance);
    }

    public <T> T castFromObjectTypeOrThrow(Mimic mimic) {
        return castOrThrow(this, mimic.objectType(), mimic.instance());
    }

    public boolean matchToStaticType(TypeObject staticType) {
        return matches(staticType, this);
    }

    public boolean matchesFromObjectType(TypeObject objectType) {
        return matches(this, objectType);
    }

    public void checkToStaticTypeOrThrow(TypeObject staticType) {
        checkOrThrow(staticType, this);
    }

    public void checkFromObjectTypeOrThrow(TypeObject objectType) {
        checkOrThrow(this, objectType);
    }

    public boolean isWildcard() {
        return name.equals("?");
    }

    public String asString() {
        StringBuilder type = new StringBuilder(name);
        if (!this.generics.isEmpty()) {
            type.append("<");
            for (int i = 0; i < generics.size(); i++) {
                type.append(generics.get(i).asString());
                if (i < generics.size() - 1)
                    type.append(", ");
            }
            type.append(">");
        }
        if (!this.parents.isEmpty()) {
            type.append(" extends ");
            for (int i = 0; i < parents.size(); i++) {
                type.append(parents.get(i).asString());
                if (i < parents.size() - 1)
                    type.append(" & ");
            }
        }
        return type.toString();
    }

    @Override
    public String toString() {
        return "TypeObject[type={" + asString() + "}]@" + hashCode();
    }
}
