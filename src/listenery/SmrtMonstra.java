package listenery;

import devices.DvereDoAreny;
import monstra.MonstraStav;
import org.bukkit.Material;
import org.bukkit.block.data.type.Door;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import tovarny.TovarnaNaMonstra;

import java.util.List;

public class SmrtMonstra implements Listener {

    private DvereDoAreny dvere;

    public SmrtMonstra(DvereDoAreny dvere) {
        this.dvere = dvere;
    }

    @EventHandler
    public void deathOfMonsters(EntityDeathEvent deathEvent) {
        if (TovarnaNaMonstra.jeMonstrum(deathEvent.getEntity()))
            if (MonstraStav.jsouMonstraMrtva()) {
                dvere.otevriDvere();
            }
    }
}
