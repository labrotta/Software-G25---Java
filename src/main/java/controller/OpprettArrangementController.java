package controller;

import Model.Arrangement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.Main;

public class OpprettArrangementController {

    @FXML
    Button tilbakeButton, lagArrangementButton;

    @FXML
    ChoiceBox<Arrangement> velgTypeArrangementChoiceBox;

    @FXML
    TextField navnTextField;

    @FXML
    DatePicker datoDatePicker;

    public void initialize(){
        tilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ViewFrontPage.fxml"));


    }
}
