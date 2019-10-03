package Model;

public class Bruker {
    private String fornavn, etternavn;

    public Bruker(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }
    @Override
    public String toString(){
     return (this.fornavn +" "+ this.etternavn);

    }
}
