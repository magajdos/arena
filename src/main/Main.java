package main;

import devices.DvereDoAreny;
import devices.MonsterSwitch;
import listenery.OdmenaZaZabitiMonstra;
import listenery.SmrtMonstra;
import listenery.VyspawnovaniMonstra;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import tovarny.Obchodnik;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        var monsterSwitch = new MonsterSwitch(this);
        var dvereDoAreny = new DvereDoAreny(this);

        getServer().getPluginManager().registerEvents(monsterSwitch, this);
        getServer().getPluginManager().registerEvents(new OdmenaZaZabitiMonstra(), this);
        getServer().getPluginManager().registerEvents(new VyspawnovaniMonstra(dvereDoAreny.getDvere()), this);
        getServer().getPluginManager().registerEvents(new SmrtMonstra(dvereDoAreny.getDvere()), this);

        //commandy
        getCommand("+obchodnik").setExecutor(new Obchodnik());
        getCommand("+monsterSwitch").setExecutor(monsterSwitch);
        getCommand("+resetMonsterSwitch").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
                monsterSwitch.reset();
                return true;
            }
        });
        getCommand("+dvere").setExecutor(dvereDoAreny);

    }
}