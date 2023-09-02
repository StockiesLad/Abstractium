package net.feltmc.abstractium.abstraction_1182.client.rendering;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.feltmc.abstractium.library.client.render.AbstractRenderCalls;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import static com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper.registerModelLayer;

public class RenderCalls1182 implements AbstractRenderCalls {
    public static final AbstractiumAccess<AbstractRenderCalls> ACCESS = AbstractiumAccess.create(new RenderCalls1182());

    private RenderCalls1182() {}

    @Override
    public void registerTranslucent(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
    }

    @Override
    public void registerTranslucent(Item item) {
        BlockRenderLayerMap.INSTANCE.putItem(item, RenderLayer.getTranslucent());
    }

    @Override
    public void registerCutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    }

    @Override
    public void registerCutout(Item item) {
        BlockRenderLayerMap.INSTANCE.putItem(item, RenderLayer.getCutout());
    }

    @Override
    public void registerSign(Identifier texture) {
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, texture));

    }

    @Override
    public void registerBoat(Identifier name) {
        registerModelLayer(name);
    }
}
