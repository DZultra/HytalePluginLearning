package net.dzultra.hytaleplugin.events;

import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.EntityEventSystem;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.asset.type.item.config.CraftingRecipe;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.ecs.CraftRecipeEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CraftingEvent extends EntityEventSystem<EntityStore, CraftRecipeEvent.Pre> {
    public CraftingEvent() {
        super(CraftRecipeEvent.Pre.class);
    }

    @Override
    public void handle(
            int index,
            @NotNull ArchetypeChunk<EntityStore> archetypeChunk,
            @NotNull Store<EntityStore> store,
            @NotNull CommandBuffer<EntityStore> commandBuffer,
            @NotNull CraftRecipeEvent.Pre craftRecipeEvent
    ) {
        Ref<EntityStore> reference = archetypeChunk.getReferenceTo(index);
        Player player = store.getComponent(reference, Player.getComponentType());

        CraftingRecipe recipe = craftRecipeEvent.getCraftedRecipe();
        String itemId = recipe.getPrimaryOutput().getItemId();

        if (player == null) return;

        player.sendMessage(Message.raw("You just crafted a " + itemId + "!"));
    }

    @Override
    public @Nullable Query<EntityStore> getQuery() {
        return PlayerRef.getComponentType();
    }
}
