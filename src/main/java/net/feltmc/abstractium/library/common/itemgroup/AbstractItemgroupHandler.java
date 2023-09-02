package net.feltmc.abstractium.library.common.itemgroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public interface AbstractItemgroupHandler {
    ItemGroup register(Identifier identifier, ItemStack icon);

    ItemGroup register(Identifier identifier, ItemStack icon, Consumer<List<ItemStack>> itemStacksConsumer);
    void addToItemGroup(ItemGroup itemGroup, ItemStack item);
    void addToItemGroup(ItemGroup itemGroup, Consumer<List<ItemStack>> itemStacksConsumer);

}
