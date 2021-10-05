package zarizeni.monster_switch;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import tovarny.TovarnaNaVlny;

public class ResetSwitchCommand implements CommandExecutor {

    private final TovarnaNaVlny tovarnaNaVlny;

    public ResetSwitchCommand(TovarnaNaVlny tovarnaNaVlny) {
        this.tovarnaNaVlny = tovarnaNaVlny;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        tovarnaNaVlny.reset();
        return true;
    }
}
