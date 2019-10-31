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
        brukere.clear();
        BrukerType admin = new Admin("Ole (admin)","Olsen", "ole@olsen.no");
        BrukerType arrangementAnsvarlig = new ArrangementAnsvarlig("Peder (arrangementansvarlig)","Pedersen", "peder@pedersen.no");
        BrukerType bruker = new Bruker("Trond (bruker)","Trondsen", "trond@trondsen.no");
        BrukerType medlem = new Medlem("Alex (medlem)","Alexandersen", "alex@alexandersen.no");
        brukere.add(admin);
        brukere.add(arrangementAnsvarlig);
        brukere.add(bruker);
        brukere.add(medlem);
        return brukere;
    }
}