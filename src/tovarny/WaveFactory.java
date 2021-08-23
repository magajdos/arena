package tovarny;

import com.google.gson.Gson;
import org.bukkit.Location;

import java.io.InputStreamReader;
import java.util.List;


public class WaveFactory {
    private MonsterFactory monsterFactory = new MonsterFactory();

    private static class WaveDefinition {
        private Integer waveNumber;
        private List<Monsters> monsters;
    }

    private static class Monsters {
        private Integer level;
        private Integer count;
        private String type;
    }

    public WaveFactory() {
        var is = getClass().getResourceAsStream("/res/wave.json");
        Gson gson = new Gson();
        var waveDefinition = gson.fromJson(new InputStreamReader(is), WaveFactory.WaveDefinition[].class);
    }

    public void wave(Location location, int waveNumber) {

    }
}
