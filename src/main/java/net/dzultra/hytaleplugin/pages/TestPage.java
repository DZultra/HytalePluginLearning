package net.dzultra.hytaleplugin.pages;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.protocol.packets.interface_.CustomPageLifetime;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.NameMatching;
import com.hypixel.hytale.server.core.entity.entities.player.pages.InteractiveCustomUIPage;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.ui.builder.UIEventBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import net.dzultra.hytaleplugin.events.GreetEventData;
import org.jetbrains.annotations.NotNull;

public class TestPage extends InteractiveCustomUIPage<GreetEventData> {
    public TestPage(@NotNull PlayerRef playerRef) {
        super(playerRef, CustomPageLifetime.CanDismissOrCloseThroughInteraction, GreetEventData.CODEC);
    }

    @Override
    public void build(@NotNull Ref<EntityStore> ref, @NotNull UICommandBuilder cmd,
                      @NotNull UIEventBuilder evt, @NotNull Store<EntityStore> store) {
        cmd.append("Pages/test.ui");

//        evt.addEventBinding(
//                CustomUIEventBindingType.Activating,
//                "#GreetButton",
//                new EventData().append("@PlayerName", "#NameInput.Value")
//        );
    }

    @Override
    public void handleDataEvent(@NotNull Ref<EntityStore> ref, @NotNull Store<EntityStore> store,
                                @NotNull GreetEventData data) {
        PlayerRef player = Universe.get().getPlayerByUsername(data.playerName, NameMatching.EXACT);
        if (player == null) return;
        player.sendMessage(Message.raw("Hello"));
    }
}
