package Model;

import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
import Model.BrukerKlasser.Bruker;
import Model.BrukerKlasser.Medlem;
import Model.paamelding_resultat.Resultat_Paamelding;

import java.util.ArrayList;

public class BrukerType {
    private int id;
    private String fornavn;
    private String etternavn;
    private String epost;

    public BrukerType(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public BrukerType(int id, String fornavn, String etternavn) {
        this.id = id;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public BrukerType(String fornavn, String etternavn, String epost) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.epost = epost;
    }

    public ArrayList<Resultat_Paamelding> hentResultaterForBruker(ArrayList<Arrangement> arrangementer){
        ArrayList<Resultat_Paamelding> resultaterForBrukeren = new ArrayList<>();
        for (Arrangement etArrangement : arrangementer){
            for (Resultat_Paamelding etResultat : etArrangement.getPaameldinger()){
                if (this == etResultat.getUtoover()){
                    Arrangement arrangement = new Arrangement(
                            etArrangement.getNavn(),
                            etArrangement.getSted(),
                            etArrangement.getDato());
                    etResultat.setArrangement(arrangement);
                    resultaterForBrukeren.add(etResultat);
                }
            }
        }
        return resultaterForBrukeren;
    }

    public boolean brukerErMedlem(){
            return this instanceof Medlem || this instanceof ArrangementAnsvarlig || this instanceof Admin;

    }

    public String hentNavnOgType(){
        return this.fornavn + " (" + this.getClass().getSimpleName() + ")";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean erAdminEllerAA() {
        return (this instanceof Admin || this instanceof ArrangementAnsvarlig);
    }
}

