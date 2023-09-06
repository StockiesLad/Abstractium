package net.feltmc.abstractium.abstraction_1182.client;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionEntrypoint;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;

import java.util.List;

public class ClientEntrypoint1182 implements AbstractionEntrypoint {
    @Override
    public <Abstraction extends AbstractionApi<Abstraction, Environment>, Environment extends Enum<Environment>> void register(List<Abstraction> abstractions, AbstractionHandler<Abstraction, Environment> handler) {
        abstractions.add(((ClientCalls1182) handler::generify).generify());
    }
}
