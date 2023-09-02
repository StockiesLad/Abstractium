package net.feltmc.abstractium.api.internal.abstraction.core.versioning;

import net.feltmc.abstractium.api.internal.abstraction.core.versioning.strategy.ExceptionStrategy;
import net.feltmc.abstractium.api.internal.abstraction.core.versioning.strategy.MatchingStrategy;

import java.util.function.Function;


public class VersionUtil {
    public final String gameId;
    public final String providedVersion;
    public final MatchingStrategy defaultMatchingStrategy;
    public final ExceptionStrategy defaultException;

    public VersionUtil(
            final String gameId,
            final Function<String ,VersionPackage> providedVersion,
            final MatchingStrategy defaultMatchingStrategy,
            final ExceptionStrategy defaultException
    ) {
        this.gameId = gameId;
        this.providedVersion = providedVersion.apply(gameId).getVersion();
        this.defaultMatchingStrategy = defaultMatchingStrategy;
        this.defaultException = defaultException;

    }

    @Override
    public String toString() {
        return "VersionHelper.GameSpecific[id=" + gameId +",version= " + providedVersion +"]" + hashCode();
    }

    public boolean matchesAny(
            final String comparedVersion,
            final MatchingStrategy matchingStrategy,
            final ExceptionStrategy exceptionStrategy
    ) {
        return matchingStrategy.function.apply(providedVersion, comparedVersion) && exceptionStrategy.function.apply(providedVersion);
    }

    public boolean matchesAny(
            final String comparedVersion,
            final MatchingStrategy matchingStrategy
    ) {
        return matchesAny(comparedVersion, matchingStrategy, defaultException);
    }

    public boolean matchesAny(
            final String comparedVersion,
            final ExceptionStrategy exceptionStrategy
    ) {
        return matchesAny(comparedVersion, defaultMatchingStrategy, exceptionStrategy);
    }

    public boolean matchesAny(
            final String comparedVersion
    ) {
        return matchesAny(comparedVersion, defaultMatchingStrategy, defaultException);
    }
}
