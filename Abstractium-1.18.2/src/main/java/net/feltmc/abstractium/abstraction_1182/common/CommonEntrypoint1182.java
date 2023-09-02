package net.feltmc.abstractium.abstraction_1182.common;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionEntrypoint;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;

import java.util.List;

public class CommonEntrypoint1182 implements AbstractionEntrypoint {

    @Override
    public <Abstraction extends AbstractionApi<Abstraction, Environment>, Environment extends Enum<Environment>> void register(List<Abstraction> abstractions, AbstractionHandler<Abstraction, Environment> parent) {
        abstractions.add(new CommonCalls1182(parent.generify()).generify());

    }
}
