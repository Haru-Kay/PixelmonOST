package com.haru.pixelmonost.util;

import com.haru.pixelmonost.PixelmonOST;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PixelmonOST.MOD_ID);
    public static final RegistryObject<SoundEvent> MUSIC_SEA =
            registerSoundEvent("a_simple_moment_by_the_sea");
    public static final RegistryObject<SoundEvent> MUSIC_DESERT =
            registerSoundEvent("across_the_desert");
    public static final RegistryObject<SoundEvent> MUSIC_SKIES =
            registerSoundEvent("clear_skies");
    public static final RegistryObject<SoundEvent> MUSIC_DAWN =
            registerSoundEvent("dawn");
    public static final RegistryObject<SoundEvent> MUSIC_SHORES =
            registerSoundEvent("distant_shores");
    public static final RegistryObject<SoundEvent> MUSIC_DUSK =
            registerSoundEvent("dusk");
    public static final RegistryObject<SoundEvent> MUSIC_PEAK =
            registerSoundEvent("from_peak_to_peak");
    public static final RegistryObject<SoundEvent> MUSIC_JOURNEY =
            registerSoundEvent("journey_to_the_sky");
    public static final RegistryObject<SoundEvent> MUSIC_MIDNIGHT =
            registerSoundEvent("midnight");
    public static final RegistryObject<SoundEvent> MUSIC_MOONLIGHT =
            registerSoundEvent("moonlight");
    public static final RegistryObject<SoundEvent> MUSIC_NIGHTFALL =
            registerSoundEvent("nightfall");
    public static final RegistryObject<SoundEvent> MUSIC_ADVENTURE =
            registerSoundEvent("on_the_wings_of_adventure");
    public static final RegistryObject<SoundEvent> MUSIC_WALTZ =
            registerSoundEvent("pixelmon_waltz");
    public static final RegistryObject<SoundEvent> MUSIC_FOREST =
            registerSoundEvent("the_enchanted_forest");
    public static final RegistryObject<SoundEvent> MUSIC_FROZEN =
            registerSoundEvent("the_frozen_land");
    public static final RegistryObject<SoundEvent> MUSIC_PLAINS =
            registerSoundEvent("the_great_plains");
    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        PixelmonOST.LOGGER.info("Registering pixelmonost:" + name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(PixelmonOST.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
