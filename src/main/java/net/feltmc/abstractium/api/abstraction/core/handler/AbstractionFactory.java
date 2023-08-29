package net.feltmc.abstractium.api.abstraction.core.handler;

import net.feltmc.abstractium.api.abstraction.def.Environment;
import net.feltmc.abstractium.api.abstraction.def.MinecraftAbstraction;
import net.feltmc.abstractium.api.event.core.AbstractEvent;
import net.feltmc.abstractium.util.obj_holders.MutableObjectHolder;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("unused")
public class AbstractionFactory {
    public static <A extends MethodAbstractionApi> AbstractionHandler<A> create(
            final String name,
            final List<String> abstractionModIds,
            final Environment common,
            final Consumer<AbstractEvent<MutableObjectHolder<A>>> base,
            final Function<A, AbstractionDirectory<A>> abstractionInstanceGetter
    )  {
        return new AbstractionHandler<>(name, abstractionModIds, common, base, abstractionInstanceGetter);
    }

    public static <A extends MethodAbstractionApi> AbstractionHandler<A> create(
            final String name,
            final List<String> abstractionModIds,
            final Environment common,
            final Consumer<AbstractEvent<MutableObjectHolder<A>>> base
    ) {
        return new AbstractionHandler<>(name, abstractionModIds, common, base, MinecraftAbstraction::new);
    }
}
