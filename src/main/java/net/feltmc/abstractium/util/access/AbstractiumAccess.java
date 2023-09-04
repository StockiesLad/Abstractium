package net.feltmc.abstractium.util.access;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class AbstractiumAccess<T, A extends AbstractionHandler<?, ?>> {
    private final Function<A, T> func;
    private final Map<A, T> map;
    public AbstractiumAccess(Function<A, T> func) {
        this.func = func;
        this.map = new HashMap<>();
    }
    public T getInstance(A handler) {
        map.putIfAbsent(handler, func.apply(handler));
        return map.get(handler);
    }
}
