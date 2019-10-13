package Model;

import java.time.LocalDateTime;

public class Arrangement {
    private String navn, sted;
    private LocalDateTime datoOgTid;

    public Arrangement(String navn, String sted, LocalDateTime datoOgTid) {
        this.navn = navn;
        this.sted = sted;
        this.datoOgTid = datoOgTid;
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
}
