package Controller;

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

public class BrukerController {
    @FXML private ComboBox<BrukerType> brukerListe;
    @FXML private Button brukerLoggInn, skirennButton, lopButton, sykkelrittButton;
    @FXML private Label valgtBrukerNavnLabel;
    @FXML private ImageView imgSki,imgSykkel,imgLop;

    private ObservableList<BrukerType> listeBrukere = ModelBruker.listeBruker();

    public void initialize() throws Exception {
        imgForhand();
        valgtBrukerNavnLabel.setText("Ukjent");
        brukerListe.setItems(listeBrukere);
        brukerListe.getSelectionModel().selectFirst();

        brukerLoggInn.setOnAction(actionEvent -> {
            String Navn = brukerListe.getSelectionModel().getSelectedItem().toString();
            valgtBrukerNavnLabel.setText(Navn);
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