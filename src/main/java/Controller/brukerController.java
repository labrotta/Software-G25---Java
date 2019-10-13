package Controller;

import Model.BrukerType;
import Model.ModelBruker;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class brukerController {
    @FXML private ComboBox<BrukerType> brukerListe;
    @FXML private Button brukerLoggInn;
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
    }

    private void imgForhand(){
        imgLop.setImage(new Image("/img/lop.jpg"));
        imgSki.setImage(new Image("/img/ski.jpg"));
        imgSykkel.setImage(new Image("/img/sykkel.jpg"));
    }
}