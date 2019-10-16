package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class BrukerSessionModel {

    private final static ObservableList<String> brukerSessions = FXCollections.observableArrayList();
    private Arrays[] brukerS = new Arrays[1];

    public static ObservableList<String> sjekkBruker(ObservableList<String> brukerSession){
        if(brukerSession.isEmpty()){
            brukerSession.add("Ukjent");
            return brukerSession;
        }else {
            return brukerSession;
        }
    }

    public static ObservableList<String> getBrukerSessions() {
        return brukerSessions;
    }
    public static void genBrukerSession(String bruker){
        if(brukerSessions.size() < 1 ){
            brukerSessions.add(bruker);
        }else {
            brukerSessions.clear();
            brukerSessions.add(bruker.trim());
        }

    }
}
