package zarizeni.dvere_areny;

import com.google.common.collect.Lists;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Door;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public final class DvereAreny {
    public static final String JMENO = "Dvere do areny";
    private final List<Block> dvere = Lists.newArrayList();
    private final Plugin plugin;

    public DvereAreny(Plugin plugin) {
        this.plugin = plugin;
    }

    private void zmenStavDveri(boolean stav) {
        for (Block blokDveri : dvere) {
            Door dvere = (Door) blokDveri.getBlockData();
            dvere.setOpen(stav);
            blokDveri.setBlockData(dvere);
        }
    }

    public void otevriDvere() {
        zmenStavDveri(true);
    }

    public void zavriDvere() {
        zmenStavDveri(false);
    }

    public void pridejDvere(Block block) {
        block.setMetadata(JMENO, new FixedMetadataValue(plugin, true));
        dvere.add(block);
    }
}
