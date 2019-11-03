package Model;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Arrangement {
    private String navn, sted;
    private LocalDateTime datoOgTid;
    private LocalDate dato;
    private String typeArrangement;

    public Arrangement(String navn, String sted, LocalDate dato) {
        this.navn = navn;
        this.sted = sted;
        this.dato = dato;
    }

    public Arrangement(String navn, String sted, LocalDateTime datoOgTid) {
        this.navn = navn;
        this.sted = sted;
        this.datoOgTid = datoOgTid;
    }

    public Arrangement(String navn, String sted) {
        this.navn = navn;
        this.sted = sted;
    }

    public Arrangement(String navn, String sted,LocalDateTime datoOgTid,String typeArrangement) {
        this.navn = navn;
        this.sted = sted;
        this.typeArrangement = typeArrangement;
        this.datoOgTid = datoOgTid;
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
