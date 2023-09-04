package net.feltmc.abstractium.abstraction.client;

import net.feltmc.abstractium.abstraction.common.CommonCalls1182;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionEntrypoint;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;

import java.util.List;

public class ClientEntrypoint1182 implements AbstractionEntrypoint {
    @Override
    public <Abstraction extends AbstractionApi<Abstraction, Environment>, Environment extends Enum<Environment>> void register(List<Abstraction> abstractions, AbstractionHandler<Abstraction, Environment> parent) {
        abstractions.add(((ClientCalls1182) parent::generify).generify());
    }
}
