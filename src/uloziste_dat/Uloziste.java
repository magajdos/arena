package uloziste_dat;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.TileState;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class Uloziste {

    private final World world;
    private final TileState uloziste;
    private final Plugin plugin;

    public Uloziste(World world, Plugin plugin) {
        this.world = world;
        Block block0 = world.getBlockAt(0, 0, 0);

        if (!(block0.getState() instanceof Chest)) {
            block0.setType(Material.CHEST);
        }
        uloziste = (TileState) block0.getState();
        this.plugin = plugin;
    }

    public void uloz(String key, List<Location> locations) {
        PersistentDataContainer container = uloziste.getPersistentDataContainer();
        var namespaceKey = new NamespacedKey(plugin, key);
        List<Integer> seznam = new ArrayList<>();//Lists.newArrayList();
        for (var location : locations) {
            seznam.add(location.getBlockX());
            seznam.add(location.getBlockY());
            seznam.add(location.getBlockZ());
        }
        container.set(namespaceKey, PersistentDataType.INTEGER_ARRAY, Ints.toArray(seznam));
        uloziste.update(true, false);
    }

    public void smaz(String key) {
        PersistentDataContainer container = uloziste.getPersistentDataContainer();
        container.remove(new NamespacedKey(plugin, key));
        uloziste.update(true, false);
    }

    public List<Location> nacti(String key) {
        var container = uloziste.getPersistentDataContainer();
        int[] souradnice = container.get(new NamespacedKey(plugin, key), PersistentDataType.INTEGER_ARRAY);
        if (souradnice == null) return Collections.emptyList();
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < souradnice.length; i= i + 3) {
            locations.add(new Location(world, souradnice[i], souradnice[i+1], souradnice[i+2]));
        }
        return locations;
    }
}