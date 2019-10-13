package Controller;

import Model.Arrangement;
import data.DataHandler;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ArrangementOversiktController {

    @FXML
    private ListView<Arrangement> arrangementListView;

    public void initialize(){
        ObservableList<Arrangement> arrangementList = DataHandler.getArrangementer();

        for (Arrangement arrangement:
             arrangementList) {
            arrangementListView.getItems().add(arrangement);
        }
    }
}
