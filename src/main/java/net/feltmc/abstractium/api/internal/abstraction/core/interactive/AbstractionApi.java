package net.feltmc.abstractium.api.internal.abstraction.core.interactive;

import net.feltmc.abstractium.api.internal.abstraction.core.versioning.VersionUtil;
import net.feltmc.abstractium.api.internal.abstraction.core.versioning.Versionable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"TypeParameterHidesVisibleType", "unchecked"})
public interface AbstractionApi<
        Abstraction extends AbstractionApi<Abstraction, Environment>,
        Environment extends Enum<Environment>>
        extends Versionable
{
    AbstractionHandler<Abstraction, Environment> getHandler();

    default List<AbstractionApi<?, ?>> getSubAbstractions() {
        return List.of();
    }

    default AbstractionApi<?, ?> locateSubAbstractions(String className) {
        final var list = getSubAbstractions();
        for (AbstractionApi<?, ?> subAbstraction : list)
            if (subAbstraction.getClass().getName().equals(className))
                return subAbstraction;
        throw new NullPointerException("Couldn't find subAbstraction {" + className + "} in {" + list + "}");
    }

    default boolean isEverythingOnCorrectVersion(final VersionUtil versionUtil) {
        if (isOnCorrectVersion(versionUtil))
            for (var subAbstraction : getSubAbstractions())
                if (!subAbstraction.isEverythingOnCorrectVersion(versionUtil))
                    return false;
       return false;
    }

    default List<AbstractionApi<?, ?>> getOutOfDateAbstractions(final VersionUtil versionUtil) {
        return getOutOfDateAbstractions(versionUtil, new ArrayList<>());
    }

    default List<AbstractionApi<?, ?>> getOutOfDateAbstractions(final VersionUtil versionUtil, List<AbstractionApi<?, ?>> outOfDateAbstractions) {
        if (!this.isOnCorrectVersion(versionUtil)) {
            outOfDateAbstractions.add(this);
        }
        for (var subAbstraction : getSubAbstractions()) {
            subAbstraction.getOutOfDateAbstractions(versionUtil, outOfDateAbstractions);
        }
        return outOfDateAbstractions;
    }

    default <Abstraction extends AbstractionApi<Abstraction, ?>> Abstraction generify() {
        return (Abstraction) this;
    }
}
