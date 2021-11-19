package listenery;

import monstra.MonstraStav;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class OdmenaZaZabitiMonstra implements Listener {

    private final MonstraStav monstraStav;

    public OdmenaZaZabitiMonstra(MonstraStav monstraStav) {
        this.monstraStav = monstraStav;
    }

    @EventHandler
    public void deathOfMonsters(EntityDeathEvent deathEvent) {
        if (monstraStav.jeMonstrum(deathEvent.getEntity())) {
            deathEvent.getDrops().clear();
            deathEvent.getDrops().add(new ItemStack(Material.GOLD_NUGGET));
        }
    }
}
