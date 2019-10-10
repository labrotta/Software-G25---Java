package Model;

import Model.BrukerKlasser.Bruker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBrukerTemplate {

    @Test
    public void testAaLageBruker(){
        Bruker testBruker = new Bruker("Test", "Testesen");
        assertEquals("Test", testBruker.getForNavn());
        assertEquals("Testesen", testBruker.getEtternavn());
    }
}
