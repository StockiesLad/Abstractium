package net.feltmc.abstractium.impl.event.events;

import net.feltmc.abstractium.impl.event.events.context.EmptyContext;
import net.feltmc.abstractium.api.event.core.AbstractEvent;
import net.feltmc.abstractium.api.event.def.ConcurrentEvent;
import net.feltmc.abstractium.util.obj_holders.MutableObjectHolder;

public interface PrimitiveAbstractionEvents {
    static void init() {}
    AbstractEvent<EmptyContext> EMPTY_EVENT =  new ConcurrentEvent<>();
    AbstractEvent<MutableObjectHolder<Boolean>> BOOLEAN_EVENT = new ConcurrentEvent<>();
    AbstractEvent<MutableObjectHolder<Integer>> INTEGER_EVENT = new ConcurrentEvent<>();
    AbstractEvent<MutableObjectHolder<Runnable>> RUNNABLE_EVENT = new ConcurrentEvent<>();
}
