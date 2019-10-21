package main;


import Controller.ArrangementOversiktController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)

public class ArrangementOversiktControllerTest {
    class MainTest {
        private Stage primaryStage;

        @Start
        public void start(Stage primaryStage) throws Exception {
            //Setter den globale variabelen primarystage til å være dette staget
            this.primaryStage = primaryStage;


            //Lager en instance slik at vi kan bruke metodene her i andre klasser

            Parent root = FXMLLoader.load(getClass().getResource("../View/ArrangementOversiktView.fxml"));
            primaryStage.setTitle("ArrangementOversiktController");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();

        }
    }
    @Test
    void brukerFaarOppRitt(){
        FxRobot tester = new FxRobot();
    }
}
