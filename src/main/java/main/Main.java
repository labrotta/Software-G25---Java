package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private static Main instance;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //new DataHandlerDBtoCSV().ArrangementerTilCSV();
        //new DataHandlerDBtoCSV().TiderTilCSV();
        //new DataHandlerDBtoCSV().BrukereTilCSV();
        //Setter den globale variabelen primarystage til å være dette staget
        this.primaryStage = primaryStage;

        //Lager en instance slik at vi kan bruke metodene her i andre klasser
        instance = this;

        Parent root = FXMLLoader.load(getClass().getResource("../View/ViewFrontPage.fxml"));
        primaryStage.setTitle("App v0.3.1a");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void changeScene(String fxml_path) {
        try {
            Parent pane = FXMLLoader.load(
                    getClass().getResource(fxml_path)
            );
            primaryStage.getScene().setRoot(pane);

        } catch (IOException IOE){
            IOE.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Main getInstance() {
        return instance;
    }
}