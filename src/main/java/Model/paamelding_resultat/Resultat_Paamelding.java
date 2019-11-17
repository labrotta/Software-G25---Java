package Model.paamelding_resultat;

import Model.Arrangement;
import Model.BrukerType;

import java.time.Duration;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.ArrayList;

public class Resultat_Paamelding {
    //Denne klassen er for både resultat og påmelding
    private BrukerType utoover;
    private LocalTime starttid, slutttid;
    private int plassering;
    //Det kan noen ganger være nyttig å ta med arrangementet slik at vi vet hvilket arrangement
    //et resultat tilhører. Faren er at det blir en evig loop
    //med arrangement->påmelding->arrangement->påmel.......
    private Arrangement arrangement;


    public Resultat_Paamelding(BrukerType utoover, LocalTime starttid, LocalTime slutttid, int plassering) {
        this.utoover = utoover;
        this.starttid = starttid;
        this.slutttid = slutttid;
        this.plassering = plassering;
    }

    public Long hentTidBrukt(){
        if (this.starttid != null){
            return Duration.between(this.starttid, this.slutttid).toMinutes();
        } else {
            return Long.valueOf(0);
        }
    }

    public int getPlassering() {
        return plassering;
    }

    public void setPlassering(int plassering) {
        this.plassering = plassering;
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
