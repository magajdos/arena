package tovarny;

import org.bukkit.Location;

public class TovarnaNaVlny {
    public void wave1 (Location location){
        TovarnaNaMonstra tovarnaNaMonstra = new TovarnaNaMonstra();
        tovarnaNaMonstra.createZombie(location,1,6);
        tovarnaNaMonstra.createZombie(location,2,3);
        tovarnaNaMonstra.createZombie(location,3,1);
    }
    public void wave2 (Location location) {
        TovarnaNaMonstra tovarnaNaMonstra = new TovarnaNaMonstra();
        tovarnaNaMonstra.createZombie(location, 1, 8);
        tovarnaNaMonstra.createZombie(location, 2, 4);
        tovarnaNaMonstra.createZombie(location, 3, 2);
        tovarnaNaMonstra.createZombie(location, 4, 1);
    }
    public void wave3 (Location location){
        TovarnaNaMonstra tovarnaNaMonstra = new TovarnaNaMonstra();
        tovarnaNaMonstra.createZombie(location,1,12);
        tovarnaNaMonstra.createZombie(location,2,3);
        tovarnaNaMonstra.createZombie(location,3,5);
        tovarnaNaMonstra.createZombie(location,4,3);
        tovarnaNaMonstra.createZombie(location,5,1);
    }
    public void wave4 (Location location){
        TovarnaNaMonstra tovarnaNaMonstra = new TovarnaNaMonstra();
        tovarnaNaMonstra.createZombie(location,1,10);
        tovarnaNaMonstra.createZombie(location,2,6);
        tovarnaNaMonstra.createZombie(location,3,4);
        tovarnaNaMonstra.createZombie(location,4,3);
        tovarnaNaMonstra.createZombie(location,5,2);
        tovarnaNaMonstra.createZombie(location,6,1);
    }
}
