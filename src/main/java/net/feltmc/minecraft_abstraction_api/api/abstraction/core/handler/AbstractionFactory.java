package net.feltmc.minecraft_abstraction_api.api.abstraction.core.handler;

import net.feltmc.minecraft_abstraction_api.api.abstraction.def.MinecraftAbstraction;
import net.feltmc.minecraft_abstraction_api.api.events.AbstractEvent;
import net.feltmc.minecraft_abstraction_api.util.obj_holders.MutableObjectHolder;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class AbstractionFactory {
    public static <A extends MethodAbstractionApi> AbstractionHandler<A> create(
            final String name,
            final List<String> abstractionModIds,
            final AbstractionHandler.Environment common,
            final Consumer<AbstractEvent<MutableObjectHolder<A>>> base,
            final Function<A, AbstractionDirectory<A>> abstractionInstanceGetter
    )  {
        return new AbstractionHandler<>(name, abstractionModIds, common, base, abstractionInstanceGetter);
    }

    public static <A extends MethodAbstractionApi> AbstractionHandler<A> create(
            final String name,
            final List<String> abstractionModIds,
            final AbstractionHandler.Environment common,
            final Consumer<AbstractEvent<MutableObjectHolder<A>>> base
    ) {
        return new AbstractionHandler<>(name, abstractionModIds, common, base, MinecraftAbstraction::new);
    }
}
