package Model.paamelding_resultat;

import Model.BrukerType;

import java.time.LocalTime;

public class Resultat_Paamelding {
    //Denne klassen er for både resultat og påmelding
    private BrukerType utoover;
    private LocalTime starttid, slutttid;

    public Resultat_Paamelding(BrukerType utoover, LocalTime starttid, LocalTime slutttid) {
        this.utoover = utoover;
        this.starttid = starttid;
        this.slutttid = slutttid;
    }

    public Resultat_Paamelding(BrukerType utoover) {
        this.utoover = utoover;
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
