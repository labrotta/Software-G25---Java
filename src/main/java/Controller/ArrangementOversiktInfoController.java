package Controller;

import Model.Arrangement;
import Model.ArrangementVisBruker;
import Model.BrukerType;
import data.DataHandlerSQL;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import main.Main;


public class ArrangementOversiktInfoController {
    static String arrangementType;
    private BrukerType innloggetBruker = BrukerController.getInnloggetBruker().getInnloggetBruker();

    static String arrangementInfo = "lop";
    @FXML
    private TableView<ArrangementVisBruker> arrangementVisBrukerTableView;
    @FXML private TableColumn<ArrangementVisBruker, String> UnikBrukerNavn, SluttTid, StartTid;
    @FXML private Text arrangementTypeTextField;
    @FXML private Button tilbakeButton;
    @FXML private Label brukerID;
    public void initialize() {
        brukerID.setText(innloggetBruker.getForNavn());
        final ObservableList<ArrangementVisBruker> sqlList = DataHandlerSQL.VisBrukerePrArrangement();
        for (ArrangementVisBruker liste : sqlList) {
            arrangementVisBrukerTableView.getItems().add(liste);
        }

        StartTid.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getStartTid()));
        SluttTid.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getSluttTid()));
        UnikBrukerNavn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getBrukerUnikID()));
        tilbakeButton.setOnAction(actionEvent -> Main.getInstance().changeScene("../View/ArrangementOversiktView.fxml"));
    }
}
