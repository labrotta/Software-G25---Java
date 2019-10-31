package Model;

import Model.BrukerKlasser.Bruker;
import Model.BrukerKlasser.Medlem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBrukerType {

    @Test
    public void testAaLageBruker(){
        Bruker testBruker = new Bruker("Test", "Testesen", "test@testesen.no");
        assertEquals("Test", testBruker.getFornavn());
        assertEquals("Testesen", testBruker.getEtternavn());
    }

    @Test
    public void testAaLageMedlem(){
        BrukerType testBruker = new Medlem("Test", "Testesen", "test@testesen.no");
        assertEquals("Test", testBruker.getFornavn());
        assertEquals("Testesen", testBruker.getEtternavn());
    }
}
