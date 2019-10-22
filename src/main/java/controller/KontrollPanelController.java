package controller;

import Model.BrukerType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;

public class KontrollPanelController {

    @FXML
    private Button TilbakeButton;

    @FXML
    private Label BrukerNavnLabel;

    public void initialize() {
        TilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ViewFrontPage.fxml"));

        BrukerNavnLabel.setText("Test");

        BrukerType innloggetBruker = ForsideController.getInnloggetBruker();

        BrukerNavnLabel.setText(innloggetBruker.getForNavn());
    }
}
