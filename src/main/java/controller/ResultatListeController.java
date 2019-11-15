package controller;

import Model.Arrangement;
import Model.paamelding_resultat.Resultat_Paamelding;
import Model.BrukerType;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import main.Main;

public class ResultatListeController {
    public static Arrangement valgtArrangement;
    private BrukerType innloggetBruker = ForsideController.getInnloggetBruker();

    @FXML
    private TableView<Resultat_Paamelding> arrangementVisBrukerTableView;
    @FXML
    private TableColumn<Resultat_Paamelding, String> stedTableColumn, navnTableColumn, datoTableColumn, tidTableColumn;
    @FXML
    private Text arrangementTypeTextField;
    @FXML
    private Button tilbakeButton, leggInnResultatButton;
    @FXML
    private Label brukerID;

    public void initialize(){
        brukerID.setText(innloggetBruker.getFornavn());

        ObservableList<Resultat_Paamelding> resultaterArrayList = FXCollections.observableArrayList(valgtArrangement.getPaameldinger());

        for (Resultat_Paamelding etResultat : resultaterArrayList) {
            arrangementVisBrukerTableView.getItems().add(etResultat);
        }

        if (innloggetBruker.erAdminEllerAA()){
            leggInnResultatButton.setVisible(true);
        } else {
            leggInnResultatButton.setVisible(false);
        }

        //stedTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getArrangement().getNavn()));
        navnTableColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getUtoover().toString()));
        //datoTableColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().));
        tidTableColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().hentTidBrukt()));

        tilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ArrangementOversiktView.fxml"));

        leggInnResultatButton.setOnAction(actionEvent -> {
            Main.getInstance().changeScene("../View/NyttResultatView.fxml");
        });
    }
}