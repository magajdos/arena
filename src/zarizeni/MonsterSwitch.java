package zarizeni;

import org.bukkit.Material;
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
import tovarny.JsonTovarnaNaVlny;
import zarizeni.dvere_areny.DvereAreny;

public final class MonsterSwitch implements Listener, CommandExecutor {

    private final static String SPAWNER_BLOK_DATA = "SPAWNER_BLOK_DATA";
    private final static String MONSTER_SWITCH_NAME = "Monster switch";

    private final Plugin plugin;
    private final DvereAreny dvere;
    private final JsonTovarnaNaVlny jsonTovarnaNaVlny = new JsonTovarnaNaVlny();
    private int vlna = 1;

    public MonsterSwitch(DvereAreny dvere, Plugin plugin) {
        this.plugin = plugin;
        this.dvere = dvere;
    }

    @EventHandler
    public void spawnMonsters(PlayerInteractEvent e) {
        var block = e.getClickedBlock();
        if (block == null) return;
        var blockMetadata = block.getMetadata(SPAWNER_BLOK_DATA);
        if (!blockMetadata.isEmpty()) {
            if (vlna > jsonTovarnaNaVlny.pocet()) return; //konec
            dvere.zavriDvere();
            jsonTovarnaNaVlny.vlna(block.getLocation(), vlna);
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

    public void reset() {
        vlna = 1;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;

        var monsterSwitch = new ItemStack(Material.LEVER, 1);
        var itemMeta = monsterSwitch.getItemMeta();
        itemMeta.setDisplayName(MONSTER_SWITCH_NAME);
        monsterSwitch.setItemMeta(itemMeta);
        player.getInventory().addItem(monsterSwitch);
        vlna = 1;
        return true;
    }
}
