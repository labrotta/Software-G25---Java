package controller;

import Model.BrukerType;
import Model.ModelBruker;
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
    @FXML private Button brukerLoggInn, KontrollPanelButton, skirennButton, lopButton, sykkelrittButton;
    @FXML private Label valgtBrukerNavnLabel;
    @FXML private ImageView imgSki,imgSykkel,imgLop;

    private static ObservableList<BrukerType> listeBrukere = ModelBruker.listeBruker();

    public static BrukerType getInnloggetBruker(){return innloggetBruker;}

    private static BrukerType innloggetBruker = listeBrukere.get(2); //Setter brukeren til å være bruker

    public void initialize() {

        imgForhand();

        if (innloggetBruker != null){
            valgtBrukerNavnLabel.setText(innloggetBruker.getForNavn());
        }

        brukerListe.setItems(listeBrukere);
        brukerListe.getSelectionModel().selectFirst();

        brukerLoggInn.setOnAction(actionEvent -> {
            innloggetBruker = brukerListe.getSelectionModel().getSelectedItem();
            valgtBrukerNavnLabel.setText(innloggetBruker.getForNavn());
        });

        KontrollPanelButton.setOnAction(click -> {
            Main.getInstance().changeScene("../View/KontrollPanelView.fxml");
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
        imgLop.setImage(new Image("/img/lop.jpg"));
        imgSki.setImage(new Image("/img/ski.jpg"));
        imgSykkel.setImage(new Image("/img/sykkel.jpg"));
    }
}