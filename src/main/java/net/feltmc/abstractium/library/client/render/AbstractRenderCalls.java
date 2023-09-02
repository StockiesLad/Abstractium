package net.feltmc.abstractium.library.client.render;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public interface AbstractRenderCalls {
    void registerTranslucent(final Block block);
    void registerTranslucent(final Item item);
    void registerCutout(final Block block);
    void registerCutout(final Item item);
    <B extends Block> void registerSign(B sign, String type);
}
