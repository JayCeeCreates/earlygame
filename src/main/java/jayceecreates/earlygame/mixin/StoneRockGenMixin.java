package jayceecreates.earlygame.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import jayceecreates.earlygame.utils.ModConfiguredFeatures;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

@Mixin(DefaultBiomeFeatures.class)
public class StoneRockGenMixin {
    
    @Inject(
        method = "addPlainsFeatures(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V",
        at = @At("TAIL")
    )
    private static void addPlainsFeatures(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ROCK_BLOCK);
    }

    @Inject(
        method = "addForestGrass(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V",
        at = @At("TAIL")
    )
    private static void addForestGrass(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ROCK_BLOCK);
    }

    @Inject(
        method = "addJungleGrass(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V",
        at = @At("TAIL")
    )
    private static void addJungleGrass(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ROCK_BLOCK);
    }

    @Inject(
        method = "addShatteredSavannaGrass(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V",
        at = @At("TAIL")
    )
    private static void addShatteredSavannaGrass(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ROCK_BLOCK);
    }

    @Inject(
        method = "addSavannaGrass(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V",
        at = @At("TAIL")
    )
    private static void addSavannaGrass(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ROCK_BLOCK);
    }

    @Inject(
        method = "addBadlandsGrass(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V",
        at = @At("TAIL")
    )
    private static void addBadlandsGrass(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ROCK_BLOCK);
    }

    @Inject(
        method = "addSwampFeatures(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V",
        at = @At("TAIL")
    )
    private static void addSwampFeatures(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ROCK_BLOCK);
    }

    @Inject(
        method = "addDesertDeadBushes(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V",
        at = @At("TAIL")
    )
    private static void addDesertDeadBushes(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ROCK_BLOCK);
    }

    @Inject(
        method = "addGiantTaigaGrass(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V",
        at = @At("TAIL")
    )
    private static void addGiantTaigaGrass(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ROCK_BLOCK);
    }

    @Inject(
        method = "addDefaultGrass(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V",
        at = @At("TAIL")
    )
    private static void addDefaultGrass(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ROCK_BLOCK);
    }

    @Inject(
        method = "addTaigaGrass(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V",
        at = @At("TAIL")
    )
    private static void addTaigaGrass(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModConfiguredFeatures.ROCK_BLOCK);
    }
    
}
