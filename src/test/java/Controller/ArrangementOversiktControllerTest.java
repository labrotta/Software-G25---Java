package Controller;

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

class ArrangementOversiktControllerTest {

    @Test
        public void start(Stage window) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("../View/ArrangementOversikt.fxml"));
            Scene scene =  new Scene(root, 200 ,200);
            window.setScene(scene);
            window.show();
        }
    }