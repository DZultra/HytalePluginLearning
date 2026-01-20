package net.dzultra.hytaleplugin.pages;

import com.hypixel.hytale.protocol.packets.interface_.CustomPageLifetime;
import com.hypixel.hytale.server.core.entity.entities.player.pages.BasicCustomUIPage;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import org.jetbrains.annotations.NotNull;

public class TestPage extends BasicCustomUIPage {
    public TestPage(@NotNull PlayerRef playerRef) {
        super(playerRef, CustomPageLifetime.CanDismiss);
    }

    @Override
    public void build(UICommandBuilder cmd) {
        cmd.append("Pages/test.ui");
    }
}
