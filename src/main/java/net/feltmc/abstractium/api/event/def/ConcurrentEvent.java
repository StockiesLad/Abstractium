package net.feltmc.abstractium.api.event.def;

import net.feltmc.abstractium.api.event.core.AbstractEvent;
import net.feltmc.abstractium.api.event.core.EventArgs;
import net.feltmc.abstractium.api.event.core.EventStatus;
import net.feltmc.abstractium.api.event.def.registry.ConcurrentEventRegistry;
import net.feltmc.abstractium.util.obj_holders.MutableObjectHolder;
import net.feltmc.abstractium.util.obj_holders.ObjectHolder;

import java.util.Comparator;
import java.util.List;

import static net.feltmc.abstractium.api.event.core.EventStatus.*;


public class ConcurrentEvent<Context> implements AbstractEvent<Context> {
    private final ConcurrentEventRegistry<Context> concurrentEventRegistry;

    public ConcurrentEvent(final Comparator<Long> eventOrder) {
        concurrentEventRegistry = new ConcurrentEventRegistry<>(eventOrder);
    }

    public ConcurrentEvent() {
        this(Comparator.reverseOrder());
    }

    @Override
    public ConcurrentEventRegistry<Context> getRegistry() {
        return concurrentEventRegistry;
    }

    @Override
    public void removeListener(long priority, String location, EventArgs<Context> eventArgs) {
        concurrentEventRegistry.remove(location, priority, eventArgs);
    }

    @Override
    public void registerListener(long priority, String location, EventArgs<Context> eventArgs) {
        concurrentEventRegistry.add(location, priority, eventArgs);
    }

    @Override
    public void execute(final String location, final Context eventContext) {
        ObjectHolder<EventStatus> statusHolder = new MutableObjectHolder<>(CONTINUE);
        final var all = getRegistry().args.get(location);
        if (all != null)
            for (final var eventArgs : all.values()) {
                for (EventArgs<Context> eventArg : eventArgs) {
                    eventArg.recursive(eventContext, statusHolder, this, 0, eventArg);
                    if (statusHolder.equalsAny(List.of(FINISH_PRIORITY, FINISH_LOCATION)))
                        break;
                }
                if (statusHolder.equalsAny(List.of(FINISH_LOCATION)))
                    break;
            }
    }
}