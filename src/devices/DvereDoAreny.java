package devices;

import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.block.data.type.Door;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public final class DvereDoAreny implements Listener, CommandExecutor {

    private Plugin plugin;
    public static final String JMENO = "Dvere do areny";
    private List<Door> dvere = Lists.newArrayList();

    public DvereDoAreny(Plugin plugin) {
        this.plugin = plugin;
    }

    /* Rusi otevirani dveri, aby se otevirali pouze v zavislosti na monstrech v arene */
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
            var dolniCast = e.getBlockPlaced();
            dolniCast.setMetadata(JMENO, new FixedMetadataValue(plugin, true));
            var horniCast = dolniCast.getWorld().getBlockAt(dolniCast.getLocation().add(0,1,0));
            horniCast.setMetadata(JMENO, new FixedMetadataValue(plugin, true));
            dvere.add((Door) dolniCast.getBlockData());
            for (Door door : dvere) {
                door.setOpen(true);
            }
        }
    }

    public List<Door> getDvere() {
        return dvere;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;

        var dvere = new ItemStack(Material.OAK_DOOR, 1);
        var itemMeta = dvere.getItemMeta();
        itemMeta.setDisplayName(JMENO);
        dvere.setItemMeta(itemMeta);
        player.getInventory().addItem(dvere);
        return true;
    }
}
