package Model.ArrangementKlasser;

import Model.Arrangement;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Lop extends Arrangement {
    public Lop(String navn, String sted) {
        super(navn, sted);
    }

    public Lop(int id, String navn, String sted, LocalDate dato, LocalTime tid) {
        super(id, navn, sted, dato, tid);
    }

    public Lop(String navn, String sted, LocalDate dato) {
        super(navn, sted, dato);
    }
}