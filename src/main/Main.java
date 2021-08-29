package main;

import devices.DvereDoAreny;
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
    private DvereDoAreny dvereDoAreny;

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

            case "+vytvorDvere":
                hrac.getInventory().addItem(dvereDoAreny.vytvorDvere());
                break;

        }
        return true;
    }

    @Override
    public void onEnable() {
        dvereDoAreny = new DvereDoAreny(this);
        monsterSwitch = new MonsterSwitch(this, dvereDoAreny);
        getServer().getPluginManager().registerEvents(monsterSwitch, this);
        getServer().getPluginManager().registerEvents(new ListeneryMonster(), this);
        getServer().getPluginManager().registerEvents(dvereDoAreny, this);
    }
}