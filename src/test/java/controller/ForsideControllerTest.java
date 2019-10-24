package controller;

import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
import Model.BrukerKlasser.Bruker;
import Model.BrukerKlasser.Medlem;
import Model.BrukerType;
import de.saxsys.javafx.test.JfxRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


@RunWith(JfxRunner.class)
class ForsideControllerTest {

    @Mock
    BrukerType admin = new Admin("Test", "Admin");
    BrukerType medlem = new Medlem("Test", "Medlem");
    BrukerType arrangementansvarlig = new ArrangementAnsvarlig("Test", "Arrangementansvarlig");

    @InjectMocks
    ForsideController forsideController = new ForsideController();

    @Test
    void innloggingsTest(){
        forsideController.loggInn(admin);
        forsideController.loggInn(medlem);
        forsideController.loggInn(arrangementansvarlig);
    }

    @Test
    void getInnloggetBruker() {
    }
}