package controller;

import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
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
    @FXML private Button brukerLoggInn, BrukersideButton, skirennButton, lopButton, sykkelrittButton, lagArrangementButton;
    @FXML private Label valgtBrukerNavnLabel;
    @FXML private ImageView imgSki,imgSykkel,imgLop;
    private boolean javaFXKjorer = false;

    private static ObservableList<BrukerType> listeBrukere = ModelBruker.listeBruker();

    public static BrukerType getInnloggetBruker(){return innloggetBruker;}

    private static BrukerType innloggetBruker = listeBrukere.get(2); //Setter brukeren til å være bruker

    public void initialize(){

        javaFXKjorer = true;

        imgForhand();
        lagArrangementButton.setVisible(false);


        if (innloggetBruker != null){
            valgtBrukerNavnLabel.setText(innloggetBruker.getFornavn());
        }

        brukerListe.setItems(listeBrukere);
        brukerListe.getSelectionModel().selectFirst();

        brukerLoggInn.setOnAction(actionEvent -> {
            innloggetBruker = loggInn(brukerListe.getSelectionModel().getSelectedItem());
            valgtBrukerNavnLabel.setText(innloggetBruker.getFornavn());

            //Hvis brukeren er administrator eller arrangementansvarlig,
            // skal han/hun ha muligheten til å lage arrangement
            if (brukerErAdminEllerArrangementansvarlig(innloggetBruker)){
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

    public boolean brukerErAdminEllerArrangementansvarlig(BrukerType bruker) {
        if (bruker instanceof Admin || bruker instanceof ArrangementAnsvarlig){
            return true;
        } else {
            return false;
        }
    }

    public BrukerType loggInn(BrukerType bruker) {
        settNyTekstForInnloggetBruker(bruker);
        return bruker;
    }

    private void settNyTekstForInnloggetBruker(BrukerType bruker) {
        if (javaFXKjorer){
            valgtBrukerNavnLabel.setText(bruker.getFornavn());
        }
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