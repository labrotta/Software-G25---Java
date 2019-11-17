package Model.BrukerKlasser;

import Model.BrukerType;

public class ArrangementAnsvarlig extends BrukerType {
    public ArrangementAnsvarlig(String forNavn, String etternavn, String epost) {
        super(forNavn, etternavn, epost);
    }

    public ArrangementAnsvarlig(int id, String fornavn, String etternavn) {
        super(id, fornavn, etternavn);
    }

    public ArrangementAnsvarlig(String fornavn, String etternavn) {
        super(fornavn, etternavn);
    }
}
