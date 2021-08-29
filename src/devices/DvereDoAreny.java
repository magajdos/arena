package devices;

import monstra.MonstraStav;
import org.bukkit.Material;
import org.bukkit.block.data.type.Door;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

public final class DvereDoAreny implements Listener {

    private Plugin plugin;
    public static final String JMENO = "Dvere do areny";
    private  Door dvere;

    public DvereDoAreny(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void otevriDvere(PlayerInteractEvent event) {
        var block = event.getClickedBlock();
        if (block == null) return;
        var blockMetadata = block.getMetadata(JMENO);
        if (!blockMetadata.isEmpty()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void placeDvere(BlockPlaceEvent e) {
        if (JMENO.equals(e.getItemInHand().getItemMeta().getDisplayName())) {
            var block = e.getBlockPlaced();
            block.setMetadata(JMENO, new FixedMetadataValue(plugin, true));
            dvere = (Door) block.getBlockData();
        }
    }

    public Door getDvere() {
        return dvere;
    }

    public ItemStack vytvorDvere() {
        var dvere = new ItemStack(Material.IRON_DOOR, 1);
        var itemMeta = dvere.getItemMeta();
        itemMeta.setDisplayName(JMENO);
        dvere.setItemMeta(itemMeta);
        return dvere;
    }
}
