package tovarny;

import org.bukkit.Location;

public class WaveFactory2 {
    public void wave1 (Location location){
        MonsterFactory monsterFactory = new MonsterFactory();
        monsterFactory.createZombie(location,1,6);
        monsterFactory.createZombie(location,2,3);
        monsterFactory.createZombie(location,3,1);
    }
    public void wave2 (Location location) {
        MonsterFactory monsterFactory = new MonsterFactory();
        monsterFactory.createZombie(location, 1, 8);
        monsterFactory.createZombie(location, 2, 4);
        monsterFactory.createZombie(location, 3, 2);
        monsterFactory.createZombie(location, 4, 1);
    }
    public void wave3 (Location location){
        MonsterFactory monsterFactory = new MonsterFactory();
        monsterFactory.createZombie(location,1,12);
        monsterFactory.createZombie(location,2,3);
        monsterFactory.createZombie(location,3,5);
        monsterFactory.createZombie(location,4,3);
        monsterFactory.createZombie(location,5,1);
    }
    public void wave4 (Location location){
        MonsterFactory monsterFactory = new MonsterFactory();
        monsterFactory.createZombie(location,1,10);
        monsterFactory.createZombie(location,2,6);
        monsterFactory.createZombie(location,3,4);
        monsterFactory.createZombie(location,4,3);
        monsterFactory.createZombie(location,5,2);
        monsterFactory.createZombie(location,6,1);
    }
}
