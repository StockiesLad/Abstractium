package net.feltmc.abstractium.library.client.render;

import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionApi;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.client.AbstractClientCalls;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public interface AbstractRenderCalls extends AbstractionApi<AbstractClientCalls, MinecraftEnvironment> {
    void registerTranslucent(final Block block);
    void registerTranslucent(final Item item);
    void registerCutout(final Block block);
    void registerCutout(final Item item);
    void registerSign(Identifier texture);
    void registerBoats(Identifier name);

}
