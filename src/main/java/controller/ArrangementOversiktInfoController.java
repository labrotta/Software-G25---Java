package controller;

import Model.Arrangement;
import Model.ArrangementKlasser.Ritt;
import data.DataHandlerSQL;
import Model.ArrangementVisBruker;
import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
import Model.BrukerType;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import main.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collector;

public class ArrangementOversiktInfoController {
    static String arrangementInfoPaameldt;
    private BrukerType innloggetBruker = ForsideController.getInnloggetBruker();

    @FXML
    private TableView<ArrangementVisBruker> arrangementVisBrukerTableView;
    @FXML
    private TableColumn<ArrangementVisBruker, String> stedTableColumn, navnTableColumn, datoTableColumn;
    @FXML
    private Text arrangementTypeTextField;
    @FXML
    private Button tilbakeButton, slettBrukerId;
    @FXML
    private Label brukerID;

    public void initialize() throws SQLException {
        brukerID.setText(innloggetBruker.getFornavn());

        ArrayList<ArrangementVisBruker> sqlList = DataHandlerSQL.VisBrukerePrArrangement(arrangementInfoPaameldt);
        ObservableList<ArrangementVisBruker> VisbrukerArragement = FXCollections.observableArrayList(sqlList);

        for (ArrangementVisBruker liste : VisbrukerArragement) {
            arrangementVisBrukerTableView.getItems().add(liste);
        }


        if (innloggetBruker instanceof Admin || innloggetBruker instanceof ArrangementAnsvarlig){
            slettBrukerId.setVisible(true);
        } else {
            slettBrukerId.setVisible(false);
        }

        stedTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getBrukerUnikID()));
        navnTableColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getStartTid()));
        datoTableColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getSluttTid()));
        tilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ArrangementOversiktView.fxml"));
        slettBrukerId.setOnAction(actionEvent -> {
            DataHandlerSQL.SlettBrukerArrangement(arrangementVisBrukerTableView.getSelectionModel().getSelectedItem().getBrukerUnikID());
            arrangementVisBrukerTableView.getItems().clear();
            try {
                initialize();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}