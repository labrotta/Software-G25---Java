package Model;

import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
import Model.BrukerKlasser.Bruker;
import Model.BrukerKlasser.Medlem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BrukerTypeTest {
    BrukerType bruker = new Bruker("Reidar", "Reidarsen", "test@testesen.no");
    BrukerType medlem = new Medlem("Arne", "Arntsen", "test@testesen.no");
    BrukerType admin = new Admin("Rune", "Runarsen");
    BrukerType arrangementansvarlig = new ArrangementAnsvarlig("John", "Fredriksen");

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

    }
}
