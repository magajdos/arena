package devices;

import monstra.MonstraStav;
import org.bukkit.Material;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import tovarny.JsonTovarnaNaVlny;

public final class MonsterSwitch implements Listener {

    private final static String MONSTER_SWITCH_NAME = "Monster switch";

    private final Plugin plugin;
    private DvereDoAreny dvereDoAreny;
    private final JsonTovarnaNaVlny jsonTovarnaNaVlny = new JsonTovarnaNaVlny();
    private int vlna = 1;

    public MonsterSwitch(Plugin plugin, DvereDoAreny dvereDoAreny) {
        this.plugin = plugin;
        this.dvereDoAreny = dvereDoAreny;
    }

    @EventHandler
    public void spawnMonsters(PlayerInteractEvent e) {
        var block = e.getClickedBlock();
        if (block == null) return;
        var blockMetadata = block.getMetadata(MONSTER_SWITCH_NAME);
        if (!blockMetadata.isEmpty()) {
            if (vlna > jsonTovarnaNaVlny.pocet()) return; //konec
            jsonTovarnaNaVlny.vlna(block.getLocation(), vlna);
            vlna++;
            dvereDoAreny.getDvere().setOpen(false);
        }
    }

    @EventHandler
    public void smrtMonstra(EntityDeathEvent event) {
        var livingEntity = event.getEntity();
        if (!(livingEntity instanceof Monster)) return ;
        MonstraStav.odstranMonstrum((Monster) livingEntity);
        if (MonstraStav.jsouMonstraMrtva()) {
            dvereDoAreny.getDvere().setOpen(true);
        }
    }

    @EventHandler
    public void placeMonsterSwitch(BlockPlaceEvent e) {
        if (MONSTER_SWITCH_NAME.equals(e.getItemInHand().getItemMeta().getDisplayName())) {
            var block = e.getBlockPlaced();
            block.setMetadata(MONSTER_SWITCH_NAME, new FixedMetadataValue(plugin, true));
        }
    }

    public ItemStack createMonsterSwitch() {
        var monsterSwitch = new ItemStack(Material.LEVER, 1);
        var itemMeta = monsterSwitch.getItemMeta();
        itemMeta.setDisplayName(MONSTER_SWITCH_NAME);
        monsterSwitch.setItemMeta(itemMeta);
        vlna = 1;
        return monsterSwitch;
    }

    public void reset() {
        vlna = 1;
    }
}
