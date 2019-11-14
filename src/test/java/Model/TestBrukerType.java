package Model;

import Model.BrukerKlasser.Bruker;
import Model.BrukerKlasser.Medlem;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class TestBrukerType {
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
}
