package Model.ArrangementKlasser;

import Model.Arrangement;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Renn extends Arrangement {
    public Renn(int id, String navn, String sted, LocalDate dato, LocalTime tid) {
        super(id, navn, sted, dato, tid);
    }

    public Renn(String navn, String sted) {
        super(navn, sted);
    }
}
