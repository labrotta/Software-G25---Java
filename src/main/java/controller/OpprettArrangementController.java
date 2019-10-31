package controller;

import Model.Arrangement;
import Model.ArrangementKlasser.Lop;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.Main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OpprettArrangementController {

    @FXML
    Button tilbakeButton, lagArrangementButton;

    @FXML
    ChoiceBox<String> velgTypeArrangementChoiceBox;

    @FXML
    TextField navnTextField, stedTextField, tidTextField;

    @FXML
    DatePicker datoDatePicker;

    public void initialize() {
        tilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ViewFrontPage.fxml"));
        velgTypeArrangementChoiceBox.setItems(FXCollections.observableArrayList("Skirenn","Sykkelritt","Løp"));
        lagArrangementButton.setOnAction(actionEvent -> {
            try {
                lagArrangement(velgTypeArrangementChoiceBox.getSelectionModel().getSelectedItem());
            } catch (FeilTidInput feilTidInput) {
                feilTidInput.printStackTrace();
            }
        });
    }

    public void lagArrangement(String arrangementType) throws FeilTidInput {
        String navn, sted;
        navn = navnTextField.getText();
        sted = stedTextField.getText();
        LocalDate dato = datoDatePicker.getValue();
        String text = String.valueOf(tidTextField.getText());
        LocalTime tid = textTilLocalTime(text);
        LocalDateTime datoOgTid = LocalDateTime.of(dato, tid);

        if (arrangementType.equals("Skirenn")){
            Arrangement nyttSkiRenn = new Renn(navn, sted, datoOgTid);
        }
        else if (arrangementType.equals("SykkelRitt")){
            Arrangement nyttSykkelRitt = new Ritt(navn, sted, datoOgTid);
        }
        else if (arrangementType.equals("Løp")){
            Arrangement nyttLop = new Lop(navn, sted, datoOgTid);
        }
    }

    public static LocalTime textTilLocalTime(String text) throws FeilTidInput {


        // inputkontroll
        if(text.length() != 5){
            throw new FeilTidInput("For få eller for mange tegn. Bruk: hh:mm");
        }
        else if (!isNumeric(text.substring(0,2))){
            throw new FeilTidInput("Det mangler et tall på rett plass");
        }
        else if (!text.substring(2, 3).equals(":")){
            throw new FeilTidInput("Det mangler en \":\" på rett plass");
        }
        else if (!isNumeric(text.substring(3,5))){
            throw new FeilTidInput("Det mangler en et tall på rett plass");
        }
        int timer = Integer.parseInt(text.substring(0, 1));
        int minutter = Integer.parseInt(text.substring(3, 4));

        return LocalTime.of(timer, minutter);
    }
    public static boolean isNumeric(final String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        return str.chars().allMatch(Character::isDigit);

    }
}
