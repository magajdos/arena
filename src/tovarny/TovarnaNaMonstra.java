package tovarny;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TovarnaNaMonstra {

    public final static String ZOMBIE_NAME = "Zombie";
    //mapujeme level zombie na definici zombie
    private Map<Integer, MonsterDefinition> zombies = new HashMap<>();

    private static class MonsterDefinition {
        private Integer level;
        private String weapon;
        private String helmet;
        private String chestPlate;
        private String legins;
        private String boots;
        private Integer regeneration;
        private Integer strength;
        private Integer speed;
        private Integer health;
    }

    public TovarnaNaMonstra() {
        //nahrajeme zombie z jsonu
        var is = getClass().getResourceAsStream("/res/zombies.json");
        Gson gson = new Gson();
        MonsterDefinition[] zombiesDefinitions = gson.fromJson(new InputStreamReader(is), MonsterDefinition[].class);

        for (var zombieDefinition : zombiesDefinitions) {
            zombies.put(zombieDefinition.level, zombieDefinition);
        }
    }

    public void createZombie(Location location, int level, int pocet) {
        for (int i = 0; i < pocet; i++) {
            Zombie zombie = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
            var zbran = zombies.get(level).weapon;
            var helma = zombies.get(level).helmet;
            var brneni = zombies.get(level).chestPlate;
            var kalhoty = zombies.get(level).legins;
            var boty = zombies.get(level).boots;
            var regenerace = zombies.get(level).regeneration;
            var speed = zombies.get(level).speed;
            var sila = zombies.get(level).strength;
            var health = zombies.get(level).health;

            if (zbran != null) {
                zombie.getEquipment().setItemInMainHand(new ItemStack(Material.valueOf(zbran)));
            }
            if (helma != null) {
                zombie.getEquipment().setHelmet(new ItemStack(Material.valueOf(helma)));
            }
            if (brneni != null) {
                zombie.getEquipment().setChestplate(new ItemStack(Material.valueOf(brneni)));
            }
            if (kalhoty != null) {
                zombie.getEquipment().setLeggings(new ItemStack(Material.valueOf(kalhoty)));
            }
            if (boty != null) {
                zombie.getEquipment().setBoots(new ItemStack(Material.valueOf(boty)));
            }
            if (regenerace != null) {
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000000, regenerace));
            }
            if (sila != null) {
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000000, sila));
            }

            if (speed != null) {
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, speed));
            }

            if (health != null) {
                AttributeInstance ai = zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                ai.setBaseValue(health);
                zombie.setHealth(health);
            }
            zombie.setCustomName(ZOMBIE_NAME + " LVL " + level);
        }
    }

    public static boolean jeMonstrum(LivingEntity monstrum) {
        var jmeno = monstrum.getCustomName();
        if (Strings.isNullOrEmpty(jmeno)) return false;
        return jmeno.startsWith(ZOMBIE_NAME);
    }

}
