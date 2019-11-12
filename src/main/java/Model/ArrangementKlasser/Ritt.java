package Model.ArrangementKlasser;

import Model.Arrangement;
import javafx.scene.control.Button;

import java.time.LocalDateTime;

public class Ritt extends Arrangement {
    public Ritt(int id, String navn, String sted, LocalDateTime datoOgTid) {
        super(id, navn, sted, datoOgTid);
    }

    public Ritt(String navn, String sted) {super(navn, sted);}
}
