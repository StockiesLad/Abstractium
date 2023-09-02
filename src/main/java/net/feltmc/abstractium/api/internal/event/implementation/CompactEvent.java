package net.feltmc.abstractium.api.internal.event.implementation;

import net.feltmc.abstractium.api.internal.event.core.AbstractEvent;
import net.feltmc.abstractium.api.internal.event.core.args.EventArgs;
import net.feltmc.abstractium.api.internal.event.core.EventStatus;
import net.feltmc.abstractium.api.internal.event.implementation.registry.CompactEventRegistry;
import net.feltmc.abstractium.util.obj_holders.MutableObjectHolder;
import net.feltmc.abstractium.util.obj_holders.ObjectHolder;

import java.util.Comparator;
import java.util.List;

import static net.feltmc.abstractium.api.internal.event.core.EventStatus.*;


public class CompactEvent<Context> implements AbstractEvent<Context> {
    private final CompactEventRegistry<Context> compactEventRegistry;

    public CompactEvent(final Comparator<Long> eventOrder) {
        compactEventRegistry = new CompactEventRegistry<>(eventOrder);
    }

    public CompactEvent() {
        this(Comparator.reverseOrder());
    }

    @Override
    public CompactEventRegistry<Context> getRegistry() {
        return compactEventRegistry;
    }

    @Override
    public void removeListener(long priority, String location, EventArgs<Context> eventArgs) {
        compactEventRegistry.remove(location, priority, eventArgs);
    }

    @Override
    public void registerListener(long priority, String location, EventArgs<Context> eventArgs) {
        compactEventRegistry.add(location, priority, eventArgs);
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