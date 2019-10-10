package Model;

public class BrukerTemplate {
    String forNavn;
    String etterNavn;

    public void setEtternavn(String etternavn) {
        this.etterNavn = etternavn;
    }

    public BrukerTemplate(String forNavn, String etternavn) {
        this.forNavn = forNavn;
        this.etterNavn = etternavn;
    }

    public String getForNavn() {
        return forNavn;
    }

    public void setForNavn(String forNavn) {
        this.forNavn = forNavn;
    }

    public String getEtternavn() {
        return etterNavn;
    }

    @Override
    public String toString() {
        return (this.forNavn + " " + this.etterNavn);
    }
}

