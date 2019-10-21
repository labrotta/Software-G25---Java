package Controller;

import Model.Arrangement;
import Model.ArrangementKlasser.Lop;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import Model.BrukerType;
import Model.ModelBruker;
import data.DataHandlerSQL;
import data.InnloggetBruker;
import data.DataHandler;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import main.Main;

import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.EventListener;
import java.util.stream.Stream;

public class ArrangementOversiktController {

    static String arrangementType;
    private BrukerType innloggetBruker = BrukerController.getInnloggetBruker().getInnloggetBruker();

    @FXML private TableView<Arrangement> arrangementTableView;
    @FXML private TableColumn<Arrangement, String> stedTableColumn, navnTableColumn, datoTableColumn;
    @FXML private Text arrangementTypeTextField;
    @FXML private Button tilbakeButton,eksArrangementInfo;
    @FXML private Label brukerID;

    public void initialize() {
        brukerID.setText(innloggetBruker.getForNavn());
       final ObservableList<Arrangement> sqlList = DataHandlerSQL.sjekkSQLType(arrangementType);


        for (Arrangement liste : sqlList) {
            arrangementTableView.getItems().add(liste);
        }
        arrangementTypeTextField.setText(arrangementType);

        stedTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSted()));
        navnTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNavn()));
        datoTableColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getDatoOgTid()));
        tilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ViewFrontPage.fxml"));
        eksArrangementInfo.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ArrangementOversiktViewInfo.fxml"));
    }
}