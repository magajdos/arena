package listenery;

        import org.bukkit.Material;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.Listener;
        import org.bukkit.event.entity.EntityDeathEvent;
        import org.bukkit.inventory.ItemStack;
        import monstra.TovarnaNaZombiky;

public class OdmenaZaZabitiMonstra implements Listener {

    @EventHandler
    public void deathOfMonsters(EntityDeathEvent deathEvent) {
        if (TovarnaNaZombiky.jeMonstrum(deathEvent.getEntity())) {
            deathEvent.getDrops().clear();
            deathEvent.getDrops().add(new ItemStack(Material.GOLD_NUGGET));
        }
    }
}
