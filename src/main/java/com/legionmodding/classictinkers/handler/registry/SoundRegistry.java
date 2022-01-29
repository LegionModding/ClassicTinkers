package com.legionmodding.classictinkers.handler.registry;

import com.legionmodding.classictinkers.ClassicTinkers;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class SoundRegistry
{
    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ClassicTinkers.MOD_ID);

    private SoundRegistry()
    {

    }

    public static final RegistryObject<SoundEvent> SAW = SOUNDS.register("little_saw", () -> new SoundEvent(new ResourceLocation(ClassicTinkers.MOD_ID, "")));
    public static final RegistryObject<SoundEvent> FRYPAN_BOING = SOUNDS.register("frypan_hit", () -> new SoundEvent(new ResourceLocation(ClassicTinkers.MOD_ID, "")));
    public static final RegistryObject<SoundEvent> TOY_SQUEAK = SOUNDS.register("toy_squeak", () -> new SoundEvent(new ResourceLocation(ClassicTinkers.MOD_ID, "")));
    public static final RegistryObject<SoundEvent> SLIME_SLING = SOUNDS.register("slimesling", () -> new SoundEvent(new ResourceLocation(ClassicTinkers.MOD_ID, "")));
    public static final RegistryObject<SoundEvent> SHOCKING_CHARGED = SOUNDS.register("charged", () -> new SoundEvent(new ResourceLocation(ClassicTinkers.MOD_ID, "")));
    public static final RegistryObject<SoundEvent> SHOCKING_DISCHARGE = SOUNDS.register("discharge", () -> new SoundEvent(new ResourceLocation(ClassicTinkers.MOD_ID, "")));
    public static final RegistryObject<SoundEvent> STONE_HIT = SOUNDS.register("stone_hit", () -> new SoundEvent(new ResourceLocation(ClassicTinkers.MOD_ID, "")));
    public static final RegistryObject<SoundEvent> WOOD_HIT = SOUNDS.register("wood_hit", () -> new SoundEvent(new ResourceLocation(ClassicTinkers.MOD_ID, "")));
    public static final RegistryObject<SoundEvent> CROSSBOW_RELOAD = SOUNDS.register("crossbow_reload", () -> new SoundEvent(new ResourceLocation(ClassicTinkers.MOD_ID, "")));

    //Todo below

    /*public static void playSoundForAll(Entity entity, RegistryObject<SoundEvent> sound, float volume, float pitch)
    {
        entity.level.playSound(null, entity.getPosition(), sound, entity.getSoundSource(), volume, pitch);
    }

    public static void playSoundForPlayer(Entity entity, RegistryObject<SoundEvent> sound, float volume, float pitch)
    {
        if(entity instanceof EntityPlayerMP)
        {
            TinkerNetwork.sendPacket(entity, new SPacketSoundEffect(sound, entity.getSoundCategory(), entity.posX, entity.posY, entity.posZ, volume, pitch));
        }
    }*/

    public static void registerSounds()
    {
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
