package Controller;

import Data.DataHandler;
import Model.Arrangement;
import Model.BrukerType;
import Data.*;
import data.DataHandlerSQL;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import main.Main;

import java.sql.SQLException;

public class ArrangementOversiktController {

    static String arrangementType;
    private BrukerType innloggetBruker = ForsideController.getInnloggetBruker();
    private String BrukerNavn = String.valueOf(ForsideController.getInnloggetBruker());

    @FXML private TableView<Arrangement> arrangementTableView;
    @FXML private TableColumn<Arrangement, String> stedTableColumn, navnTableColumn, datoTableColumn;
    @FXML private Text arrangementTypeTextField;
    @FXML private Button tilbakeButton,eksArrangementInfo;
    @FXML private Label brukerID;

    public void initialize() throws SQLException {
        //Denne Legger inn en ny bruker til Arrangement bruker String Arrangementnavn og "BrukerID"
        DataHandlerSQL.PaaMeldingBrukerArrangement("Løp 3",BrukerNavn);

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