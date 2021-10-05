package main;

import tovarny.TovarnaNaVlny;
import zarizeni.dvere_areny.DvereAreny;
import zarizeni.dvere_areny.DvereArenyCommands;
import zarizeni.dvere_areny.DvereArenyListener;
import zarizeni.monster_switch.ResetSwitchCommand;
import zarizeni.monster_switch.MonsterSwitchCommand;
import zarizeni.monster_switch.MonsterSwitchListener;
import listenery.OdmenaZaZabitiMonstra;
import listenery.PripojeniRespawn;
import listenery.SmrtMonstra;
import monstra.MonstraStav;
import org.bukkit.plugin.java.JavaPlugin;
import tovarny.Obchodnik;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        var tovarnaNaVlny = new TovarnaNaVlny();
        var dvereAreny = new DvereAreny(this);
        var dvereArenyListener = new DvereArenyListener(dvereAreny, this);
        var monsterSwitch = new MonsterSwitchListener(dvereAreny, tovarnaNaVlny, this);

        //eventy
        getServer().getPluginManager().registerEvents(monsterSwitch, this);
        getServer().getPluginManager().registerEvents(new OdmenaZaZabitiMonstra(), this);
        getServer().getPluginManager().registerEvents(new SmrtMonstra(dvereAreny), this);
        getServer().getPluginManager().registerEvents(new PripojeniRespawn(),this);
        getServer().getPluginManager().registerEvents(dvereArenyListener,this);

        //commandy
        getCommand("+obchodnik").setExecutor(new Obchodnik());
        getCommand("+monsterSwitch").setExecutor(new MonsterSwitchCommand());
        getCommand("+resetMonsterSwitch").setExecutor(new ResetSwitchCommand(tovarnaNaVlny));
        getCommand("+dvere").setExecutor(new DvereArenyCommands());
        getCommand("+znicMonstra").setExecutor(new MonstraStav());
    }
}