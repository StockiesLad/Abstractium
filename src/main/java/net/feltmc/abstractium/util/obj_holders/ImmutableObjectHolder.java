package net.feltmc.abstractium.util.obj_holders;

import java.util.function.Function;

public class ImmutableObjectHolder<T> extends ObjectHolder<T> {
    private final T heldObj;

    public ImmutableObjectHolder(T heldObj) {
        this.heldObj = heldObj;
    }

    public ImmutableObjectHolder() {
        this(null);
    }

    @Override
    public T getHeldObj() {
        return heldObj;
    }

    @Override
    public ObjectHolder<T> mutateHeldObj(Function<T, T> mutatedObj) {
        return new ImmutableObjectHolder<>(mutatedObj.apply(heldObj));
    }
}
