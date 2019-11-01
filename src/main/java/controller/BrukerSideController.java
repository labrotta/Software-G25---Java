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

    public void initialize() {

        BrukerType innloggetBruker = ForsideController.getInnloggetBruker();

        TilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ViewFrontPage.fxml"));
        redigerFornavnButton.setOnAction(actionEvent -> rediger(dialog, "fornavn", fornavnLabel.getText(), innloggetBruker));
        redigerEtternavnButton.setOnAction(actionEvent -> rediger(dialog, "etternavn", etternavnLabel.getText(), innloggetBruker));
        redigerEpostButton.setOnAction(actionEvent -> rediger(dialog, "epost", epostLabel.getText(),innloggetBruker ));

        fornavnLabel.setText("Test");

        fornavnLabel.setText(innloggetBruker.getFornavn());
        etternavnLabel.setText(innloggetBruker.getEtternavn());
        epostLabel.setText(innloggetBruker.getEpost());
    }

    public void rediger(Stage dialog, String hvaSomSkalRedigeres, String originalString, BrukerType bruker) {

        final Stage dialog = new Stage();
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

        lagreButton.setOnAction(actionEvent -> lagre(hvaSomSkalRedigeres, nyTekstTextField.getText(), bruker));
    }

    public void lagre(String hvaSomSkalRedigeres, String nyString, BrukerType bruker) {
        switch (hvaSomSkalRedigeres){
            case "fornavn": bruker.setForNavn(nyString);
            avsluttVindu();
            break;
            case "etternavn": bruker.setEtternavn(nyString);
            avsluttVindu();
            break;
            case "epost": bruker.setEpost(nyString);
            avsluttVindu();
            break;
        }
    }

    private void avsluttVindu() {
        dialog.close();
        initialize();
    }
}
