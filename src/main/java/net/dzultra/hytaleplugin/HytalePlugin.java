package net.dzultra.hytaleplugin;

import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import net.dzultra.hytaleplugin.commands.PluginHelloCommand;
import net.dzultra.hytaleplugin.events.CraftingEvent;
import net.dzultra.hytaleplugin.events.OnPlayerReadyEvent;

import java.util.Collection;

public class HytalePlugin extends JavaPlugin {
    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public HytalePlugin(JavaPluginInit init) {
        super(init);
        LOGGER.atInfo().log("Hello from %s version %s", this.getName(), this.getManifest().getVersion().toString());
    }

    @Override
    protected void setup() {
        this.getCommandRegistry().registerCommand(new PluginHelloCommand(this.getName(), this.getManifest().getVersion().toString()));
        this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, OnPlayerReadyEvent::onPlayerReady);
        this.getEntityStoreRegistry().registerSystem(new CraftingEvent());

        Universe universe = Universe.get();
        World world = universe.getWorlds().get("default");

        Store<EntityStore> store = world.getEntityStore().getStore();

        Collection<PlayerRef> players = world.getPlayerRefs();
    }
}
