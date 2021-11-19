package main;

import commands.MecNaObchodnika;
import commands.Obchodnik;
import commands.ZabijVsechnaMonstra;
import listenery.ObchodnikNesmrtelnost;
import listenery.OdmenaZaZabitiMonstra;
import listenery.PripojeniRespawn;
import listenery.SmrtMonstra;
import monstra.MonstraStav;
import monstra.VlnyMonster;
import org.bukkit.plugin.java.JavaPlugin;
import uloziste_dat.Uloziste;
import zarizeni.dvere_areny.DvereAreny;
import zarizeni.dvere_areny.DvereArenyCommands;
import zarizeni.dvere_areny.DvereArenyListener;
import zarizeni.dvere_areny.InicializaceDveriDoAreny;
import zarizeni.monster_switch.InicializaceMonsterSwitche;
import zarizeni.monster_switch.MonsterSwitchCommand;
import zarizeni.monster_switch.MonsterSwitchListener;
import zarizeni.monster_switch.ResetSwitchCommand;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        var world = getServer().getWorlds().get(0);
        var tovarnaNaVlny = new VlnyMonster(getDataFolder());
        var uloziste = new Uloziste(world, this);
        var dvereAreny = new DvereAreny(this, uloziste);
        var dvereArenyListener = new DvereArenyListener(dvereAreny, this);
        var monsterSwitch = new MonsterSwitchListener(dvereAreny, tovarnaNaVlny, uloziste, this);
        new InicializaceMonsterSwitche(uloziste, world, this).inicializace();
        new InicializaceDveriDoAreny(dvereAreny, uloziste).inicializace();
        var monstraStav = new MonstraStav(world);

        //listenery
        getServer().getPluginManager().registerEvents(monsterSwitch, this);
        getServer().getPluginManager().registerEvents(new OdmenaZaZabitiMonstra(monstraStav), this);
        getServer().getPluginManager().registerEvents(new SmrtMonstra(dvereAreny, monstraStav), this);
        getServer().getPluginManager().registerEvents(new PripojeniRespawn(), this);
        getServer().getPluginManager().registerEvents(dvereArenyListener, this);
        getServer().getPluginManager().registerEvents(new ObchodnikNesmrtelnost(), this);

        //commandy
        getCommand("+obchodnik").setExecutor(new Obchodnik());
        getCommand("+monsterSwitch").setExecutor(new MonsterSwitchCommand());
        getCommand("+resetMonsterSwitch").setExecutor(new ResetSwitchCommand(tovarnaNaVlny));
        getCommand("+dvere").setExecutor(new DvereArenyCommands());
        getCommand("+znicMonstra").setExecutor(new ZabijVsechnaMonstra(monstraStav));
        getCommand("+mecNaObchodnika").setExecutor(new MecNaObchodnika());

    }
}