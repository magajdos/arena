package zarizeni.dvere_areny;

import org.bukkit.World;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import uloziste_dat.Uloziste;

import static zarizeni.dvere_areny.DvereAreny.*;

public class InicializaceDveriDoAreny {

    private final Uloziste uloziste;
    private final DvereAreny dvereAreny;

    public InicializaceDveriDoAreny(DvereAreny dvereAreny, Uloziste uloziste) {
        this.uloziste = uloziste;
        this.dvereAreny = dvereAreny;
    }

    public void inicializace() {
        var lokaceBlokuDveri = uloziste.nacti(DVERE_DO_ARENY_ZNACKA);
        for (var lokace : lokaceBlokuDveri) {
            dvereAreny.pridejDvere(lokace.getBlock());
        }
    }

}
