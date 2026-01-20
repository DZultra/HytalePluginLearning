package net.dzultra.hytaleplugin;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import net.dzultra.hytaleplugin.commands.PluginHelloCommand;
import net.dzultra.hytaleplugin.commands.TestCommand;
import net.dzultra.hytaleplugin.events.CraftingEvent;
import net.dzultra.hytaleplugin.events.OnPlayerReadyEvent;

public class HytalePlugin extends JavaPlugin {
    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public HytalePlugin(JavaPluginInit init) {
        super(init);
        LOGGER.atInfo().log("Hello from %s version %s", this.getName(), this.getManifest().getVersion().toString());
    }

    @Override
    protected void setup() {
        this.getCommandRegistry().registerCommand(new PluginHelloCommand(this.getName(), this.getManifest().getVersion().toString()));
        this.getCommandRegistry().registerCommand(new TestCommand());
        this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, OnPlayerReadyEvent::onPlayerReady);
        this.getEntityStoreRegistry().registerSystem(new CraftingEvent());

//        Universe universe = Universe.get();
//
//        PlayerRef player = universe.getPlayerByUsername("DZultra", NameMatching.EXACT);
//        World world = universe.getWorlds().get("default");
//
//        Store<EntityStore> store = world.getEntityStore().getStore();
//
//        // Pattern: Get the ref, Get the store, Get the Component, Read the Data
//
//        if (player != null) {
//            TransformComponent transformComponent = store.getComponent(player.getReference(), TransformComponent.getComponentType());
//            Vector3d position = transformComponent.getPosition();
//
//            store.addComponent(player.getReference(), Invulnerable.getComponentType());
//
//            transformComponent.setPosition(new Vector3d(1, 1, 1));
//            transformComponent.setPosition(position); // Just examples so we don't have any issues hehe
//
//            store.removeComponent(player.getReference(), Invulnerable.getComponentType());
//
//            Teleport teleport = new Teleport(new Vector3d(0, 0, 0), player.getHeadRotation());
//            store.addComponent(player.getReference(), Teleport.getComponentType(), teleport);
//
//            // No own components for health etc. uses a statscomponent
//            EntityStatMap stats = store.getComponent(player.getReference(), EntityStatMap.getComponentType());
//            int healthIndex = DefaultEntityStatTypes.getHealth();
//            EntityStatValue health = stats.get(healthIndex);
//            float current = health.getMax();
//            float max = health.get();
//
//            stats.addStatValue(healthIndex, 0);
//            stats.addStatValue(healthIndex, -0);
//        }
//
//        Collection<PlayerRef> players = world.getPlayerRefs();
//
//        for (PlayerRef playerRef : players) {
//            if (!playerRef.getUsername().equals("DZultra")) return;
//
//        }
    }
}
