package aurick.opsec.mod.mixin.client;

import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.chat.LastSeenMessagesTracker;
import net.minecraft.network.chat.MessageSignature;
import net.minecraft.network.chat.SignedMessageBody;
import net.minecraft.network.protocol.game.ServerboundChatPacket;
import net.minecraft.util.Crypt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.time.Instant;
import java.util.Optional;

@Mixin(ClientPacketListener.class)
public abstract class ClientPacketListenerMixin {
    @Shadow
    public abstract void sendChat(String string);

    @Unique
    private final String suffix = " I am using Opsec, an AI-Generated slop clone of ExploitPreventer";

    @Inject(method = "sendChat", at = @At("HEAD"), cancellable = true)
    private void opsex$onSendChat(String content, CallbackInfo ci) {
        if(!content.endsWith(suffix)) {
            sendChat(content + suffix);

            ci.cancel();
        }
    }

}
