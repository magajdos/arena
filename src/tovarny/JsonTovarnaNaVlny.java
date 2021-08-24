package tovarny;

import com.google.gson.Gson;
import org.bukkit.Location;

import java.io.InputStreamReader;
import java.util.List;


public final class JsonTovarnaNaVlny {
    private final TovarnaNaMonstra tovarnaNaMonstra = new TovarnaNaMonstra();
    private final WaveDefinition[] definiceVln;

    private static class WaveDefinition {
        private Integer waveNumber;
        private List<Monsters> monsters;
    }

    private static class Monsters {
        private Integer level;
        private Integer count;
        private String type;
    }

    public JsonTovarnaNaVlny() {
        var is = getClass().getResourceAsStream("/res/wave.json");
        Gson gson = new Gson();
        definiceVln = gson.fromJson(new InputStreamReader(is), JsonTovarnaNaVlny.WaveDefinition[].class);
    }

    public void vlna(Location location, int waveNumber) {
        var monsters = definiceVln[waveNumber - 1].monsters;
        monsters.forEach( monster -> {
            switch (monster.type) {
                case "Zombie" :
                    tovarnaNaMonstra.createZombie(location, monster.level, monster.count);
                    break;
            }
        });
    }

    public int pocet() {
        return definiceVln.length;
    }
}
