package Model;


import Model.ArrangementKlasser.Lop;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import Model.paamelding_resultat.Resultat_Paamelding;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


public class Arrangement {
    private int id;
    private String navn, sted;
    private LocalDate dato;
    private LocalTime tid;
    private String typeArrangement;

    public ArrayList<Resultat_Paamelding> getPaameldinger() {
        return paameldinger;
    }

    public void setPaameldinger(ArrayList<Resultat_Paamelding> paameldinger) {
        this.paameldinger = paameldinger;
    }

    public void setPaameldinger(Resultat_Paamelding resultatPaamelding){
        this.paameldinger.add(resultatPaamelding);
    }

    private ArrayList<Resultat_Paamelding> paameldinger;

    public Arrangement(String navn, String sted, LocalDate dato) {
        this.navn = navn;
        this.sted = sted;
        this.dato = dato;
    }

    public Arrangement(int id, String navn, String sted, LocalDate dato, LocalTime tid) {
        this.id = id;
        this.navn = navn;
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
        this.paameldinger = new ArrayList<>();
    }

    public Arrangement(String navn, String sted) {
        int id;
        this.navn = navn;
        this.sted = sted;
        this.paameldinger = new ArrayList<>();
    }

    public Arrangement(String navn, String sted, LocalDate dato, LocalTime tid, String typeArrangement) {

        this.navn = navn;
        this.sted = sted;
        this.typeArrangement = typeArrangement;
        this.dato = dato;
        this.tid = tid;
        this.paameldinger = new ArrayList<>();
    }

    public static ArrayList<Arrangement> filtrerArrangementerEtterType(ArrayList<Arrangement> arrangementer, String type) {
        ArrayList<Arrangement> arrangementerMedRiktigType = new ArrayList<>();
        for (Arrangement arrangement : arrangementer){
            if (type.equals("Sykkelritt") && arrangement instanceof Ritt){
                arrangementerMedRiktigType.add(arrangement);
            }
            if (type.equals("Skirenn") && arrangement instanceof Renn){
                arrangementerMedRiktigType.add(arrangement);
            }
            if (type.equals("Løp") && arrangement instanceof Lop){
                arrangementerMedRiktigType.add(arrangement);
            }
        }
        return arrangementerMedRiktigType;
    }

    public LocalTime getTid() {
        return tid;
    }

    public void setTid(LocalTime tid) {
        this.tid = tid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public String getTypeArrangement() {
        return typeArrangement;
    }

    public void setTypeArrangement(String typeArrangement) {
        this.typeArrangement = typeArrangement;
    }
}
