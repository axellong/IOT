package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    private static Scene scene;
    public static Stage primaryStage;
    public static FXMLLoader fxmlLoader;

    @Override
    public void start(Stage stage) {
        Main.primaryStage = stage;
        try {
            scene = new Scene(loadFXML("sample"));
            primaryStage.centerOnScreen();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFXML(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        fxmlLoader = new FXMLLoader(Main.class.getResource("/views/"+ fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
