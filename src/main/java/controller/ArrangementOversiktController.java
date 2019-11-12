package controller;

import Model.ArrangementKlasser.Lop;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import data.DataHandlerSQL;
import Model.Arrangement;
import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
import Model.BrukerKlasser.Medlem;
import Model.BrukerType;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Main;

import java.sql.SQLException;

public class ArrangementOversiktController{

    static String arrangementType;
    private BrukerType innloggetBruker = ForsideController.getInnloggetBruker();

    @FXML private TableView<Arrangement> arrangementTableView;
    @FXML private TableColumn<Arrangement, String> stedTableColumn, navnTableColumn, datoTableColumn;
    @FXML private Text arrangementTypeTextField;
    @FXML private Button tilbakeButton,eksArrangementInfo, paameldingButton;
    @FXML private Label brukerID;

    Stage dialog;

    public void initialize() throws SQLException {
        brukerID.setText(innloggetBruker.getFornavn());
        final ObservableList<Arrangement> sqlList = DataHandlerSQL.sjekkSQLType(arrangementType);

        fyllTabellen(sqlList, arrangementTableView, arrangementType);

        arrangementTypeTextField.setText(arrangementType);

        stedTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSted()));
        navnTableColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNavn()));
        datoTableColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getDatoOgTid()));

        paameldingButton.setOnAction(actionEvent -> paameldingDialog(arrangementTableView.getSelectionModel().getSelectedItem()));

        tilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ViewFrontPage.fxml"));
        eksArrangementInfo.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ArrangementOversiktViewInfo.fxml"));
    }

    private void paameldingDialog(Arrangement selectedItem) {
        if (selectedItem == null){
            String tittel = "Velg et " + arrangementType + "!";
            String innhold = "Vennligst velg et " + arrangementType + " du vil melde deg på!";
            nyAlert(tittel, innhold);
            return;
        }
        dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVBox = new VBox(20);

        Text tekst = new Text("Her vil det komme betalingsløsning" +
                " med Vipps eller Visa, men for å ha en fungerende MVP" +
                " vil medlemmet melde seg på uten å foreløpig betale noe");
        tekst.setLayoutX(200);
        dialogVBox.getChildren().add(tekst);

        Button meldPaaButton = new Button("Meld deg på");
        dialogVBox.getChildren().add(meldPaaButton);

        Scene dialogScene = new Scene(dialogVBox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.setTitle(selectedItem.getNavn());
        dialog.show();

        meldPaaButton.setOnAction(actionEvent -> paamelding(selectedItem, innloggetBruker));
    }

    public void paamelding(Arrangement selectedItem, BrukerType innloggetBruker) {
        if (innloggetBruker instanceof Medlem || innloggetBruker instanceof Admin || innloggetBruker instanceof ArrangementAnsvarlig) {
            selectedItem.leggTilEnPaamelding(innloggetBruker);
            leggIDatabase(selectedItem, innloggetBruker);
        } else {
            avbrytPaameldingen();
        }
    }

    private void avbrytPaameldingen() {
        if (javaFXKjorer()) {
            nyAlert("Logg inn", "Du er nødt til å logge deg inn før du kan melde deg på.");
        }

    }

    private void leggIDatabase(Arrangement selectedItem, BrukerType innloggetBruker) {
        if (javaFXKjorer()){
            return;
        }
        data.DataHandlerSQL.PaaMeldingBrukerArrangement(selectedItem.getNavn(), innloggetBruker.getFornavn());
        dialog.close();
    }

    public void fyllTabellen(ObservableList<Arrangement> sqlList, TableView<Arrangement> tabell, String arrangementType) {
        switch (arrangementType){
            case "Skirenn": {
                for (Arrangement arrangement : sqlList) {
                    if (arrangement instanceof Renn) {
                        tabell.getItems().add(arrangement);
                    }
                }
            }
            case "Sykkelritt" : {
                for (Arrangement arrangement : sqlList) {
                    if (arrangement instanceof Ritt) {
                        tabell.getItems().add(arrangement);
                    }
                }
            }
            case "Løp": {
                for (Arrangement arrangement : sqlList) {
                    if (arrangement instanceof Lop) {
                        tabell.getItems().add(arrangement);
                    }
                }
            }
        }
    }

    private void nyAlert(String tittel, String innhold) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(tittel);
        alert.setHeaderText(null);
        alert.setContentText(innhold);
        alert.showAndWait();
    }

    private boolean javaFXKjorer(){
        return dialog != null;
    }
}
