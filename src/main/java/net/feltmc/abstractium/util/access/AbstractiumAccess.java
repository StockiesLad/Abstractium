package net.feltmc.abstractium.util.access;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;

public final class AbstractiumAccess<T> {
    private final T t;
    private AbstractiumAccess(T t) {
        this.t = t;
    }
    public T getInstance(AbstractionHandler<?, ?> handler) {
        if (handler != null) {
            handler.identityCall();
            return t;
        } else throw new IllegalCallerException("Trying to access " + t.getClass().getName() + " without " +
                "a valid abstraction instance. This is not allowed. Please access it through proper means!");
    }

    public static <T> AbstractiumAccess<T> create(T t) {
        return new AbstractiumAccess<>(t);
    }
}
