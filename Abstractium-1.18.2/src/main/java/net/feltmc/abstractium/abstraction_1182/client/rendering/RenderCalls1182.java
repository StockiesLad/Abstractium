package net.feltmc.abstractium.abstraction_1182.client.rendering;

import net.feltmc.abstractium.library.client.render.AbstractRenderCalls;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class RenderCalls1182 implements AbstractRenderCalls {
    public static final AbstractiumAccess<AbstractRenderCalls> ACCESS = AbstractiumAccess.create(new RenderCalls1182());

    @Override
    public void registerTranslucent(Block block) {

    }

    @Override
    public void registerTranslucent(Item item) {

    }

    @Override
    public void registerCutout(Block block) {

    }

    @Override
    public void registerCutout(Item item) {

    }

    @Override
    public <B extends Block> void registerSign(B sign, String type) {

    }
}
