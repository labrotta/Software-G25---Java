package Model.BrukerKlasser;

import Model.BrukerType;

public class Admin extends BrukerType {
    public Admin(String forNavn, String etternavn, String epost) {
        super(forNavn, etternavn, epost);
    }

    public Admin(int id, String fornavn, String etternavn) {
        super(id, fornavn, etternavn);
    }

    public Admin(String fornavn, String etternavn) {
        super(fornavn, etternavn);
    }
}
