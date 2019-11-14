package controller;

import Model.BrukerType;
import Model.paamelding_resultat.Resultat_Paamelding;
import data.DataHandlerSQL;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import main.Main;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class NyttResultatController {

    @FXML private ChoiceBox<BrukerType> velgUtooverChoiceBox;
    @FXML private TextField startTidTextField, sluttTidTextField, plasseringTextField;
    @FXML private Button tilbakeButton, leggInnResultatButton;
    private ArrayList<BrukerType> medlemmer = data.DataHandlerSQL.hentBrukere();

    static BrukerType valgtBruker;

    public void initialize() {
        ObservableList<BrukerType> medlemmerObserveableList = FXCollections.observableArrayList(medlemmer);
        velgUtooverChoiceBox.setItems(medlemmerObserveableList);


        velgUtooverChoiceBox.setOnAction(click -> {
            valgtBruker = velgUtooverChoiceBox.getSelectionModel().getSelectedItem();
            System.out.println(valgtBruker);

        });

        leggInnResultatButton.setOnAction(click -> {
            leggInnResultat();
        });

        tilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ResultatListeView.fxml"));
    }

    private void leggInnResultat() {
        try {
            LocalTime startTid = LocalTime.parse(startTidTextField.getText());
            LocalTime sluttTid = LocalTime.parse(sluttTidTextField.getText());

        int plassering = Integer.parseInt(plasseringTextField.getText());

        Resultat_Paamelding resultat_paamelding = new Resultat_Paamelding(
                valgtBruker,
                startTid,
                sluttTid,
                plassering);

        ResultatListeController.valgtArrangement.setResultat(resultat_paamelding);
        DataHandlerSQL.leggInnResultat(
                ResultatListeController.valgtArrangement.getId(),
                resultat_paamelding
        );
        } catch (DateTimeParseException dtpe){
            dtpe.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Feil input!");
            alert.setHeaderText(null);
            alert.setContentText("Tidene må skrives på formatet hh:mm, eller hh:mm:ss");
            alert.showAndWait();
        }
    }
}
