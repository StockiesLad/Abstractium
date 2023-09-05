package net.feltmc.abstractium.api.external.abstraction.init;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;

public interface AbstractiumEarlyInit {
    void init(AbstractionHandler<?, ?> handler);
}
