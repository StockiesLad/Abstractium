package net.feltmc.minecraft_abstraction_api.api.abstraction.core.handler;

import net.feltmc.minecraft_abstraction_api.api.events.AbstractEvent;
import net.feltmc.minecraft_abstraction_api.util.obj_holders.MutableObjectHolder;

public interface AbstractionEntrypoint {
    <A extends MethodAbstractionApi> void register(AbstractEvent<MutableObjectHolder<A>> clientAbstractionEvent);
}
