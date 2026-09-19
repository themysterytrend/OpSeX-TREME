package aurick.opsec.mod.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.PacketFlow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Connection.class)
public class ConnectionMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    public void opsex$onInit(PacketFlow packetFlow, CallbackInfo ci) {
        System.out.println("INITIALIZING");
    }
}
