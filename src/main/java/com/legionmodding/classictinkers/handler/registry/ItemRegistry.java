package com.legionmodding.classictinkers.handler.registry;

import com.legionmodding.classictinkers.ClassicTinkers;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry
{
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ClassicTinkers.MOD_ID);

    private static final RegistryObject<Item> CASTING_BASIN = ITEMS.register("casting_basin", () -> new BlockItem(BlockRegistry.CASTING_BASIN.get(), new Item.Properties().tab(ClassicTinkers.CREATIVE_TAB_BLOCKS)));
    private static final RegistryObject<Item> CASTING_TABLE = ITEMS.register("casting_table", () -> new BlockItem(BlockRegistry.CASTING_TABLE.get(), new Item.Properties().tab(ClassicTinkers.CREATIVE_TAB_BLOCKS)));

    public static void registerItems()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
