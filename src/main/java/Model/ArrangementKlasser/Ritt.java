package Model.ArrangementKlasser;

import Model.Arrangement;

import java.time.LocalDateTime;

public class Ritt extends Arrangement {
    public Ritt(String navn, String sted, LocalDateTime datoOgTid) {
        super(navn, sted, datoOgTid);
    }
}
