package devices;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import tovarny.MonsterFactory;
import tovarny.WaveFactory;

public class MonsterSwitch implements Listener {

    private final static String SPAWNER_BLOK_DATA = "SPAWNER_BLOK_DATA";
    private final static String MONSTER_SWITCH_NAME = "Monster switch";

    private Plugin plugin;
    private MonsterFactory monsterFactory = new MonsterFactory();
    private WaveFactory waveFactory = new WaveFactory();
    int vlna = 1;

    public MonsterSwitch(Plugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void spawnMonsters(PlayerInteractEvent e) {

        var block = e.getClickedBlock();
        if (block == null) return;
        var blockMetadata = block.getMetadata(SPAWNER_BLOK_DATA);
        if (!blockMetadata.isEmpty() && blockMetadata.get(0).asBoolean()) {
            if (vlna == 1) {
                waveFactory.vawe1(block.getLocation());
            }
            if (vlna == 2) {
                waveFactory.vawe2(block.getLocation());
            }
            if (vlna == 3) {
                waveFactory.vawe3(block.getLocation());
            }
            if (vlna == 4) {
                waveFactory.vawe4(block.getLocation());
                vlna = 0;
            }
            vlna++;
        }
    }

    @EventHandler
    public void placeMonsterSwitch(BlockPlaceEvent e) {
        if (MONSTER_SWITCH_NAME.equals(e.getItemInHand().getItemMeta().getDisplayName())) {
            var block = e.getBlockPlaced();
            block.setMetadata(SPAWNER_BLOK_DATA, new FixedMetadataValue(plugin, true));
        }
    }

    public static ItemStack createMonsterSwitch() {
        var monsterSwitch = new ItemStack(Material.LEVER, 1);
        var itemMeta = monsterSwitch.getItemMeta();
        itemMeta.setDisplayName(MONSTER_SWITCH_NAME);
        monsterSwitch.setItemMeta(itemMeta);
        return monsterSwitch;
    }
}
