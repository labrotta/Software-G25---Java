package controller;

import Model.Arrangement;
import de.saxsys.javafx.test.JfxRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

@RunWith(JfxRunner.class)
class OpprettArrangementControllerTest {

    private static LocalDateTime datoConvert(String datoS, String tidS) {
        LocalDate dato = LocalDate.parse(datoS);
        LocalTime tid = LocalTime.parse(tidS);
        return LocalDateTime.of(dato, tid);
    }

    @Mock
    private ArrayList<Arrangement> ListNyArrangement;

    @InjectMocks
    private OpprettArrangementController oac = new OpprettArrangementController();

    @Test
    void lagArrangement() throws FeilTidInput {

    }

    @Test
    void textTilLocalTime() {

    }

    @Test
    void isNumeric() {
        {

        }
    }

    @Test
    void testLagArrangement() {
    }
}