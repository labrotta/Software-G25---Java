package controller;

import Model.Arrangement;
import de.saxsys.javafx.test.JfxRunner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TableView;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@RunWith(JfxRunner.class)
class ArrangementOversiktControllerTest{


    @Mock
    private ObservableList<Arrangement> list = FXCollections.observableArrayList();

    @InjectMocks
    private ArrangementOversiktController arrangementOversiktController = new ArrangementOversiktController();


    @Test
    void fyllTabellenTest(){
        JFXPanel jfxPanel = new JFXPanel();
        list.add(new Arrangement("Birken", "Lillehammer"));
        TableView<Arrangement> tabell = new TableView<>();
        arrangementOversiktController.fyllTabellen(list, tabell);
        Assert.assertEquals("Birken", tabell.getItems().get(0).getNavn());
    }


}
