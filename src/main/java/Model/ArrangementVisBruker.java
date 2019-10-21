package Model;

import java.sql.Time;

public class ArrangementVisBruker {
    private Time StartTid,SluttTid;
    private String BrukerUnikID;
    private String ArrengementNavn;

    public ArrangementVisBruker(String brukerUnikID,Time startTid, Time sluttTid ) {
        StartTid = startTid;
        SluttTid = sluttTid;
        BrukerUnikID = brukerUnikID;
    }

    public String getArrengementNavn() {
        return ArrengementNavn;
    }

    public void setArrengementNavn(String arrengementNavn) {
        ArrengementNavn = arrengementNavn;
    }

    public Time getStartTid() {
        return StartTid;
    }

    public void setStartTid(Time startTid) {
        StartTid = startTid;
    }

    public Time getSluttTid() {
        return SluttTid;
    }

    public void setSluttTid(Time sluttTid) {
        SluttTid = sluttTid;
    }

    public String getBrukerUnikID() {
        return BrukerUnikID;
    }

    public void setBrukerUnikID(String brukerUnikID) {
        BrukerUnikID = brukerUnikID;
    }
}
