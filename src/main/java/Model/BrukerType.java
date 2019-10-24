package Model;

public class BrukerType {
    private String fornavn;
    private String etternavn;
    private String epost;

    public BrukerType(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public BrukerType(String fornavn, String etternavn, String epost) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.epost = epost;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etterNavn) {
        this.etternavn = etterNavn;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setForNavn(String forNavn) {
        this.fornavn = forNavn;
    }

    @Override
    public String toString() {
        return (this.fornavn + " " + this.etternavn);
    }

}

