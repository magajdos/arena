package zarizeni.dvere_areny;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import static zarizeni.dvere_areny.DvereAreny.JMENO;

public final class DvereArenyListener implements Listener {

    private Plugin plugin;
    private DvereAreny dvereAreny;

    public DvereArenyListener(DvereAreny dvereAreny, Plugin plugin) {
        this.dvereAreny = dvereAreny;
        this.plugin = plugin;
    }

    /* Rusi otevirani dveri, aby se oteviraly pouze v zavislosti na monstrech v arene */
    @EventHandler
    public void otevriDvere(PlayerInteractEvent event) {
        var block = event.getClickedBlock();
        if (block == null || event.getAction() == Action.LEFT_CLICK_BLOCK) return;
        var blockMetadata = block.getMetadata(JMENO);
        if (!blockMetadata.isEmpty()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void placeDvere(BlockPlaceEvent e) {
        if (JMENO.equals(e.getItemInHand().getItemMeta().getDisplayName())) {
            Block dolniCastDveri = e.getBlockPlaced();
            Block horniCastDveri = dolniCastDveri.getWorld().getBlockAt(dolniCastDveri.getLocation().add(0, 1, 0));
            dvereAreny.pridejDvere(dolniCastDveri);
            dvereAreny.pridejDvere(horniCastDveri);
            dvereAreny.otevriDvere();
        }
    }


}
