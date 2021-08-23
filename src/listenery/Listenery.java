package listenery;

import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class Listenery implements Listener {

    public static void frozenSword(EntityDamageByEntityEvent event){
        if (!(event.getDamager() instanceof Player)) return;
        var player = (Player) event.getDamager();
        World svet = (World) player.getWorld();
        var vecVPraveRuce = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
        if ("FROZEN SWORD".equals(vecVPraveRuce)){
            var entita = event.getEntity();
            if (entita instanceof LivingEntity){
                LivingEntity zijciEntita = (LivingEntity) entita;
                zijciEntita.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5, 3, true));

            }
        }
    }
}