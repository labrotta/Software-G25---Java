package controller;

import Model.BrukerType;
import Model.ModelBruker;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrukerSideControllerTest {

    private BrukerSideController brukerSideController = new BrukerSideController();

    @Test
    public void testAtBrukerFaarEndretInfo() {
        JFXPanel jfxPanel = new JFXPanel();
        ObservableList<BrukerType> listeBrukere = ModelBruker.listeBruker();

        BrukerType admin = listeBrukere.get(0);
        BrukerType arrangementansvarlig = listeBrukere.get(1);
        BrukerType bruker = listeBrukere.get(2);
        BrukerType medlem = listeBrukere.get(3);

        brukerSideController.lagre("fornavn", "Terje", admin);
        brukerSideController.lagre("etternavn", "Jonsen", arrangementansvarlig);
        brukerSideController.lagre("epost", "hei@hade.no", bruker);
        brukerSideController.lagre("fornavn", "Trond", medlem);
        assertEquals("Terje", admin.getFornavn());
        assertEquals("Jonsen", arrangementansvarlig.getEtternavn());
        assertEquals("hei@hade.no", bruker.getEpost());
        assertEquals("Trond", medlem.getFornavn());
    }
}