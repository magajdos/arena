package main;

import zarizeni.dvere_areny.DvereAreny;
import zarizeni.dvere_areny.DvereArenyCommands;
import zarizeni.dvere_areny.DvereArenyListener;
import zarizeni.MonsterSwitch;
import listenery.OdmenaZaZabitiMonstra;
import listenery.PripojeniRespawn;
import listenery.SmrtMonstra;
import monstra.MonstraStav;
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
        var dvereAreny = new DvereAreny(this);
        var dvereArenyListener = new DvereArenyListener(dvereAreny, this);
        var monsterSwitch = new MonsterSwitch(dvereAreny, this);

        getServer().getPluginManager().registerEvents(monsterSwitch, this);
        getServer().getPluginManager().registerEvents(new OdmenaZaZabitiMonstra(), this);
        getServer().getPluginManager().registerEvents(new SmrtMonstra(dvereAreny), this);
        getServer().getPluginManager().registerEvents(new PripojeniRespawn(),this);
        getServer().getPluginManager().registerEvents(dvereArenyListener,this);

        //commandy
        getCommand("+obchodnik").setExecutor(new Obchodnik());
        getCommand("+monsterSwitch").setExecutor(monsterSwitch);
        getCommand("+resetMonsterSwitch").setExecutor(new ResetSwitch(monsterSwitch));
        getCommand("+dvere").setExecutor(new DvereArenyCommands());
        getCommand("+znicMonstra").setExecutor(new MonstraStav());
    }
}