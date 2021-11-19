package monstra;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import monstra.MonstraStav;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

final class TovarnaNaZombiky {

    public final static String ZOMBIE_NAME = "Zombie";
    //mapujeme level zombie na definici zombie
    private MonsterDefinition[]  definiceZombiku;

    public TovarnaNaZombiky(File dataAdresar) {
        //nahrajeme zombie z jsonu
        String pathToJsonDefinition = dataAdresar.getPath() + "/zombies.json";
        String definiceZombikuJson = null;
        try {
            definiceZombikuJson = FileUtils.readFileToString(new File(pathToJsonDefinition), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException("Nenalezen soubor s definici zombiku: " + pathToJsonDefinition);
        }
        Gson gson = new Gson();
        definiceZombiku = gson.fromJson(definiceZombikuJson, MonsterDefinition[].class);
    }

    public void createZombie(Location location, int level, int pocet) {
        for (int i = 0; i < pocet; i++) {
            Zombie zombie = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
            var definiceZombika = definiceZombiku[level - 1];
            var zbran = definiceZombika.weapon;
            var helma = definiceZombika.helmet;
            var brneni = definiceZombika.chestPlate;
            var kalhoty = definiceZombika.legins;
            var boty = definiceZombika.boots;
            var regenerace = definiceZombika.regeneration;
            var speed = definiceZombika.speed;
            var sila = definiceZombika.strength;
            var health = definiceZombika.health;

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
}
