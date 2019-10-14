package Controller;

import Model.Arrangement;
import Model.ArrangementKlasser.Lop;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import data.DataHandler;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ArrangementOversiktController {

    static String arrangementType;

    @FXML
    private TableView<Arrangement> arrangementTableView;

    @FXML
    private TableColumn<Arrangement, String> stedTableColumn, navnTableColumn;

    @FXML
    private Text arrangementTypeTextField;

    public void initialize(){
        ObservableList<Arrangement> arrangementList = DataHandler.getArrangementer();

        arrangementTypeTextField.setText(arrangementType);

        if (arrangementType.equals("Skirenn")) {
            for (Arrangement arrangement : arrangementList) {
                if (arrangement instanceof Renn)
                arrangementTableView.getItems().add(arrangement);
            }
        }
        if (arrangementType.equals("Sykkelritt")) {
            for (Arrangement arrangement : arrangementList) {
                if (arrangement instanceof Ritt)
                    arrangementTableView.getItems().add(arrangement);
            }
        }
        if (arrangementType.equals("Løp")) {
            for (Arrangement arrangement : arrangementList) {
                if (arrangement instanceof Lop)
                    arrangementTableView.getItems().add(arrangement);
            }
        }


        stedTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSted()));
        navnTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNavn()));
    }

}
