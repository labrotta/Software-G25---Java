package Model;


import Model.paamelding_resultat.Resultat_Paamelding;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Arrangement {
    private int id;
    private String navn, sted;
    private LocalDateTime datoOgTid;
    private LocalDate dato;
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

    public Arrangement(int id, String navn, String sted, LocalDateTime datoOgTid) {
        this.id = id;
        this.navn = navn;
        this.sted = sted;
        this.datoOgTid = datoOgTid;
        this.paameldinger = new ArrayList<>();
    }

    public Arrangement(String navn, String sted) {
        int id;
        this.navn = navn;
        this.sted = sted;
        this.paameldinger = new ArrayList<>();
    }

    public Arrangement(String navn, String sted,LocalDateTime datoOgTid,String typeArrangement) {

        this.navn = navn;
        this.sted = sted;
        this.typeArrangement = typeArrangement;
        this.datoOgTid = datoOgTid;
        this.paameldinger = new ArrayList<>();
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

    public LocalDateTime getDatoOgTid() {
        return datoOgTid;
    }

    public void setDatoOgTid(LocalDateTime datoOgTid) {
        this.datoOgTid = datoOgTid;
    }

    public String getTypeArrangement() {
        return typeArrangement;
    }

    public void setTypeArrangement(String typeArrangement) {
        this.typeArrangement = typeArrangement;
    }
}
