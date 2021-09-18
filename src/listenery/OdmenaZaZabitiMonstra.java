package listenery;

        import org.apache.logging.log4j.util.Strings;
        import org.bukkit.Material;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.Listener;
        import org.bukkit.event.entity.EntityDeathEvent;
        import org.bukkit.inventory.ItemStack;
        import tovarny.TovarnaNaMonstra;

        import static tovarny.TovarnaNaMonstra.ZOMBIE_NAME;

public class OdmenaZaZabitiMonstra implements Listener {

    @EventHandler
    public static void deathOfMonsters(EntityDeathEvent deathEvent) {
        if (TovarnaNaMonstra.jeMonstrum(deathEvent.getEntity())) {
            deathEvent.getDrops().clear();
            deathEvent.getDrops().add(new ItemStack(Material.GOLD_NUGGET));
        }
    }
}
