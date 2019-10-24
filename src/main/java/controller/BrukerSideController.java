package controller;

import Model.BrukerType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;

public class BrukerSideController {

    @FXML
    private Button TilbakeButton;

    @FXML
    private Label fornavnLabel, etternavnLabel, epostLabel;

    public void initialize() {
        TilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ViewFrontPage.fxml"));

        fornavnLabel.setText("Test");

        BrukerType innloggetBruker = ForsideController.getInnloggetBruker();

        fornavnLabel.setText(innloggetBruker.getFornavn());
        etternavnLabel.setText(innloggetBruker.getEtternavn());
        epostLabel.setText(innloggetBruker.getEpost());
    }
}
