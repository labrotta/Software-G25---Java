package Model.paamelding_resultat;

import Model.Arrangement;
import Model.BrukerType;

import java.time.LocalTime;
import java.util.ArrayList;

public class Resultat_Paamelding {
    //Denne klassen er for både resultat og påmelding
    private BrukerType utoover;
    private LocalTime starttid, slutttid;
    //Det kan noen ganger være nyttig å ta med arrangementet slik at vi vet hvilket arrangement
    //et resultat tilhører.
    private Arrangement arrangement;

    public Resultat_Paamelding(BrukerType utoover, LocalTime starttid, LocalTime slutttid) {
        this.utoover = utoover;
        this.starttid = starttid;
        this.slutttid = slutttid;
        Arrangement arrangement;
    }

    public Resultat_Paamelding(BrukerType utoover) {
        this.utoover = utoover;
    }

    public Arrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(Arrangement arrangement) {
        this.arrangement = arrangement;
    }

    public LocalTime getStarttid() {
        return starttid;
    }

    public void setStarttid(LocalTime starttid) {
        this.starttid = starttid;
    }

    public LocalTime getSlutttid() {
        return slutttid;
    }

    public void setSlutttid(LocalTime slutttid) {
        this.slutttid = slutttid;
    }

    public BrukerType getUtoover() {
        return utoover;
    }

    public void setUtoover(BrukerType utoover) {
        this.utoover = utoover;
    }
}
