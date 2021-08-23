package main;

import devices.MonsterSwitch;
import monsters.Monsters;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import tovarny.TovarnaNaZbrane;
import tovarny.TovarnaNaZbroje;
import tovarny.TovarnaNaZvirata;

public class Main extends JavaPlugin {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//        if (!(sender instanceof Player || sender instanceof CommandBlock)) return false;
        if (!(sender instanceof Player)) return false;
        Player hrac = (Player) sender;
        World svet = hrac.getWorld();
        Location misto = hrac.getLocation();

        var tovarnaNaZbroj = new TovarnaNaZbroje();
        var tovarnaNaZvirata = new TovarnaNaZvirata();
        var tovarnaNaZbrane = new TovarnaNaZbrane();
        switch (command.getName()) {
            case "+trader":
                tovarnaNaZvirata.vyrobVesnicana(svet, misto);
                break;

            case "+obchodnik":
                tovarnaNaZvirata.vyrobObchodnika(svet, misto);
                break;

            case "+monsterSwitch":
                hrac.getInventory().addItem(MonsterSwitch.createMonsterSwitch());
                break;
        }
        return true;
    }

    @Override

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MonsterSwitch(this), this);
        getServer().getPluginManager().registerEvents(new Monsters(), this);
    }
}