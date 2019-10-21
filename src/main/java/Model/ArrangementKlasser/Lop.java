package Model.ArrangementKlasser;

import Model.Arrangement;
import javafx.scene.control.Button;

import java.time.LocalDateTime;

public class Lop extends Arrangement {
    public Lop(String navn, String sted, LocalDateTime datoOgTid) {
        super(navn, sted, datoOgTid);
    }
}