package storm.server.builder.animator;

import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.BiConsumer;

public class StormMenuAnimations {

    private final BiConsumer<InventoryClickEvent, StormButton> animateButton;
    public StormMenuAnimations(BiConsumer<InventoryClickEvent, StormButton> animateButton) {
        this.animateButton = animateButton;
    }



}
