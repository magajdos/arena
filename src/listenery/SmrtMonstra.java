package listenery;

import zarizeni.dvere_areny.DvereAreny;
import zarizeni.dvere_areny.DvereArenyListener;
import monstra.MonstraStav;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import tovarny.TovarnaNaMonstra;

public class SmrtMonstra implements Listener {

    private DvereAreny dvere;

    public SmrtMonstra(DvereAreny dvere) {
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
