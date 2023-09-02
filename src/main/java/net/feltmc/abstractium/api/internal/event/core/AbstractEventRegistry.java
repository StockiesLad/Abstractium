package net.feltmc.abstractium.api.internal.event.core;

import net.feltmc.abstractium.api.internal.event.core.args.EventArgs;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

public abstract class AbstractEventRegistry<
        Context,
        ArgsCollection extends Collection<EventArgs<Context>>,
        PriorityMapType extends Map<Long, ArgsCollection>,
        LocationMapType extends Map<String, PriorityMapType>
        >
{
    public final Comparator<Long> comparator;

    public AbstractEventRegistry(Comparator<Long> comparator) {
        this.comparator = comparator;
    }

    public abstract LocationMapType getData();
    public abstract boolean isEmpty();
    public abstract boolean isEmpty(PriorityMapType priorityHandler);
    public abstract boolean isEmpty(ArgsCollection priorities);
    public abstract void clean();
    public abstract void remove(String location, long priority, EventArgs<Context> eventArgs);
    public abstract void add(String location, long priority, EventArgs<Context> eventArgs);
    public abstract void add(PriorityMapType priorityMap, long priority, EventArgs<Context> eventArgs);
    public abstract void addAll(AbstractEventRegistry<Context, ArgsCollection, PriorityMapType, LocationMapType> eventRegistry);
    public abstract void addAll(String location, long priority, ArgsCollection eventArgs);
    public abstract void addAll(PriorityMapType priorityMap, long priority, ArgsCollection eventArgs);
    @Override
    public String toString() {
        return "EventRegistry[" + getData() +"]@" + hashCode();
    }
}
