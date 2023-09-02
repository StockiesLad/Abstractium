package net.feltmc.abstractium.api.internal.event.implementation;

import net.feltmc.abstractium.api.internal.event.core.AbstractEvent;
import net.feltmc.abstractium.api.internal.event.core.args.EventArgs;
import net.feltmc.abstractium.api.internal.event.implementation.registry.ConcurrentEventRegistry;

/**
 * EmptyEvent is used to debug events by essentially turning them off by assigning them this class.
 */
public class EmptyEvent<T> implements AbstractEvent<T> {

    private final ConcurrentEventRegistry<T> storage = new ConcurrentEventRegistry<>();

    @Override
    public void clean() {}

    @Override
    public ConcurrentEventRegistry<T> getRegistry() {
        return storage;
    }
    @Override
    public void removeListener(long priority, String location, EventArgs<T> eventArgs) {}

    @Override
    public void registerListener(long priority, String location, EventArgs<T> argsProvider) {}

    @Override
    public void execute(String locations, T eventContext) {}
}
