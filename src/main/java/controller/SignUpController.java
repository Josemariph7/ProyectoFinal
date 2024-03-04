package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Objects;

public class SignUpController implements Initializable {

    @FXML
    private VBox vbox;

    @FXML
    private TextField signupEmailField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private ChoiceBox<String> roleChoiceBox;

    @FXML
    private Button signUpButton;

    private UserController userController = new UserController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> roles = FXCollections.observableArrayList(
                "Administrador",
                "Estudiante",
                "Propietario"
        );
        roleChoiceBox.setItems(roles);
    }

    @FXML
    private void signUp() {
        String email = signupEmailField.getText();
        String fullName = fullNameField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || fullName.isEmpty() || password.isEmpty()) {
            showError("Por favor, rellena todos los campos.");
            return;
        }

        // Realizar la lógica de registro aquí

        // Por ejemplo:
        // userController.registerUser(email, fullName, password);

        // Muestra un mensaje de éxito o cualquier otra acción necesaria después del registro
        showSuccess("Registro exitoso.");
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
