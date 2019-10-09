package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelBruker {
    private final static ObservableList<BrukerTemplate> bruker = FXCollections.observableArrayList();

    public static ObservableList<BrukerTemplate> listeBruker() {
        BrukerTemplate user1 = new BrukerTemplate("Rune","");
        BrukerTemplate user2 = new BrukerTemplate("Trond","");
        BrukerTemplate user3 = new BrukerTemplate("Alex","");
        BrukerTemplate user4 = new BrukerTemplate("Terje","");
        BrukerTemplate user5 = new BrukerTemplate("Jan Thomas","");
        bruker.add(user1);
        bruker.add(user2);
        bruker.add(user3);
        bruker.add(user4);
        bruker.add(user5);
        return bruker;
    }
}