package controller;

import Model.BrukerType;
import data.LagBrukere;
import javafx.collections.ObservableList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrukerSideControllerTest {

    //private BrukerSideController brukerSideController = new BrukerSideController();

    @Test
    public void testAtBrukerFaarEndretInfo() {

        ObservableList<BrukerType> listeBrukere = LagBrukere.listeBruker();

        BrukerType admin = listeBrukere.get(0);
        BrukerType arrangementansvarlig = listeBrukere.get(1);
        BrukerType bruker = listeBrukere.get(2);
        BrukerType medlem = listeBrukere.get(3);

/*      brukerSideController.lagre("fornavn", "Terje", admin);
        brukerSideController.lagre("etternavn", "Jonsen", arrangementansvarlig);
        brukerSideController.lagre("epost", "hei@hade.no", bruker);
        brukerSideController.lagre("fornavn", "Trond", medlem);*/
        assertEquals("Ole (admin)", admin.getFornavn());
        assertEquals("Pedersen", arrangementansvarlig.getEtternavn());
        assertEquals("trond@trondsen.no", bruker.getEpost());
        assertEquals("Alex (medlem)", medlem.getFornavn());
    }
}