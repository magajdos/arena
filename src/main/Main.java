package main;

import commands.MecNaObchodnika;
import listenery.ObchodnikNesmrtelnost;
import monstra.VlnyMonster;
import tovarny.TovarnaNaZbrane;
import uloziste_dat.Uloziste;
import zarizeni.dvere_areny.DvereAreny;
import zarizeni.dvere_areny.DvereArenyCommands;
import zarizeni.dvere_areny.DvereArenyListener;
import zarizeni.dvere_areny.InicializaceDveriDoAreny;
import zarizeni.monster_switch.InicializaceMonsterSwitche;
import zarizeni.monster_switch.ResetSwitchCommand;
import zarizeni.monster_switch.MonsterSwitchCommand;
import zarizeni.monster_switch.MonsterSwitchListener;
import listenery.OdmenaZaZabitiMonstra;
import listenery.PripojeniRespawn;
import listenery.SmrtMonstra;
import monstra.MonstraStav;
import org.bukkit.plugin.java.JavaPlugin;
import commands.Obchodnik;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        var world = getServer().getWorlds().get(0);
        var tovarnaNaVlny = new VlnyMonster();
        var uloziste = new Uloziste(world, this);
        var dvereAreny = new DvereAreny(this, uloziste);
        var dvereArenyListener = new DvereArenyListener(dvereAreny, this);
        var monsterSwitch = new MonsterSwitchListener(dvereAreny, tovarnaNaVlny, uloziste, this);
        new InicializaceMonsterSwitche(uloziste, world, this).inicializace();
        new InicializaceDveriDoAreny(dvereAreny, uloziste).inicializace();

        //listenery
        getServer().getPluginManager().registerEvents(monsterSwitch, this);
        getServer().getPluginManager().registerEvents(new OdmenaZaZabitiMonstra(), this);
        getServer().getPluginManager().registerEvents(new SmrtMonstra(dvereAreny), this);
        getServer().getPluginManager().registerEvents(new PripojeniRespawn(), this);
        getServer().getPluginManager().registerEvents(dvereArenyListener, this);
        getServer().getPluginManager().registerEvents(new ObchodnikNesmrtelnost(), this);


        //commandy
        getCommand("+obchodnik").setExecutor(new Obchodnik());
        getCommand("+monsterSwitch").setExecutor(new MonsterSwitchCommand());
        getCommand("+resetMonsterSwitch").setExecutor(new ResetSwitchCommand(tovarnaNaVlny));
        getCommand("+dvere").setExecutor(new DvereArenyCommands());
        getCommand("+znicMonstra").setExecutor(new MonstraStav());
        getCommand("+mecNaObchodnika").setExecutor(new MecNaObchodnika());

    }
}