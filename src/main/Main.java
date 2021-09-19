package main;

import devices.DvereDoAreny;
import devices.MonsterSwitch;
import listenery.OdmenaZaZabitiMonstra;
import listenery.PripojeniRespawn;
import listenery.SmrtMonstra;
import listenery.VyspawnovaniMonstra;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import tovarny.Obchodnik;

public class Main extends JavaPlugin {

    private static class ResetSwitch implements CommandExecutor {

        private final MonsterSwitch monsterSwitch;

        public ResetSwitch(MonsterSwitch monsterSwitch) {
            this.monsterSwitch = monsterSwitch;
        }

        @Override
        public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            monsterSwitch.reset();
            return true;
        }
    }

    @Override
    public void onEnable() {
        var monsterSwitch = new MonsterSwitch(this);
        var dvereDoAreny = new DvereDoAreny(this);

        getServer().getPluginManager().registerEvents(monsterSwitch, this);
        getServer().getPluginManager().registerEvents(new OdmenaZaZabitiMonstra(), this);
        getServer().getPluginManager().registerEvents(new VyspawnovaniMonstra(dvereDoAreny.getDvere()), this);
        getServer().getPluginManager().registerEvents(new SmrtMonstra(dvereDoAreny.getDvere()), this);
        getServer().getPluginManager().registerEvents(new PripojeniRespawn(),this);
        getServer().getPluginManager().registerEvents(dvereDoAreny,this);

        //commandy
        getCommand("+obchodnik").setExecutor(new Obchodnik());
        getCommand("+monsterSwitch").setExecutor(monsterSwitch);
        getCommand("+resetMonsterSwitch").setExecutor(new ResetSwitch(monsterSwitch));
        getCommand("+dvere").setExecutor(dvereDoAreny);

    }
}