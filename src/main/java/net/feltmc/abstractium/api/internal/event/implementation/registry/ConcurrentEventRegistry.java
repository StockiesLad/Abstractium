package net.feltmc.abstractium.api.internal.event.implementation.registry;

import net.feltmc.abstractium.api.internal.event.core.AbstractEventRegistry;
import net.feltmc.abstractium.api.internal.event.core.args.EventArgs;

import java.util.Comparator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentEventRegistry<Context> extends AbstractEventRegistry<
        Context,
        Queue<EventArgs<Context>>,
        ConcurrentSkipListMap<Long, Queue<EventArgs<Context>>>,
        Map<String, ConcurrentSkipListMap<Long, Queue<EventArgs<Context>>>>
        > {

    public final Map<String, ConcurrentSkipListMap<Long, Queue<EventArgs<Context>>>> args;

    public ConcurrentEventRegistry(Comparator<Long> comparator) {
        super(comparator);
        args = new ConcurrentHashMap<>();
    }

    public ConcurrentEventRegistry() {
        this(Comparator.reverseOrder());
    }

    @Override
    public Map<String, ConcurrentSkipListMap<Long, Queue<EventArgs<Context>>>> getData() {
        return args;
    }

    @Override
    public boolean isEmpty() {
        if (args.isEmpty())
            return true;
        else {
            for (final var priorityMap : args.values()) {
                if (!isEmpty(priorityMap)) {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty(ConcurrentSkipListMap<Long, Queue<EventArgs<Context>>> priorityHandler) {
        if (priorityHandler == null)
            return true;
        if (priorityHandler.isEmpty())
            return true;
        else {
            for (final var eventArgs : priorityHandler.values()) {
                if (!isEmpty(eventArgs))
                    return false;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty(Queue<EventArgs<Context>> priorities) {
        if (priorities == null)
            return true;
        else return priorities.isEmpty();
    }

    @Override
    public void clean() {
        args.forEach((location, priorityMap) -> {
            priorityMap.forEach((priority, eventArgs) -> {
                if (isEmpty(eventArgs)) {
                    priorityMap.remove(priority, eventArgs);
                }
            });
            if (isEmpty(priorityMap))
                args.remove(location);
        });
    }

    @Override
    public void remove(String location, long priority, EventArgs<Context> eventArgs) {
        args.get(location).get(priority).remove(eventArgs);
        clean();
    }

    @Override
    public void add(String location, long priority, EventArgs<Context> eventArgs) {
        args.putIfAbsent(location, new ConcurrentSkipListMap<>());
        add(args.get(location), priority, eventArgs);
    }

    @Override
    public void add(
            ConcurrentSkipListMap<Long, Queue<EventArgs<Context>>> priorityMap,
            long priority,
            EventArgs<Context> eventArgs
    ) {
        priorityMap.putIfAbsent(priority, new ConcurrentLinkedQueue<>());
        priorityMap.get(priority).add(eventArgs);
    }

    @Override
    public void addAll(AbstractEventRegistry<Context, Queue<EventArgs<Context>>, ConcurrentSkipListMap<Long, Queue<EventArgs<Context>>>, Map<String, ConcurrentSkipListMap<Long, Queue<EventArgs<Context>>>>> eventRegistry) {
        eventRegistry.getData().forEach((location, priorityMap) ->
                priorityMap.forEach((priority, eventArgs) ->
                        addAll(location, priority, eventArgs)
                ));
    }

    @Override
    public void addAll(String location, long priority, Queue<EventArgs<Context>> eventArgs) {
        args.putIfAbsent(location, new ConcurrentSkipListMap<>());
        addAll(args.get(location), priority, eventArgs);
    }

    @Override
    public void addAll(
            ConcurrentSkipListMap<Long, Queue<EventArgs<Context>>> priorityMap,
            long priority,
            Queue<EventArgs<Context>> eventArgs
    ) {
        priorityMap.putIfAbsent(priority, eventArgs);
        priorityMap.get(priority).addAll(eventArgs);
    }
}
