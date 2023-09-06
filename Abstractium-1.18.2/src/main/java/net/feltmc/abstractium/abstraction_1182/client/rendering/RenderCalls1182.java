package net.feltmc.abstractium.abstraction_1182.client.rendering;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.client.AbstractClientCalls;
import net.feltmc.abstractium.library.client.render.AbstractRenderCalls;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.List;

public interface RenderCalls1182 extends AbstractRenderCalls {
    AbstractiumAccess<RenderCalls1182, AbstractionHandler<AbstractClientCalls, MinecraftEnvironment>> ACCESS = new AbstractiumAccess<>(handler -> () -> handler);

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }

    @Override
    default void registerTranslucent(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
    }

    @Override
    default void registerTranslucent(Item item) {
        BlockRenderLayerMap.INSTANCE.putItem(item, RenderLayer.getTranslucent());
    }

    @Override
    default void registerCutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    }

    @Override
    default void registerCutout(Item item) {
        BlockRenderLayerMap.INSTANCE.putItem(item, RenderLayer.getCutout());
    }

    @Override
    default void registerSign(Identifier texture) {
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, texture));

    }

    @Override
    default void registerBoats(Identifier name) {
        TerraformBoatClientHelper.registerModelLayer(name);
    }
}
