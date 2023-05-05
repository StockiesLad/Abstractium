package net.feltmc.minecraft_abstraction_api.util.obj_holders;

public class ImmutableObjectHolder<T> implements ObjectHolder<T> {

    protected T heldObj;

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
}
