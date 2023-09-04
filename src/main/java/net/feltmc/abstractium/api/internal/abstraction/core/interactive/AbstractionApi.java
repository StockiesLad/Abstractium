package net.feltmc.abstractium.api.internal.abstraction.core.interactive;

import net.feltmc.abstractium.api.internal.abstraction.core.versioning.SupportedVersions;

import java.util.List;

@SuppressWarnings({"TypeParameterHidesVisibleType", "unchecked"})
public interface AbstractionApi<Abstraction extends AbstractionApi<
        Abstraction, Environment>,
        Environment extends Enum<Environment>>
        extends SupportedVersions, AbstractionHandlerProvider<Abstraction, Environment>
{

    List<SubAbstractionApi<?>> getSubAbstractions();

    default SubAbstractionApi<?> locateSubAbstraction(String className) {
        final var list = getSubAbstractions();
        for (SubAbstractionApi<?> subAbstraction : list)
            if (subAbstraction.getClass().getName().equals(className))
                return subAbstraction;
        throw new NullPointerException("Couldn't find subAbstraction {" + className + "} in {" + list + "}");
    }

    default <Abstraction extends AbstractionApi<Abstraction, ?>> Abstraction generify() {
        return (Abstraction) this;
    }

    default void loadClasses() {}
}
