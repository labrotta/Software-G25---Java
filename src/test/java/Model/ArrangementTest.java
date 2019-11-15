package Model;

import Model.ArrangementKlasser.Lop;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import Model.BrukerKlasser.Bruker;
import Model.BrukerKlasser.Medlem;
import Model.paamelding_resultat.Resultat_Paamelding;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static Model.Arrangement.filtrerArrangementerEtterType;
import static org.junit.jupiter.api.Assertions.*;

class ArrangementTest {

    ArrayList<LocalDate> datoer = new ArrayList<>();
    ArrayList<LocalTime> tider = new ArrayList<>();
    ArrayList<Arrangement> arrangementer = new ArrayList<>();
    BrukerType brukerType = new BrukerType("Helge", "Helgesen");
    Resultat_Paamelding resultat_paamelding = new Resultat_Paamelding(brukerType);
    ArrayList<Resultat_Paamelding> resultat_paameldingListe = new ArrayList<>();

    @BeforeEach
    void setUp() {

        LocalDate dato1 = LocalDate.of(2019, 12, 24);
        LocalDate dato2 = LocalDate.of(2020, 2, 6);
        datoer.add(dato1);
        datoer.add(dato2);

        LocalTime tid1 = LocalTime.of(14, 30);
        LocalTime tid2 = LocalTime.of(19, 0);
        LocalTime tid3 = LocalTime.of(13, 0, 0);
        LocalTime tid4 = LocalTime.of(13, 43, 37);
        tider.add(tid1);
        tider.add(tid2);
        tider.add(tid3);
        tider.add(tid4);

        Arrangement skirenn = new Renn(1, "RennTest1", "Testborg", dato1, tid1);
        skirenn.setPaameldinger(resultat_paamelding);
        Arrangement sykkelritt = new Ritt(2, "RittTest1", "Testborg", dato1, tid2);
        Arrangement lop = new Lop(3, "RennTest1", "Testborg", dato2, tid1);
        Arrangement skirenn2 = new Renn(4, "RennTest1", "Testborg", dato2, tid2);
        arrangementer.add(skirenn);
        arrangementer.add(sykkelritt);
        arrangementer.add(lop);
        arrangementer.add(skirenn2);

        resultat_paameldingListe.add(resultat_paamelding);
    }

    @Test
    void filtrerArrangementerEtterTypeTest() {
        ArrayList<Arrangement> arrangement1 = new ArrayList<>();
        arrangement1.add(arrangementer.get(0));
        arrangement1.add(arrangementer.get(3));
        ArrayList<Arrangement> arrangement2 = new ArrayList<>();
        arrangement2.add(arrangementer.get(1));
        ArrayList<Arrangement> arrangement3 = new ArrayList<>();
        arrangement3.add(arrangementer.get(2));

        assertEquals(arrangement1, filtrerArrangementerEtterType(arrangementer, "Skirenn"));
        assertEquals(arrangement2, filtrerArrangementerEtterType(arrangementer, "Sykkelritt"));
        assertEquals(arrangement3, filtrerArrangementerEtterType(arrangementer, "Løp"));
    }

    @Test
    void getPaameldingerTest() {
        assertEquals(resultat_paamelding, arrangementer.get(0).getPaameldinger().get(0));
    }
    @Test
    void setResultatTest() {
        arrangementer.get(1).setResultat(resultat_paamelding);
        assertEquals(resultat_paamelding, arrangementer.get(1).getPaameldinger().get(0));
    }
    @Test
    void meldPaaEnBrukerTest() {
        arrangementer.get(2).meldPaaEnBruker(brukerType);
        assertEquals(brukerType, arrangementer.get(2).getPaameldinger().get(0).getUtoover());
    }

}