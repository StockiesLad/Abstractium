package net.feltmc.abstractium.library.client.render;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public interface AbstractRenderCalls {
    void registerTranslucent(final Block block);
    void registerTranslucent(final Item item);
    void registerCutout(final Block block);
    void registerCutout(final Item item);
    void registerSign(Identifier texture);
    void registerBoat(Identifier name);

}
