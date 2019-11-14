package Model.paamelding_resultat;

import Model.BrukerType;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class Resultat_PaameldingTest {

    @Test
    void hentTidBruktTest() {
        BrukerType person = new BrukerType("Test", "Testesen");
        LocalTime tid = LocalTime.of(12, 30, 28);
        LocalTime tid2 = LocalTime.of(12, 45, 38);
        Resultat_Paamelding resultat_paamelding = new Resultat_Paamelding(person, tid, tid2, 4);


        assertEquals(15, resultat_paamelding.hentTidBrukt());
    }
}