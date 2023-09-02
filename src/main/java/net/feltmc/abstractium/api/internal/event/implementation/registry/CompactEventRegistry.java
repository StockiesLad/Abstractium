package net.feltmc.abstractium.api.internal.event.implementation.registry;

import net.feltmc.abstractium.api.internal.event.core.AbstractEventRegistry;
import net.feltmc.abstractium.api.internal.event.core.args.EventArgs;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class CompactEventRegistry<Context> extends AbstractEventRegistry<
        Context,
        List<EventArgs<Context>>,
        Map<Long, List<EventArgs<Context>>>,
        Map<String, Map<Long, List<EventArgs<Context>>>>
        > {

    public final Map<String, Map<Long, List<EventArgs<Context>>>> args;

    public CompactEventRegistry(Comparator<Long> comparator) {
        super(comparator);
        args = new HashMap<>();
    }

    public CompactEventRegistry() {
        this(Comparator.reverseOrder());
    }

    @Override
    public Map<String, Map<Long, List<EventArgs<Context>>>> getData() {
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
    public boolean isEmpty(Map<Long, List<EventArgs<Context>>> priorityHandler) {
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
    public boolean isEmpty(List<EventArgs<Context>> priorities) {
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
        args.putIfAbsent(location, new HashMap<>());
        add(args.get(location), priority, eventArgs);
    }

    @Override
    public void add(
            Map<Long, List<EventArgs<Context>>> priorityMap,
            long priority,
            EventArgs<Context> eventArgs
    ) {
        priorityMap.putIfAbsent(priority, new ArrayList<>());
        priorityMap.get(priority).add(eventArgs);
    }

    @Override
    public void addAll(AbstractEventRegistry<Context, List<EventArgs<Context>>, Map<Long, List<EventArgs<Context>>>, Map<String, Map<Long, List<EventArgs<Context>>>>> eventRegistry) {
        eventRegistry.getData().forEach((location, priorityMap) ->
                priorityMap.forEach((priority, eventArgs) ->
                        addAll(location, priority, eventArgs)
                ));
    }

    @Override
    public void addAll(String location, long priority, List<EventArgs<Context>> eventArgs) {
        args.putIfAbsent(location, new ConcurrentSkipListMap<>());
        addAll(args.get(location), priority, eventArgs);
    }

    @Override
    public void addAll(
            Map<Long, List<EventArgs<Context>>> priorityMap,
            long priority,
            List<EventArgs<Context>> eventArgs
    ) {
        priorityMap.putIfAbsent(priority, eventArgs);
        priorityMap.get(priority).addAll(eventArgs);
    }
}
