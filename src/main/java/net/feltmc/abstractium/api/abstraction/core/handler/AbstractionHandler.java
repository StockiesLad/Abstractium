package net.feltmc.abstractium.api.abstraction.core.handler;

import net.feltmc.abstractium.api.abstraction.def.Environment;
import net.feltmc.abstractium.api.event.core.AbstractEvent;
import net.feltmc.abstractium.api.event.def.CompactEvent;
import net.feltmc.abstractium.util.obj_holders.MutableObjectHolder;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static net.fabricmc.loader.api.FabricLoader.getInstance;

public class AbstractionHandler<A extends MethodAbstractionApi> {
    public final AbstractionDirectory<A> directory;
    public final List<String> abstractionModIds;
    public final Environment environment;
    public final String entrypointName;

    AbstractionHandler(
            final String namespace,
            final List<String> abstractionModIds,
            final Environment environment,
            final Consumer<AbstractEvent<MutableObjectHolder<A>>> base,
            final Function<A, AbstractionDirectory<A>> abstractionInstanceGetter
    ) {
        final AbstractEvent<MutableObjectHolder<A>> event = new CompactEvent<>();
        final MutableObjectHolder<A> abstractionApiHolder = new MutableObjectHolder<>();
        final String entrypointName = namespace.toLowerCase() + "_" + environment.name().toLowerCase();

        base.accept(event);
        getInstance().getEntrypointContainers(entrypointName, AbstractionEntrypoint.class)
                .forEach(container -> abstractionModIds.forEach(abstractionModId -> {
                    if (container.getProvider().getMetadata().getId().equals(abstractionModId)) {
                        container.getEntrypoint().register(event);
                    }
                }));

        event.execute(abstractionApiHolder);

        this.directory = abstractionInstanceGetter.apply(abstractionApiHolder.getHeldObj());
        this.abstractionModIds = abstractionModIds;
        this.environment = environment;
        this.entrypointName = entrypointName;

        if (abstractionApiHolder.getHeldObj() == null) {
            throw new NullPointerException("Abstraction failed for " + this);
        }
    }

    @Override
    public String toString() {
        return "AbstractionHandler[Env={" + environment +"}, ENTRYPOINT_NAME={" + entrypointName +"}, " +
                "ENTRYPOINT_MODIDS" + "={" + Arrays.toString(abstractionModIds.toArray()) + "}]@" + hashCode();
    }
}
