package net.feltmc.abstractium.abstraction.common.itemgroup;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.feltmc.abstractium.api.internal.abstraction.core.interactive.AbstractionHandler;
import net.feltmc.abstractium.api.internal.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.library.common.AbstractCommonCalls;
import net.feltmc.abstractium.library.common.itemgroup.AbstractItemgroupHandler;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

import java.util.List;
import java.util.function.Consumer;

public interface ItemgroupHandler1182 extends AbstractItemgroupHandler {

    AbstractiumAccess<ItemgroupHandler1182, AbstractionHandler<AbstractCommonCalls, MinecraftEnvironment>> ACCESS = new AbstractiumAccess<>(handler -> () -> handler);

    @Override
    default List<String> getSupportedVersions() {
        return List.of("1.18.2");
    }
    @Override
    default ItemGroup register(Identifier identifier, ItemStack icon) {
        return FabricItemGroupBuilder.create(identifier).icon(() -> icon).build();
    }

    @Override
    default ItemGroup register(Identifier identifier, ItemStack icon, Consumer<List<ItemStack>> itemStacksConsumer) {
        return FabricItemGroupBuilder.create(identifier).icon(() -> icon).appendItems(itemStacksConsumer).build();
    }

    @Override
    default void addToItemGroup(ItemGroup itemGroup, ItemStack item) {
        addToItemGroup(itemGroup, itemStacks -> itemStacks.add(item));
    }

    @Override
    default void addToItemGroup(ItemGroup itemGroup, Consumer<List<ItemStack>> itemStacksConsumer) {
        DefaultedList<ItemStack> itemStacks = DefaultedList.of();
        itemStacksConsumer.accept(itemStacks);
        itemGroup.appendStacks(itemStacks);
    }
}
