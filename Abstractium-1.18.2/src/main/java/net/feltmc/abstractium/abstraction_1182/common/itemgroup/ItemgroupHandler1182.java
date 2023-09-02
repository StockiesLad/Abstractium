package net.feltmc.abstractium.abstraction_1182.common.itemgroup;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.feltmc.abstractium.library.common.itemgroup.AbstractItemgroupHandler;
import net.feltmc.abstractium.util.access.AbstractiumAccess;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

import java.util.List;
import java.util.function.Consumer;

public class ItemgroupHandler1182 implements AbstractItemgroupHandler {
    public static final AbstractiumAccess<AbstractItemgroupHandler> ACCESS = AbstractiumAccess.create(new ItemgroupHandler1182());

    private ItemgroupHandler1182() {}

    @Override
    public ItemGroup register(Identifier identifier, ItemStack icon) {
        return FabricItemGroupBuilder.create(identifier).icon(() -> icon).build();
    }

    @Override
    public ItemGroup register(Identifier identifier, ItemStack icon, Consumer<List<ItemStack>> itemStacksConsumer) {
        return FabricItemGroupBuilder.create(identifier).icon(() -> icon).appendItems(itemStacksConsumer).build();
    }

    @Override
    public void addToItemGroup(ItemGroup itemGroup, ItemStack item) {
        addToItemGroup(itemGroup, itemStacks -> itemStacks.add(item));
    }

    @Override
    public void addToItemGroup(ItemGroup itemGroup, Consumer<List<ItemStack>> itemStacksConsumer) {
        DefaultedList<ItemStack> itemStacks = DefaultedList.of();
        itemStacksConsumer.accept(itemStacks);
        itemGroup.appendStacks(itemStacks);
    }
}
