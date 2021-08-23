package monsters;

        import org.apache.logging.log4j.util.Strings;
        import org.bukkit.Material;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.Listener;
        import org.bukkit.event.entity.EntityDeathEvent;
        import org.bukkit.inventory.ItemStack;

        import static tovarny.MonsterFactory.ZOMBIE_NAME;

public class Monsters implements Listener {

    @EventHandler
    public static void deathOfMonsters(EntityDeathEvent deathEvent) {

        var coin = new ItemStack(Material.GOLD_NUGGET);

        var monsterName = deathEvent.getEntity().getCustomName();
        if (Strings.isNotEmpty(monsterName) && monsterName.startsWith(ZOMBIE_NAME)) {
            deathEvent.getDrops().clear();
            deathEvent.getDrops().add(coin);
        }
    }
}
