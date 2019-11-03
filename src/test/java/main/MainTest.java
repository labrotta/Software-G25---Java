package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.api.FxRobot;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

@ExtendWith(ApplicationExtension.class)

class ArrangementOversiktControllerTest{
    private Stage primaryStage;
    private static ArrangementOversiktControllerTest instance;

    @Start
    public void start(Stage primaryStage) throws Exception {
        //Setter den globale variabelen primarystage til å være dette staget
        this.primaryStage = primaryStage;

        //Lager en instance slik at vi kan bruke metodene her i andre klasser
        instance = this;

        Parent root = FXMLLoader.load(getClass().getResource("../View/ArrangementOversiktView.fxml"));
        primaryStage.setTitle("App v0.2a");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }

  /* @Test
    void changeScene(String fxml_path) {
            try {
                Parent pane = FXMLLoader.load(
                        getClass().getResource(fxml_path)
                );
                primaryStage.getScene().setRoot(pane);

            } catch (IOException IOE){
                IOE.printStackTrace();
            }
        }*/



    @Test
    void sjekk_knapp() {
        verifyThat("#brukerLoggInn",hasText("Logg inn"));
        verifyThat("#brukerLoggInn1",hasText("Kontrollpanel"));
    }
    @Test
    void kjor_robot(){
        new FxRobot().clickOn("#brukerLoggInn");
        verifyThat("#valgtBrukerNavnLabel",hasText("Admin"));
        new FxRobot().clickOn("#brukerLoggInn1");
    }
}