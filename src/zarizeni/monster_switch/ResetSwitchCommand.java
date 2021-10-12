package zarizeni.monster_switch;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import monstra.VlnyMonster;

public class ResetSwitchCommand implements CommandExecutor {

    private final VlnyMonster vlnyMonster;

    public ResetSwitchCommand(VlnyMonster vlnyMonster) {
        this.vlnyMonster = vlnyMonster;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        vlnyMonster.reset();
        return true;
    }
}
