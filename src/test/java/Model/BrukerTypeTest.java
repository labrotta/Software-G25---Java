package Model;

import Model.BrukerKlasser.Bruker;
import Model.BrukerKlasser.Medlem;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BrukerTypeTest {
    Bruker bruker = new Bruker("Test", "Testesen", "test@testesen.no");
    BrukerType medlem = new Medlem("Test", "Testesen", "test@testesen.no");

    @Test
    public void testAaLageBruker(){
        assertEquals("Test", bruker.getFornavn());
        assertEquals("Testesen", bruker.getEtternavn());
    }

    @Test
    public void testAaLageMedlem(){
        assertEquals("Test", medlem.getFornavn());
        assertEquals("Testesen", medlem.getEtternavn());
    }

    @Test
    void erAdminEllerAA() {
        assertFalse(bruker.erAdminEllerAA());
        assertFalse(medlem.erAdminEllerAA());
    }

    @Test
    void brukerErMedlemTest(){

        BrukerType medlem = new Medlem("Roger", "Johnser");
        BrukerType bruker = new Bruker("Frode", "Pedersen");

        assertTrue(medlem.brukerErMedlem());
        assertFalse(bruker.brukerErMedlem());
    }

    @Test
    void hentNavnOgTypeTest() {
        assertEquals("Test (Medlem)", medlem.hentNavnOgType());
    }
}
