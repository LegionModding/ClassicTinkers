package com.legionmodding.classictinkers;

import com.legionmodding.classictinkers.handler.registry.BlockRegistry;
import com.legionmodding.classictinkers.handler.registry.ItemRegistry;
import com.legionmodding.classictinkers.handler.registry.SoundRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ClassicTinkers.MOD_ID)
public class ClassicTinkers
{
    public static final String MOD_ID = "classictinkers";

/*
    public static final ItemGroup CREATIVE_TAB_BLOCKS = new ItemGroup("creativetab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(BlockRegistry.CASTING_BASIN.get());
        }
    };
*/

    public ClassicTinkers()
    {
        SoundRegistry.registerSounds();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);

        FMLJavaModLoadingContext.get().getModEventBus().register(this);
    }

    private void onClientSetup(FMLClientSetupEvent event)
    {

    }

    private void onCommonSetup(FMLCommonSetupEvent event)
    {

    }
}
