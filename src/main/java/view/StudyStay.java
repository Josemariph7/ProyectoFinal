package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.net.URL;

/**
 * Punto de entrada principal para la aplicación JavaFX.
 */
public class StudyStay extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Cargar el archivo FXML para la pantalla de inicio de sesión
            URL fxmlUrl = getClass().getResource("/fxml/LogIn.fxml");
            if (fxmlUrl == null) {
                throw new IllegalArgumentException("No se pudo encontrar el archivo FXML");
            }
            Parent root = FXMLLoader.load(fxmlUrl);

            // Crear una escena con fondo transparente
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);

            // Establecer el escenario con estilo transparente
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
