package data;

import Model.Arrangement;
import Model.ArrangementKlasser.Lop;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DataHandler {

    private final static ObservableList<Arrangement> arrangementListe = FXCollections.observableArrayList();

    public static ObservableList<Arrangement> getArrangementer() {
        genererArrangementer();
        return arrangementListe;
    }

    private static void genererArrangementer(){
        LocalDate dato = LocalDate.of(2009, 12,12);
        LocalTime tid = LocalTime.of(14,0);
        LocalDateTime tidspunkt = LocalDateTime.of(dato, tid);
        arrangementListe.add(new Ritt("Birken", "Lillehammer", tidspunkt));
        arrangementListe.add(new Ritt("Styrkeprøven", "Trondheim", tidspunkt));
        arrangementListe.add(new Lop("Oslo Marathon", "Oslo", tidspunkt));
        arrangementListe.add(new Renn("Birken", "Lillehammer", tidspunkt));
    }
}
