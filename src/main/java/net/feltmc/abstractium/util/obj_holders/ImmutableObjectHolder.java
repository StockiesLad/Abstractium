package net.feltmc.abstractium.util.obj_holders;

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
    public ObjectHolder<T> mutateHeldObj(T newObj) {
        return new ImmutableObjectHolder<>(heldObj);
    }
}
