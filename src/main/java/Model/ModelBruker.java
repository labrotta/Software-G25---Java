package Model;

import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
import Model.BrukerKlasser.Bruker;
import Model.BrukerKlasser.Medlem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelBruker {
    private final static ObservableList<BrukerTemplate> brukere = FXCollections.observableArrayList();

    public static ObservableList<BrukerTemplate> listeBruker() {
        BrukerTemplate admin = new Admin("Admin","");
        BrukerTemplate arrangementAnsvarlig = new ArrangementAnsvarlig("ArrangementAnsvarlig","");
        BrukerTemplate bruker = new Bruker("Bruker","");
        BrukerTemplate medlem = new Medlem("Medlem","");
        brukere.add(admin);
        brukere.add(arrangementAnsvarlig);
        brukere.add(bruker);
        brukere.add(medlem);
        return brukere;
    }
}