package Model;

import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
import Model.BrukerKlasser.Bruker;
import Model.BrukerKlasser.Medlem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelBruker {
    private final static ObservableList<BrukerType> brukere = FXCollections.observableArrayList();

    public static ObservableList<BrukerType> listeBruker() {
        BrukerType admin = new Admin("Admin","");
        BrukerType arrangementAnsvarlig = new ArrangementAnsvarlig("ArrangementAnsvarlig","");
        BrukerType bruker = new Bruker("Bruker","");
        BrukerType medlem = new Medlem("Medlem","");
        brukere.add(admin);
        brukere.add(arrangementAnsvarlig);
        brukere.add(bruker);
        brukere.add(medlem);
        return brukere;
    }
}