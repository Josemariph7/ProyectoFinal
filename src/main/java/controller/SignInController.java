package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class SignInController {

    @FXML
    private VBox vbox;

    private UserController userController = new UserController();

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void initialize() {
        emailField.requestFocus();

            vbox = new VBox();


    }

    @FXML
    private void login() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showError("Por favor, introduce el correo electrónico y la contraseña.");
            return;
        }

        List<User> userList = userController.getAll();

        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                loadDashboard();
                return;
            }
        }

        showError("Credenciales inválidas. Por favor, inténtalo de nuevo.");
    }

    private void loadDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Dashboard.fxml"));
            Parent dashboard = loader.load();
            DashboardController dashboardController = loader.getController();

            Stage stage = (Stage) emailField.getScene().getWindow(); // Usar un nodo asociado a la escena
            stage.setScene(new Scene(dashboard));
            stage.show();
        } catch (IOException ex) {
            showError("No se pudo cargar el panel de control. Inténtalo de nuevo más tarde.");
        }
    }




    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
