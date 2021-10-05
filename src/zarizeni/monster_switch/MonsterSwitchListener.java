package zarizeni.monster_switch;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import tovarny.TovarnaNaVlny;
import zarizeni.dvere_areny.DvereAreny;

import static zarizeni.monster_switch.MonsterSwitchCommand.MONSTER_SWITCH_NAME;

public final class MonsterSwitchListener implements Listener {

    private final static String SPAWNER_BLOK_DATA = "SPAWNER_BLOK_DATA";

    private final Plugin plugin;
    private final DvereAreny dvere;
    private final TovarnaNaVlny tovarnaNaVlny;

    public MonsterSwitchListener(DvereAreny dvere, TovarnaNaVlny tovarnaNaVlny, Plugin plugin) {
        this.plugin = plugin;
        this.dvere = dvere;
        this.tovarnaNaVlny = tovarnaNaVlny;
    }

    @EventHandler
    public void spawnMonsters(PlayerInteractEvent e) {
        var block = e.getClickedBlock();
        if (block == null) return;
        var blockMetadata = block.getMetadata(SPAWNER_BLOK_DATA);
        if (!blockMetadata.isEmpty()) {
            dvere.zavriDvere();
            tovarnaNaVlny.dalsiVlna(block.getLocation());
        }
    }

    @EventHandler
    public void placeMonsterSwitch(BlockPlaceEvent e) {
        if (MONSTER_SWITCH_NAME.equals(e.getItemInHand().getItemMeta().getDisplayName())) {
            var block = e.getBlockPlaced();
            block.setMetadata(SPAWNER_BLOK_DATA, new FixedMetadataValue(plugin, true));
        }
    }
}
