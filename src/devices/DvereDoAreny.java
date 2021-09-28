package devices;

import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Door;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public final class DvereDoAreny implements Listener, CommandExecutor {

    private Plugin plugin;
    public static final String JMENO = "Dvere do areny";
    private List<Block> dvere = Lists.newArrayList();

    public DvereDoAreny(Plugin plugin) {
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
            Block  horniCastDveri= dolniCastDveri.getWorld().getBlockAt(dolniCastDveri.getLocation().add(0,1,0));
            dvere.add(dolniCastDveri);
            dvere.add(horniCastDveri);
            dvere.forEach(blok -> blok.setMetadata(JMENO, new FixedMetadataValue(plugin, true)));
            otevriDvere();
        }
    }

    private void zmenStavDveri(boolean stav) {
        for (Block blokDveri : dvere) {
            Door dvere = (Door)blokDveri.getBlockData();
            dvere.setOpen(true);
            blokDveri.setBlockData(dvere);
        }
    }
    public void otevriDvere() {
        zmenStavDveri(true);
    }

    public void zavriDvere() {
        zmenStavDveri(false);
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
