package com.haru.pixelmonost.mixin;

import com.haru.pixelmonost.util.SongSelection;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;
import java.util.Random;

@Mixin(MusicTicker.class)
public class MixinMusicTicker {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Shadow
    @Final
    private Random random;

    @Shadow
    private ISound currentMusic;

    @Shadow
    private int nextSongDelay;

    @Redirect(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/audio/MusicTicker;startPlaying(Lnet/minecraft/client/audio/BackgroundMusicSelector;)V"
            )
    )
    public void musicTick(MusicTicker instance, BackgroundMusicSelector selector){
        if (this.minecraft.player != null) {
            ClientWorld world = this.minecraft.level;
            boolean overworld = world.dimension() == World.OVERWORLD;
            if (overworld) {
                this.playPixelmonSound();
            } else {
                this.startPlaying(selector);
            }
        } else {
            this.startPlaying(selector);
        }
    }

    public void playPixelmonSound() {
        PlayerEntity player = this.minecraft.player;
        World world = player.level;
        Biome.Category biome = world.getBiome(player.blockPosition()).getBiomeCategory();

        Long time = world.getDayTime() % 24000L;
        List music;
        if (time > 23500) {
            music = SongSelection.getDayList(biome);
        } else if (time > 22500) {
            music = SongSelection.getDawnList();
        } else if (time > 20000) {
            music = SongSelection.getNightList();
        } else if (time > 17000) {
            music = SongSelection.getMidnightList();
        } else if (time > 13500) {
            music = SongSelection.getNightList();
        } else if (time > 12500) {
            music = SongSelection.getDuskList();
        } else {
            music = SongSelection.getDayList(biome);
        }

        int idx = random.nextInt(music.size());
        SoundEvent soundEvent = (SoundEvent)music.get(idx);

        this.currentMusic = SimpleSound.forMusic(soundEvent);
        if (this.currentMusic.getSound() != SoundHandler.EMPTY_SOUND) {
            this.minecraft.getSoundManager().play(this.currentMusic);
        }

        this.nextSongDelay = Integer.MAX_VALUE;
    }

    @Shadow
    public void startPlaying(BackgroundMusicSelector selector) {}
}
