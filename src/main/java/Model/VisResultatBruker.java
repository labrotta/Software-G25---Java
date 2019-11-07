package Model;

public class VisResultatBruker {
    private String Dato;
    private String Sted;
    private String Plass;
    private String navn;

    @Override
    public String toString() {
        return Dato +" "+ Sted  +" "+ Plass +" "+ navn ;
    }

    public VisResultatBruker(String dato, String sted, String plass, String navn) {
        this.Dato = dato;
        this.Sted = sted;
        this.Plass = plass;
        this.navn = navn;
    }

    public String getDato() {
        return Dato;
    }

    public void setDato(String dato) {
        Dato = dato;
    }

    public String getSted() {
        return Sted;
    }

    public void setSted(String sted) {
        Sted = sted;
    }

    public String getPlass() {
        return Plass;
    }

    public void setPlass(String plass) {
        Plass = plass;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
