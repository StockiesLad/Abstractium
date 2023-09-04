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
        return "VersionUtil[GameID={" + gameId +"}, Version={" + providedVersion +"}]@" + hashCode();
    }

    public boolean matches(
            final String comparedVersion,
            final MatchingStrategy matchingStrategy,
            final ExceptionStrategy exceptionStrategy
    ) {
        return matchingStrategy.function.apply(providedVersion, comparedVersion) && exceptionStrategy.function.apply(providedVersion);
    }

    public boolean matches(
            final String comparedVersion,
            final MatchingStrategy matchingStrategy
    ) {
        return matches(comparedVersion, matchingStrategy, defaultException);
    }

    public boolean matches(
            final String comparedVersion,
            final ExceptionStrategy exceptionStrategy
    ) {
        return matches(comparedVersion, defaultMatchingStrategy, exceptionStrategy);
    }

    public boolean matches(
            final String comparedVersion
    ) {
        return matches(comparedVersion, defaultMatchingStrategy, defaultException);
    }
}
