package net.dzultra.hytaleplugin.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import net.dzultra.hytaleplugin.pages.TestPage;
import org.jetbrains.annotations.NotNull;

public class TestCommand extends AbstractPlayerCommand {
    public TestCommand() {
        super("test", "Opens Test UI");
    }

    @Override
    protected void execute(
            @NotNull CommandContext ctx, @NotNull Store<EntityStore> store,
            @NotNull Ref<EntityStore> ref, @NotNull PlayerRef playerRef, @NotNull World world
    ) {
        Player player = store.getComponent(ref, Player.getComponentType());

        if (player == null) return;

        TestPage page = new TestPage(playerRef);

        player.getPageManager().openCustomPage(ref, store, page);
    }
}
