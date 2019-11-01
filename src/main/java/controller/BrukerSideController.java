package controller;

import Model.BrukerKlasser.Bruker;
import Model.BrukerType;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Main;

public class BrukerSideController {

    @FXML
    private Button TilbakeButton, redigerFornavnButton, redigerEtternavnButton, redigerEpostButton;

    @FXML
    private Label fornavnLabel, etternavnLabel, epostLabel;

    Stage dialog;


    public void initialize() {

        BrukerType innloggetBruker = ForsideController.getInnloggetBruker();

        TilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ViewFrontPage.fxml"));
        redigerFornavnButton.setOnAction(actionEvent -> rediger(  "fornavn", fornavnLabel.getText(), innloggetBruker));
        redigerEtternavnButton.setOnAction(actionEvent -> rediger(  "etternavn", etternavnLabel.getText(), innloggetBruker));
        redigerEpostButton.setOnAction(actionEvent -> rediger(  "epost", epostLabel.getText(),innloggetBruker ));

        fornavnLabel.setText("Test");

        fornavnLabel.setText(innloggetBruker.getFornavn());
        etternavnLabel.setText(innloggetBruker.getEtternavn());
        epostLabel.setText(innloggetBruker.getEpost());


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
    //metoden lagre enkel å teste.
    private void oppdaterInfo() {
        if (dialog == null) {
            return;
        }
        dialog.close();
        initialize();
    }
}
