package controller;

import Model.Arrangement;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import Model.BrukerKlasser.Medlem;
import Model.BrukerType;
import de.saxsys.javafx.test.JfxRunner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JfxRunner.class)
class ArrangementOversiktControllerTest{


    @Mock
    private ObservableList<Arrangement> list = FXCollections.observableArrayList();

    // Lage mock database
    @InjectMocks
    private ArrangementOversiktController arrangementOversiktController = new ArrangementOversiktController();


    @Test
    void fyllTabellenTest(){
        list.add(new Ritt("Birken", "Lillehammer"));
        list.add(new Renn("Kulås-sprinten", "Sarpsborg"));

        TableView<Arrangement> tabell = new TableView<>();
        arrangementOversiktController.fyllTabellen(list, tabell);
        assertEquals("Birken", tabell.getItems().get(0).getNavn());
        assertEquals("Kulås-sprinten", tabell.getItems().get(1).getNavn());
    }

    @Test
    void medlemKanMeldeSegPaaTest(){
        Arrangement birkebeineren = new Ritt("Birkebeineren", "Lillehammer");
        BrukerType jon = new Medlem("Jon", "Jonsen");
        arrangementOversiktController.paamelding(birkebeineren, jon);
        assertEquals(jon, birkebeineren.getPaameldinger().get(0));

        //Skal også lage funksjonalitet for å teste at den feiler
    }


}
