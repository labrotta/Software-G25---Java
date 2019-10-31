package Model.BrukerKlasser;

import Model.BrukerType;

public class ArrangementAnsvarlig extends BrukerType {
    public ArrangementAnsvarlig(String forNavn, String etternavn, String epost) {
        super(forNavn, etternavn, epost);
    }

    public ArrangementAnsvarlig(String fornavn, String etternavn) {
        super(fornavn, etternavn);
    }
}
