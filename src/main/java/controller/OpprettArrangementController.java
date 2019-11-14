package controller;

import data.DataHandlerSQL;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.Main;

import java.time.LocalDate;
import java.time.LocalTime;



public class OpprettArrangementController {

    @FXML
    Button tilbakeButton, lagArrangementButton;

    @FXML
    ChoiceBox<String> velgTypeArrangementChoiceBox,valgTime;

    @FXML
    TextField navnTextField, stedTextField, tidTextField,valgMin;

    @FXML
    DatePicker datoDatePicker;

    public void initialize() {
        valgTime.setItems(FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"));
        valgTime.getSelectionModel().select(9);
        lagArrangementButton.setDisable(true);
        valgMin.textProperty().addListener((observable, oldValue, newValue) -> {
            lagArrangementButton.setDisable(false);
            if (!newValue.matches("\\d*"))
                valgMin.setText(newValue.replaceAll("[^\\d]", ""));

            if (valgMin.getLength() > 2)
                valgMin.deleteNextChar();

            String minCheck = valgMin.getText();
            lagArrangementButton.setDisable(false);
            if((minCheck.startsWith("6")) || (minCheck.startsWith("7")) || (minCheck.startsWith("8")) || (minCheck.startsWith("9")))
                valgMin.setText("5");

            if(valgMin.getLength() < 1){
                lagArrangementButton.setDisable(true);
            }
        });

        tilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ViewFrontPage.fxml"));
        velgTypeArrangementChoiceBox.setItems(FXCollections.observableArrayList("Skirenn","Sykkelritt","Løp"));
        velgTypeArrangementChoiceBox.getSelectionModel().selectFirst();
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
        //String text = String.valueOf(tidTextField.getText());

        if(valgMin.getLength() == 1)
            valgMin.setText("0"+valgMin.getText());

        LocalTime tid = LocalTime.parse(valgTime.getSelectionModel().getSelectedItem()+":"+valgMin.getText());
        System.out.println(tid);
        //LocalDateTime datoOgTid = LocalDateTime.of(dato, tid);
        DataHandlerSQL.opprettArrangement(navn,sted,String.valueOf(dato), String.valueOf(tid),arrangementType);
    }

/*    public static LocalTime textTilLocalTime(String text) throws FeilTidInput {

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
men om du
        return str.chars().allMatch(Character::isDigit);

    }*/

}
