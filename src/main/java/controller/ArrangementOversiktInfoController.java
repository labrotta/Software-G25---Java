package controller;

import Model.ArrangementVisBruker;
import Model.BrukerType;
import Data.DataHandlerSQL;
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


public class ArrangementOversiktInfoController {
    static String arrangementType;
    private BrukerType innloggetBruker = ForsideController.getInnloggetBruker();

    //Sett denne til å sende inn  arrangementnavn fra ArrangemnetOversiktController;
    private String arrangementInfoPaameldt = "Løp 3";

    @FXML
    private TableView<ArrangementVisBruker> arrangementVisBrukerTableView;
    @FXML private TableColumn<ArrangementVisBruker, String> stedTableColumn, navnTableColumn, datoTableColumn;
    @FXML private Text arrangementTypeTextField;
    @FXML private Button tilbakeButton,slettBrukerId;
    @FXML private Label brukerID;
    public void initialize() throws SQLException {
        brukerID.setText(innloggetBruker.getForNavn());

        final ObservableList<ArrangementVisBruker> sqlList = DataHandlerSQL.VisBrukerePrArrangement(arrangementInfoPaameldt);
        for (ArrangementVisBruker liste : sqlList) {
            arrangementVisBrukerTableView.getItems().add(liste);
        }

        stedTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getBrukerUnikID()));
        navnTableColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getStartTid()));
        datoTableColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getSluttTid()));
        tilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ArrangementOversiktView.fxml"));
        slettBrukerId.setOnAction(actionEvent -> {
            DataHandlerSQL.SlettBrukerArrangement(String.valueOf(innloggetBruker));
            arrangementVisBrukerTableView.getItems().clear();
            try {
                initialize();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
