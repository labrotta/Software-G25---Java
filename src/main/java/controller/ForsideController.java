package controller;

import Model.BrukerType;
import data.DataHandlerSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;

public class ForsideController {

    @FXML private ComboBox<BrukerType> brukerListe;
    @FXML private Button brukerLoggInn, BrukersideButton, skirennButton, lopButton, sykkelrittButton, lagArrangementButton;
    @FXML private Label valgtBrukerNavnLabel;
    @FXML private ImageView imgSki,imgSykkel,imgLop;
    private boolean javaFXKjorer = false;

    private static ObservableList<BrukerType> listeBrukere = FXCollections.observableArrayList(DataHandlerSQL.hentBrukere());

    public static BrukerType getInnloggetBruker(){return innloggetBruker;}

    private static BrukerType innloggetBruker; //Setter brukeren til å være bruker

    public void initialize(){

        javaFXKjorer = true;

        imgForhand();
        lagArrangementButton.setVisible(false);

        if (innloggetBruker == null){
            innloggetBruker = listeBrukere.get(0);
        }

        valgtBrukerNavnLabel.setText(innloggetBruker.hentNavnOgType());

        brukerListe.setItems(listeBrukere);
        brukerListe.getSelectionModel().selectFirst();

        brukerLoggInn.setOnAction(actionEvent -> {
            innloggetBruker = brukerListe.getSelectionModel().getSelectedItem();
            valgtBrukerNavnLabel.setText(innloggetBruker.hentNavnOgType());

            //Hvis brukeren er administrator eller arrangementansvarlig,
            // skal han/hun ha muligheten til å lage arrangement
            if (innloggetBruker.erAdminEllerAA()){
                lagArrangementButton.setVisible(true);
            } else {
                lagArrangementButton.setVisible(false);
            }
        });

        BrukersideButton.setOnAction(click -> {
            Main.getInstance().changeScene("../View/BrukerSideView.fxml");
        });

        lagArrangementButton.setOnAction(click -> {
            Main.getInstance().changeScene("../View/OpprettArrangementView.fxml");
        });

        skirennButton.setOnAction(getActionEventEventHandler("renn"));
        sykkelrittButton.setOnAction(getActionEventEventHandler("ritt"));
        lopButton.setOnAction(getActionEventEventHandler("lop"));


    }

    private EventHandler<ActionEvent> getActionEventEventHandler(String arrangementType) {
        return actionEvent -> {
            switch (arrangementType){
                case "renn":
                    ArrangementOversiktController.arrangementType = "Skirenn";
                    break;
                case "ritt":
                    ArrangementOversiktController.arrangementType = "Sykkelritt";
                    break;
                case "lop":
                    ArrangementOversiktController.arrangementType = "Løp";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + arrangementType);
            }
            Main.getInstance().changeScene("../View/ArrangementOversiktView.fxml");
        };
    }

    private void imgForhand(){
        imgSykkel.setImage(new Image("/img/lop.jpg"));
        imgSki.setImage(new Image("/img/ski.jpg"));
        imgLop.setImage(new Image("/img/sykkel.jpg"));
    }
}