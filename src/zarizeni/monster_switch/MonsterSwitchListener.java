package zarizeni.monster_switch;

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

import static zarizeni.monster_switch.MonsterSwitchCommand.MONSTER_SWITCH_NAME;

public final class MonsterSwitchListener implements Listener {

    final static String MONSTER_SWITCH_ZNACKA = "SPAWNER_BLOK_DATA";

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
        var blockMetadata = block.getMetadata(MONSTER_SWITCH_ZNACKA);
        if (!blockMetadata.isEmpty()) {
            dvere.zavriDvere();
            vlnyMonster.dalsiVlna(block.getLocation());
        }
    }

    @EventHandler
    public void placeMonsterSwitch(BlockPlaceEvent e) {
        if (MONSTER_SWITCH_NAME.equals(e.getItemInHand().getItemMeta().getDisplayName())) {
            var block = e.getBlockPlaced();
            block.setMetadata(MONSTER_SWITCH_ZNACKA, new FixedMetadataValue(plugin, true));
            uloziste.pridej(MONSTER_SWITCH_ZNACKA, block.getLocation());
        }
    }

    @EventHandler
    public void znicMonsterSwitch(BlockBreakEvent e) {
        var blockMetadata = e.getBlock().getMetadata(MONSTER_SWITCH_ZNACKA);
        if (!blockMetadata.isEmpty()) {
            uloziste.odeber(MONSTER_SWITCH_ZNACKA, e.getBlock().getLocation());
            opravSpinace();
        }
    }

    private void opravSpinace() {
        var lokaceSpinacu = uloziste.nacti(MONSTER_SWITCH_ZNACKA);
        for (var lokaceSpinace : lokaceSpinacu) {
            var metadataSpinace = lokaceSpinace.getBlock().getMetadata(MONSTER_SWITCH_ZNACKA);
            if (metadataSpinace.isEmpty()) {
                lokaceSpinacu.remove(lokaceSpinace);
            }
        }
        uloziste.uloz(MONSTER_SWITCH_ZNACKA, lokaceSpinacu);
    }
}
