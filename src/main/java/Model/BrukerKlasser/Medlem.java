package Model.BrukerKlasser;

import Model.BrukerType;

public class Medlem extends BrukerType {
    public Medlem(String fornavn, String etternavn) {
        super(fornavn, etternavn);
    }

    public Medlem(String forNavn, String etternavn, String epost) {
        super(forNavn, etternavn, epost);
    }
}
