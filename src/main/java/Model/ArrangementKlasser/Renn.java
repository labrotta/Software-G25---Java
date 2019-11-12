package Model.ArrangementKlasser;

import Model.Arrangement;
import javafx.scene.control.Button;

import java.time.LocalDateTime;

public class Renn extends Arrangement {
    public Renn(int id, String navn, String sted, LocalDateTime datoOgTid) {
        super(id, navn, sted, datoOgTid);
    }

    public Renn(String navn, String sted) {
        super(navn, sted);
    }
}
