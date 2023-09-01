package net.feltmc.abstractium.api.abstraction.core.handler;

import net.feltmc.abstractium.api.abstraction.core.versioning.VersionUtil;
import net.feltmc.abstractium.api.event.core.AbstractEvent;
import net.feltmc.abstractium.api.event.def.CompactEvent;
import net.feltmc.abstractium.util.obj_holders.MutableObjectHolder;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static net.fabricmc.loader.api.FabricLoader.getInstance;

public class AbstractionHandler<Abstraction extends MethodAbstractionApi, Environment extends Enum<Environment>> {
    public final AbstractionDirectory<Abstraction> directory;
    public final List<String> abstractionModIds;
    public final Environment environment;
    public final String entrypointName;

    AbstractionHandler(
            final String namespace,
            final List<String> abstractionModIds,
            final Environment environment,
            final VersionUtil versionUtil,
            final BiFunction<Abstraction, VersionUtil, AbstractionDirectory<Abstraction>> abstractionInstanceGetter
    ) {
        final AbstractEvent<MutableObjectHolder<Abstraction>> abstractionEvent = new CompactEvent<>();
        final AbstractEvent<VersionUtil> classLoadEvent = new CompactEvent<>();
        final MutableObjectHolder<Abstraction> abstractionApiHolder = new MutableObjectHolder<>();
        final String entrypointName = namespace.toLowerCase() + "_" + environment.name().toLowerCase();

        getInstance().getEntrypointContainers(entrypointName, AbstractionEntrypoint.class)
                .forEach(container -> abstractionModIds.forEach(abstractionModId -> {
                    if (container.getProvider().getMetadata().getId().equals(abstractionModId)) {
                        final var entrypoint = container.getEntrypoint();
                        entrypoint.loadClasses(classLoadEvent);
                        entrypoint.register(abstractionEvent);
                    }
                }));
        classLoadEvent.execute(versionUtil);
        abstractionEvent.execute(abstractionApiHolder);

        this.directory = abstractionInstanceGetter.apply(abstractionApiHolder.getHeldObj(), versionUtil);
        this.abstractionModIds = abstractionModIds;
        this.environment = environment;
        this.entrypointName = entrypointName;

        if (abstractionApiHolder.getHeldObj() == null) {
            throw new NullPointerException("Abstraction failed for " + this);
        }
    }

    @Override
    public String toString() {
        return "AbstractionHandler[Env={" + environment.name() +"}, ENTRYPOINT_NAME={" + entrypointName +"}, " +
                "ENTRYPOINT_MODIDS" + "={" + Arrays.toString(abstractionModIds.toArray()) + "}]@" + hashCode();
    }
}
