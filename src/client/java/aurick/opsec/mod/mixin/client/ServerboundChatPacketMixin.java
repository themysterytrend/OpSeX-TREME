package aurick.opsec.mod.mixin.client;

import net.minecraft.network.chat.LastSeenMessages;
import net.minecraft.network.protocol.game.ServerboundChatPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.time.Instant;
import java.util.Optional;

@Mixin(ServerboundChatPacket.class)
public class ServerboundChatPacketMixin {
//    @Mutable
//    @Shadow
//    @Final
//    private String message;
//
//    @Inject(method = "<init>", at = @At("TAIL"))
//    private void opsex$onInit(String message, Instant timeStamp, long salt, Optional signature, LastSeenMessages.Update lastSeenMessages, CallbackInfo ci) {
//        this.message = message + ;
//    }
}
