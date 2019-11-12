package Model.BrukerKlasser;

import Model.BrukerType;

public class Bruker extends BrukerType {
    public Bruker(String fornavn, String etternavn) {
        super(fornavn, etternavn);
    }

    public Bruker(int id, String fornavn, String etternavn) {
        super(id, fornavn, etternavn);
    }

    public Bruker(String forNavn, String etternavn, String epost) {
        super(forNavn, etternavn, epost);
    }
}
