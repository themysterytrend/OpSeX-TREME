package aurick.opsec.mod.mixin.client;

import aurick.opsec.mod.Opsec;
import aurick.opsec.mod.config.OpsecConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.Connection;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Core Minecraft client hooks for telemetry blocking.
 */
@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

    @Inject(method = "allowsTelemetry", at = @At("HEAD"), cancellable = true)
    private void opsec$disableTelemetry(CallbackInfoReturnable<Boolean> info) {
        if (OpsecConfig.getInstance().shouldDisableTelemetry()) {
            Opsec.LOGGER.debug("[OpSec] Blocking telemetry");
            info.setReturnValue(false);

        }


    }

}
