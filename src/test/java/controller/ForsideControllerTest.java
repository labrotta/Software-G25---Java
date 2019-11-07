package controller;

import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
import Model.BrukerKlasser.Medlem;
import Model.BrukerType;
import de.saxsys.javafx.test.JfxRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;


class ForsideControllerTest {


    BrukerType admin = new Admin("Test", "Admin");
    BrukerType medlem = new Medlem("Test", "Medlem");
    BrukerType arrangementansvarlig = new ArrangementAnsvarlig("Test", "Arrangementansvarlig");


    ForsideController forsideController = new ForsideController();

    @Test
    public void innloggingsTest(){
        assertEquals(admin, forsideController.loggInn(admin));
        assertEquals(medlem, forsideController.loggInn(medlem));
        assertEquals(arrangementansvarlig, forsideController.loggInn(arrangementansvarlig));
    }

    @Test
    public void erBrukerenAdminEllerArrangementansvarlig(){
        assertEquals(true, forsideController.brukerErAdminEllerArrangementansvarlig(admin));
        assertEquals(true, forsideController.brukerErAdminEllerArrangementansvarlig(arrangementansvarlig));
        assertEquals(false, forsideController.brukerErAdminEllerArrangementansvarlig(medlem));
    }

    @Test
    void getInnloggetBruker() {
    }
}