import Model.BrukerTemplate;
import Model.ModelBruker;
import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/ViewFrontPage.fxml"));
        primaryStage.setTitle("App v0.2a");
        primaryStage.setScene(new Scene(root, 580, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}