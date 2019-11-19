package Model;

import Model.ArrangementKlasser.Lop;
import Model.ArrangementKlasser.Renn;
import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
import Model.BrukerKlasser.Bruker;
import Model.BrukerKlasser.Medlem;
import Model.paamelding_resultat.Resultat_Paamelding;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class BrukerTypeTest {
    BrukerType bruker = new Bruker("Reidar", "Reidarsen", "test@testesen.no");
    BrukerType medlem = new Medlem("Arne", "Arntsen", "test@testesen.no");
    BrukerType admin = new Admin("Rune", "Runarsen");
    BrukerType arrangementansvarlig = new ArrangementAnsvarlig("John", "Fredriksen");

    Arrangement tisternNed = new Renn("Tistern ned", "Halden", LocalDate.of(2019, 5, 5));
    Arrangement tisternOpp = new Lop("Tistern opp", "Halden", LocalDate.of(2017, 5, 5));

    Resultat_Paamelding resultat1 = new Resultat_Paamelding(medlem, LocalTime.of(1, 30), LocalTime.of(1, 50), 3);
    Resultat_Paamelding resultat2 = new Resultat_Paamelding(bruker, LocalTime.of(1, 30), LocalTime.of(2, 0), 4);
    Resultat_Paamelding resultat3 = new Resultat_Paamelding(admin, LocalTime.of(1, 30), LocalTime.of(2, 10), 5);
    Resultat_Paamelding resultat4 = new Resultat_Paamelding(arrangementansvarlig, LocalTime.of(1, 30), LocalTime.of(2, 20), 6);


    @Test
    public void testAaLageBruker(){
        assertEquals("Reidar", bruker.getFornavn());
        assertEquals("Reidarsen", bruker.getEtternavn());
    }

    @Test
    public void testAaLageMedlem(){
        assertEquals("Arne", medlem.getFornavn());
        assertEquals("Arntsen", medlem.getEtternavn());
    }

    @Test
    void erAdminEllerAATest() {
        assertFalse(bruker.erAdminEllerAA());
        assertFalse(medlem.erAdminEllerAA());
        assertTrue(admin.erAdminEllerAA());
    }

    @Test
    void brukerErMedlemTest(){

        assertFalse(bruker.brukerErMedlem());
        assertTrue(medlem.brukerErMedlem());
        assertTrue(arrangementansvarlig.brukerErMedlem());
        assertTrue(admin.brukerErMedlem());
    }

    @Test
    void hentNavnOgTypeTest() {
        assertEquals("Arne (Medlem)", medlem.hentNavnOgType());
    }

    @Test
    void setFornavnTest(){
        medlem.setForNavn("Per");
        assertEquals("Per", medlem.getFornavn());
    }

    @Test
    void setEtternavnTest(){
        medlem.setEtternavn("Hansen");
        assertEquals("Hansen", medlem.getEtternavn());
    }

    @Test
    void setEpostTest(){
        medlem.setEpost("per@hansen.no");
        assertEquals("per@hansen.no", medlem.getEpost());
    }

    @Test
    void hentResultaterForBrukerTest(){

        ArrayList<Arrangement> arrangementer = new ArrayList<>();
        arrangementer.add(tisternNed);
        arrangementer.add(tisternOpp);

        tisternNed.setResultat(resultat1);
        tisternNed.setResultat(resultat2);
        tisternNed.setResultat(resultat3);

        ArrayList<Resultat_Paamelding> detEneResultatet = new ArrayList<>();
        detEneResultatet.add(resultat2);

        assertEquals(detEneResultatet, bruker.hentResultaterForBruker(arrangementer));
    }
}
