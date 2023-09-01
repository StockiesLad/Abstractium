package net.feltmc.abstractium.api.abstraction.core.handler;

import net.feltmc.abstractium.api.abstraction.core.versioning.VersionUtil;
import net.feltmc.abstractium.api.event.core.AbstractEvent;
import net.feltmc.abstractium.util.obj_holders.MutableObjectHolder;

public interface AbstractionEntrypoint {
    <A extends MethodAbstractionApi> void register(AbstractEvent<MutableObjectHolder<A>> clientAbstractionEvent);
    default void loadClasses(AbstractEvent<VersionUtil> classLoadEvent) {}
}
