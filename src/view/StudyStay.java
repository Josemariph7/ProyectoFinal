package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Punto de entrada principal para la aplicación JavaFX.
 */
public class StudyStay extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Asegúrate de que la ruta comienza con un '/' y refleja la estructura de directorios en tu proyecto.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CrudPrueba.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Inicia la aplicación JavaFX.
        launch(args);
    }
}
