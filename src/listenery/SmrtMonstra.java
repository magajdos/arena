package listenery;

import monstra.MonstraStav;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import zarizeni.dvere_areny.DvereAreny;

public class SmrtMonstra implements Listener {

    private final DvereAreny dvere;
    private final MonstraStav monstraStav;

    public SmrtMonstra(DvereAreny dvere, MonstraStav monstraStav) {
        this.dvere = dvere;
        this.monstraStav = monstraStav;
    }

    @EventHandler
    public void deathOfMonsters(EntityDeathEvent deathEvent) {
        if (monstraStav.jeMonstrum(deathEvent.getEntity()))
            if (monstraStav.jsouMonstraMrtva()) {
                dvere.otevriDvere();
            }
    }
}
