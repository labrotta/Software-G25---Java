package controller;

import Model.Arrangement;
import Model.BrukerType;
import Model.paamelding_resultat.Resultat_Paamelding;
import data.DataHandlerSQL;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Main;

import java.util.ArrayList;

public class BrukerSideController {

    @FXML private Button TilbakeButton, redigerFornavnButton, redigerEtternavnButton, redigerEpostButton;
    @FXML private Label fornavnLabel, etternavnLabel, epostLabel;
    @FXML private TableView<Resultat_Paamelding> resultatTableView;
    @FXML private TableColumn<Resultat_Paamelding, String> datoTableColumn, StedTableColumn, brukerSideTabellArrangment;

    Stage dialog;

    public void initialize() {
        BrukerType innloggetBruker = ForsideController.getInnloggetBruker();

        ArrayList<Arrangement> arrangementer= DataHandlerSQL.hentArrangementerMedPaameldinger();
        ArrayList<Resultat_Paamelding> resultaterForBruker = innloggetBruker.hentResultaterForBruker(arrangementer);

        ObservableList<Resultat_Paamelding> listeResultat = FXCollections.observableArrayList(resultaterForBruker);

        TilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ViewFrontPage.fxml"));
        redigerFornavnButton.setOnAction(actionEvent -> rediger(  "fornavn", fornavnLabel.getText(), innloggetBruker));
        redigerEtternavnButton.setOnAction(actionEvent -> rediger(  "etternavn", etternavnLabel.getText(), innloggetBruker));
        redigerEpostButton.setOnAction(actionEvent -> rediger(  "epost", epostLabel.getText(),innloggetBruker ));

        fornavnLabel.setText("Test");
        fornavnLabel.setText(innloggetBruker.getFornavn());
        etternavnLabel.setText(innloggetBruker.getEtternavn());
        epostLabel.setText(innloggetBruker.getEpost());

        for (Resultat_Paamelding liste : listeResultat) {
            resultatTableView.getItems().add(liste);
        }

        //datoTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getArrangement().getDato().toString()));
        StedTableColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getArrangement().getSted()));
        brukerSideTabellArrangment.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getArrangement().getSted()));
    }


    public void rediger( String hvaSomSkalRedigeres, String originalString, BrukerType bruker) {

        dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);

        TextField nyTekstTextField = new TextField(originalString);
        dialogVbox.getChildren().add(nyTekstTextField);
        Button lagreButton = new Button("Lagre");
        dialogVbox.getChildren().add(lagreButton);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);

        dialog.setScene(dialogScene);
        dialog.setTitle("Rediger " + hvaSomSkalRedigeres);
        dialog.show();

        lagreButton.setOnAction(actionEvent -> lagre( hvaSomSkalRedigeres, nyTekstTextField.getText(), bruker));
    }

    public void lagre( String hvaSomSkalRedigeres, String nyString, BrukerType bruker) {
        switch (hvaSomSkalRedigeres){
            case "fornavn": bruker.setForNavn(nyString);
            oppdaterInfo();
            break;
            case "etternavn": bruker.setEtternavn(nyString);
            oppdaterInfo();
            break;
            case "epost": bruker.setEpost(nyString);
            oppdaterInfo();
            break;
        }
    }

    //Denne er laget for å skille GUI og kjernefunksjonalitet. Dermed er
    //metoden lagre() enkel å teste.
    private void oppdaterInfo() {
        if (dialog == null) {
            return;
        } else {
            dialog.close();
            initialize();
        }
    }
}
