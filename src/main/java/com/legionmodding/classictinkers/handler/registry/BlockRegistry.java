package com.legionmodding.classictinkers.handler.registry;

import com.legionmodding.classictinkers.ClassicTinkers;
import com.legionmodding.classictinkers.block.*;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ClassicTinkers.MOD_ID);

    public static final RegistryObject<Block> CASTING_BASIN = BLOCKS.register("casting_basin", BlockCastingBasin::new);
    public static final RegistryObject<Block> CASTING_TABLE = BLOCKS.register("casting_table", BlockCastingTable::new);

    public static void registerBlocks()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
