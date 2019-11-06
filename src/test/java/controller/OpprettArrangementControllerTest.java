package controller;

import Model.Arrangement;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import de.saxsys.javafx.test.JfxRunner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static controller.ArrangementOversiktController.arrangementType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setAllowComparingPrivateFields;
import static org.assertj.core.api.InstanceOfAssertFactories.list;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;

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
    }
}