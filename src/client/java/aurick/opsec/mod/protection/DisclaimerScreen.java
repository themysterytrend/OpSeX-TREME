package aurick.opsec.mod.protection;

import com.google.gson.JsonPrimitive;
//import com.nikoverflow.exploitpreventer.ExploitPreventerMod;
//import com.nikoverflow.exploitpreventer.Translations;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.Layout;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.multiplayer.WarningScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URI;

public class DisclaimerScreen extends WarningScreen {

    private final String fullIP;

    private final String ip;

    private final int port;

    public DisclaimerScreen(String ip) {
        super(Component.literal("This is a very bad mod"),
                Component.literal("This is a very bad mod which is very detectable. Use ExploitPreventer instead. I love you so much"),
                Component.literal("I DON'T CARE"));

        this.fullIP = ip;
        this.ip = ip.split(":")[0];
        this.port = Integer.parseInt(ip.split(":")[1]);
    }



    //? if<1.20.6 {
    @Override
    protected void initButtons(int i) {
        LinearLayout linearLayout = new LinearLayout(8, 0, LinearLayout.Orientation.HORIZONTAL);

        linearLayout.addChild(Button.builder(CommonComponents.GUI_PROCEED, (button) -> {
            ConnectScreen.startConnecting(
                    new JoinMultiplayerScreen(new TitleScreen()),
                    Minecraft.getInstance(),
                    new ServerAddress(this.ip, this.port),
                    //? if> 1.21 {
                    new ServerData("Server", this.fullIP, false),
                    //?} else {
                    /*new ServerData("Server", this.fullIP, ServerData.Type.OTHER),

                    *///?}
                    false
            );

        }).build());
        linearLayout.addChild(Button.builder(CommonComponents.GUI_BACK, (button) -> this.onClose()).build());
    }

    //?} else {
    /*@Override
    protected @NotNull Layout addFooterButtons() {
        LinearLayout linearLayout = LinearLayout.horizontal().spacing(8);
        linearLayout.addChild(Button.builder(CommonComponents.GUI_PROCEED, (button) -> {
            ConnectScreen.startConnecting(
                    new JoinMultiplayerScreen(new TitleScreen()),
                    Minecraft.getInstance(),
                    new ServerAddress(this.ip, this.port),
                    new ServerData("Server", this.fullIP, ServerData.Type.OTHER),
                    false,
                    null
            );

        }).build());
        linearLayout.addChild(Button.builder(CommonComponents.GUI_BACK, (button) -> this.onClose()).build());
        return linearLayout;
    }
    *///?}
}