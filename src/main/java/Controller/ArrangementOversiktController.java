package Controller;

import Model.Arrangement;
import Model.ArrangementKlasser.Lop;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import data.DataHandler;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import main.Main;

public class ArrangementOversiktController {

    static String arrangementType;

    @FXML private TableView<Arrangement> arrangementTableView;
    @FXML private TableColumn<Arrangement, String> stedTableColumn, navnTableColumn, datoTableColumn;
    @FXML private Text arrangementTypeTextField;
    @FXML private Button tilbakeButton;

    public void initialize() {

        ObservableList<Arrangement> arrangementList = DataHandler.getArrangementer();
        arrangementTypeTextField.setText(arrangementType);

        //Refatoreiet kode
        for (Arrangement arrangement : arrangementList) {
            switch (arrangementType) {
                case "Skirenn":
                    if (arrangement instanceof Renn)
                        arrangementTableView.getItems().add(arrangement);
                    break;
                case "Sykkelritt":
                    if (arrangement instanceof Ritt)
                        arrangementTableView.getItems().add(arrangement);
                    break;
                case "Løp":
                    if (arrangement instanceof Lop)
                        arrangementTableView.getItems().add(arrangement);
                    break;
            }
        /*
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
        }*/

            stedTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSted()));
            navnTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNavn()));
            datoTableColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getDatoOgTid()));
            tilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ViewFrontPage.fxml"));
        }
    }
}
