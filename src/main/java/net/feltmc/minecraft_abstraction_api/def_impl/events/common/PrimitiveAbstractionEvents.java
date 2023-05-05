package net.feltmc.minecraft_abstraction_api.def_impl.events.common;

import net.feltmc.minecraft_abstraction_api.util.obj_holders.MutableObjectHolder;
import net.feltmc.minecraft_abstraction_api.api.events.AbstractEvent;
import net.feltmc.minecraft_abstraction_api.api.events.CapableEvent;
import net.feltmc.minecraft_abstraction_api.def_impl.events.common.context.EmptyContext;

public interface PrimitiveAbstractionEvents {
    static void init() {}
    AbstractEvent<EmptyContext> EMPTY_EVENT =  new CapableEvent<>();
    AbstractEvent<MutableObjectHolder<Boolean>> BOOLEAN_EVENT = new CapableEvent<>();
    AbstractEvent<MutableObjectHolder<Integer>> INTEGER_EVENT = new CapableEvent<>();
    AbstractEvent<MutableObjectHolder<Runnable>> RUNNABLE_EVENT = new CapableEvent<>();
}
