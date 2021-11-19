package commands;

import monstra.MonstraStav;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ZabijVsechnaMonstra implements CommandExecutor {

    private final MonstraStav monstraStav;

    public ZabijVsechnaMonstra(MonstraStav monstraStav) {
        this.monstraStav = monstraStav;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        //takto to je kvuli soucastne modifikaci MONSTRA listu pri smrti mosntra
        var monstra = monstraStav.getMonsters();
        monstra.forEach(monstrum -> monstrum.damage(2000));
        return true;
    }

}
