package zarizeni.monster_switch;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import uloziste_dat.Uloziste;

import java.util.List;
import java.util.Optional;

import static zarizeni.monster_switch.MonsterSwitchListener.SPAWNER_BLOK_DATA;

public final class InicializaceMonsterSwitche {

    private final Uloziste uloziste;
    private final World world;
    private final Plugin plugin;

    public InicializaceMonsterSwitche(Uloziste uloziste, World world, Plugin plugin) {
        this.uloziste = uloziste;
        this.world = world;
        this.plugin = plugin;
    }

    public void inicializace() {
        List<Location> locations = uloziste.nacti(SPAWNER_BLOK_DATA);
        for (var location : locations) {
            world.getBlockAt(location).setMetadata(SPAWNER_BLOK_DATA, new FixedMetadataValue(plugin, true));
        }
    }
}
