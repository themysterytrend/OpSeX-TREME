package aurick.opsec.mod.mixin.client;

import aurick.opsec.mod.OpsecClient;
import aurick.opsec.mod.protection.DisclaimerScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.multiplayer.ServerData;
//? if>= 26.1 {
/*import net.minecraft.client.multiplayer.TransferState;
*///?}
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConnectScreen.class)
public class ConnectScreenMixin {
    @Inject(method = "connect", at = @At("HEAD"), cancellable = true)
    //? if < 26.1 {
    private void opsex$onConnect(Minecraft minecraft, ServerAddress hostAndPort, ServerData server, CallbackInfo ci) {
    //?} else {

    /*private void opsex$onConnect(Minecraft minecraft, ServerAddress hostAndPort, ServerData server, TransferState transferState, CallbackInfo ci) {
    *///?}
        if(OpsecClient.disclaimed)
            return;

        OpsecClient.disclaimed = true;


        //? if< 26.1 {

        Minecraft.getInstance().setScreen(new DisclaimerScreen(
                server.ip + ":25565"
        ));

        //?} else {

        /*Minecraft.getInstance().setScreenAndShow(new DisclaimerScreen(
                server.ip + ":25565"
        ));

        *///?}

        ci.cancel();
    }
}
