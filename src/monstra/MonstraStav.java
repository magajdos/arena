package monstra;

import com.google.common.collect.Lists;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;

import java.util.Collections;
import java.util.List;

public final class MonstraStav implements CommandExecutor {

    private final static List<LivingEntity> MONSTRA = Lists.newArrayList();

    public static void pridejMonstrum(LivingEntity monster) {
        MONSTRA.add(monster);
    }

    public static boolean jsouMonstraMrtva() {
        for (var monstrum : MONSTRA) {
            if (monstrum.isDead()) MONSTRA.remove(monstrum);
        }
        return MONSTRA.isEmpty();
    }

    public static void odstranMonstrum(LivingEntity monster) {
        MONSTRA.remove(monster);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        //takto to je kvuli soucastne modifikaci MONSTRA listu pri smrti mosntra
        while (!MONSTRA.isEmpty()) {
            var monstrum = MONSTRA.remove(0);
            monstrum.damage(2000);
        }
        return true;
    }
}
