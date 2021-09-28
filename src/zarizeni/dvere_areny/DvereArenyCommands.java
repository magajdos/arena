package zarizeni.dvere_areny;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DvereArenyCommands implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        var player = (Player) commandSender;

        var dvere = new ItemStack(Material.OAK_DOOR, 1);
        var itemMeta = dvere.getItemMeta();
        if (itemMeta == null) return false;
        itemMeta.setDisplayName(DvereAreny.JMENO);
        dvere.setItemMeta(itemMeta);
        player.getInventory().addItem(dvere);
        return true;
    }
}
