package controller;

import Model.BrukerKlasser.Medlem;
import Model.BrukerType;
import org.junit.jupiter.api.Test;

import static controller.ForsideController.getInnloggetBruker;
import static controller.ForsideController.setInnloggetBruker;
import static org.junit.jupiter.api.Assertions.*;

class ForsideControllerTest {


    BrukerType medlem = new Medlem("Roger", "Hansen");

    @Test
    public void setInnloggetBrukerTest(){
        setInnloggetBruker(medlem);
        assertEquals(medlem, getInnloggetBruker());
    }

}