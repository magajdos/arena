package listenery;

import monstra.MonstraStav;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import tovarny.TovarnaNaMonstra;

import java.util.List;

public class VyspawnovaniMonstra implements Listener {
    private List<Door> dvere;

    public VyspawnovaniMonstra(List<Door> dvere) {
        this.dvere = dvere;
    }

    @EventHandler
    public void vyspawnovaniMonstra(EntitySpawnEvent spawnEvent) {
        if (!(spawnEvent.getEntity() instanceof LivingEntity)) return;
        LivingEntity zijiciEntita = (LivingEntity) spawnEvent.getEntity();
        if (TovarnaNaMonstra.jeMonstrum(zijiciEntita)) {
            dvere.forEach(door -> door.setOpen(false));
        }
    }
}
