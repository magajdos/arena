package main;

import devices.MonsterSwitch;
import listenery.ListeneryMonster;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.JavaPlugin;
import tovarny.TovarnaNaZbrane;
import tovarny.TovarnaNaZbroje;
import tovarny.TovarnaNaZvirata;

public class Main extends JavaPlugin {

    private MonsterSwitch monsterSwitch;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
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
                hrac.getInventory().addItem(monsterSwitch.createMonsterSwitch());
                break;

            case "+resetSwitch":
                monsterSwitch.reset();
                break;

        }
        return true;
    }

    @Override
    public void onEnable() {
        monsterSwitch = new MonsterSwitch(this);
        getServer().getPluginManager().registerEvents(monsterSwitch, this);
        getServer().getPluginManager().registerEvents(new ListeneryMonster(), this);
    }
}