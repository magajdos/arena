package zarizeni.monster_switch;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import monstra.VlnyMonster;
import uloziste_dat.Uloziste;
import zarizeni.dvere_areny.DvereAreny;

import java.util.List;

import static zarizeni.monster_switch.MonsterSwitchCommand.MONSTER_SWITCH_NAME;

public final class MonsterSwitchListener implements Listener {

    final static String SPAWNER_BLOK_DATA = "SPAWNER_BLOK_DATA";

    private final Plugin plugin;
    private final DvereAreny dvere;
    private final VlnyMonster vlnyMonster;
    private final Uloziste uloziste;

    public MonsterSwitchListener(DvereAreny dvere, VlnyMonster vlnyMonster, Uloziste uloziste, Plugin plugin) {
        this.plugin = plugin;
        this.dvere = dvere;
        this.vlnyMonster = vlnyMonster;
        this.uloziste = uloziste;
    }

    @EventHandler
    public void spawnMonsters(PlayerInteractEvent e) {
        var block = e.getClickedBlock();
        if (block == null) return;
        var blockMetadata = block.getMetadata(SPAWNER_BLOK_DATA);
        if (!blockMetadata.isEmpty()) {
            dvere.zavriDvere();
            vlnyMonster.dalsiVlna(block.getLocation());
        }
    }

    @EventHandler
    public void placeMonsterSwitch(BlockPlaceEvent e) {
        if (MONSTER_SWITCH_NAME.equals(e.getItemInHand().getItemMeta().getDisplayName())) {
            var block = e.getBlockPlaced();
            block.setMetadata(SPAWNER_BLOK_DATA, new FixedMetadataValue(plugin, true));
            List<Location> locations = uloziste.nacti(SPAWNER_BLOK_DATA);
            locations.add(block.getLocation());
            uloziste.uloz(SPAWNER_BLOK_DATA, locations);
        }
    }

    @EventHandler
    public void znicMonsterSwitch(BlockBreakEvent e) {
        var blockMetadata = e.getBlock().getMetadata(SPAWNER_BLOK_DATA);
        if (!blockMetadata.isEmpty()) {
            List<Location> locations = uloziste.nacti(SPAWNER_BLOK_DATA);
            locations.remove(e.getBlock().getLocation());
            //hack ale otestovat !!
//            var blLoc = e.getBlock().getLocation();
  //          locations.remove(new Location(blLoc.getWorld(), blLoc.getBlockX(), .... etc);
            //
            uloziste.uloz(SPAWNER_BLOK_DATA, locations);
        }
    }
}
