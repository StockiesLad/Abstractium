package net.feltmc.abstractium.util.obj_holders;

import java.util.function.Function;

/**
 * It holds objects to allow modification through method calls.
 * @param <T> any object.
 */
public class MutableObjectHolder<T> extends ObjectHolder<T> {
    private T heldObj;
    public MutableObjectHolder(T heldObj) {
        this.heldObj = heldObj;
    }

    public MutableObjectHolder() {
        this(null);
    }

    @Override
    public T getHeldObj() {
        return heldObj;
    }

    @Override
    public ObjectHolder<T> mutateHeldObj(Function<T, T> mutatedObj) {
        heldObj = mutatedObj.apply(heldObj);
        return this;
    }
}
