package controller;

import Model.BrukerType;
import Model.ModelBruker;
import de.saxsys.javafx.test.JfxRunner;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.runner.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JfxRunner.class)
class BrukerSideControllerTest {

    @InjectMocks
    private BrukerSideController brukerSideController = new BrukerSideController();

    @Test
    public void testAtBrukerFaarEndretInfo() {
        JFXPanel jfxPanel = new JFXPanel();
        ObservableList<BrukerType> listeBrukere = ModelBruker.listeBruker();

        BrukerType admin = listeBrukere.get(0);
        BrukerType arrangementansvarlig = listeBrukere.get(1);
        BrukerType bruker = listeBrukere.get(2);
        BrukerType medlem = listeBrukere.get(3);

        Stage stage = new Stage();

        brukerSideController.rediger(stage, "fornavn", admin.getFornavn(), admin);
        brukerSideController.lagre("fornavn", "Terje", admin);
        assertEquals("Terje", admin.getFornavn());
    }
}