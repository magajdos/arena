package monstra;

import com.google.common.collect.Lists;
import org.bukkit.entity.Monster;

import java.util.List;

public final class MonstraStav {

    private final static List<Monster> MONSTRA = Lists.newArrayList();

    private MonstraStav() {
    }

    public static void pridejMonstrum(Monster monster) {
        MONSTRA.add(monster);
    }

    public static boolean jsouMonstraMrtva() {
        for (var monstrum : MONSTRA) {
            if (monstrum.isDead()) MONSTRA.remove(monstrum);
        }
        return MONSTRA.isEmpty();
    }

    public static void odstranMonstrum(Monster monster) {
        MONSTRA.remove(monster);
    }
}