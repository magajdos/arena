package main;

import devices.MonsterSwitch;
import listenery.ListeneryMonster;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private MonsterSwitch monsterSwitch;

    @Override
    public void onEnable() {
        monsterSwitch = new MonsterSwitch(this);
        getServer().getPluginManager().registerEvents(monsterSwitch, this);
        getServer().getPluginManager().registerEvents(new ListeneryMonster(), this);
    }
}