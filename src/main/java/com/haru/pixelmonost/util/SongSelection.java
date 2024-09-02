package com.haru.pixelmonost.util;

import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;

import java.util.Arrays;
import java.util.List;

public class SongSelection {
    public static List<SoundEvent> getDayList(Biome.Category category){
        if (category == Biome.Category.BEACH || category == Biome.Category.OCEAN)
            return Arrays.asList(
                    ModSoundEvents.MUSIC_SHORES.get(), ModSoundEvents.MUSIC_SEA.get()
            );
        if (category == Biome.Category.DESERT)
            return Arrays.asList(
                    ModSoundEvents.MUSIC_DESERT.get(), ModSoundEvents.MUSIC_ADVENTURE.get()
            );
        if (category == Biome.Category.EXTREME_HILLS || category == Biome.Category.MESA)
            return Arrays.asList(
                   ModSoundEvents.MUSIC_SKIES.get(), ModSoundEvents.MUSIC_PEAK.get(),
                    ModSoundEvents.MUSIC_ADVENTURE.get(), ModSoundEvents.MUSIC_JOURNEY.get()
            );
        if (category == Biome.Category.FOREST || category == Biome.Category.JUNGLE ||
                category == Biome.Category.MUSHROOM || category == Biome.Category.SWAMP)
            return Arrays.asList(
                    ModSoundEvents.MUSIC_FOREST.get(), ModSoundEvents.MUSIC_WALTZ.get()
            );
        if (category == Biome.Category.ICY || category == Biome.Category.TAIGA)
            return Arrays.asList(
                    ModSoundEvents.MUSIC_FROZEN.get()
            );
        if (category == Biome.Category.PLAINS || category == Biome.Category.RIVER || category == Biome.Category.SAVANNA)
            return Arrays.asList(
                    ModSoundEvents.MUSIC_ADVENTURE.get(), ModSoundEvents.MUSIC_PLAINS.get()
            );

        return Arrays.asList(ModSoundEvents.MUSIC_ADVENTURE.get());
    }

    public static List<SoundEvent> getDawnList() {
        return Arrays.asList(ModSoundEvents.MUSIC_DAWN.get());
    }

    public static List<SoundEvent> getNightList() {
        return Arrays.asList(ModSoundEvents.MUSIC_NIGHTFALL.get(), ModSoundEvents.MUSIC_MOONLIGHT.get());
    }

    public static List<SoundEvent> getMidnightList() {
        return Arrays.asList(ModSoundEvents.MUSIC_MIDNIGHT.get());
    }

    public static List<SoundEvent> getDuskList() {
        return Arrays.asList(ModSoundEvents.MUSIC_DUSK.get());
    }
}
