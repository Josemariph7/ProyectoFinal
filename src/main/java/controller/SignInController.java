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
                loadDashboard(user.getRole());
                return;
            }
        }

        showError("Credenciales inválidas. Por favor, inténtalo de nuevo.");
    }

    private void loadDashboard(User.UserRole role) {
        String fxmlPath;
        switch (role) {
            case ADMINISTRATOR:
                fxmlPath = "/fxml/DashboardAdmin.fxml";
                break;
            case STUDENT:
                fxmlPath = "/fxml/DashboardStudent.fxml";
                break;
            case OWNER:
                fxmlPath = "/fxml/DashboardOwner.fxml";
                break;
            default:
                // Mostrar un mensaje de error si el rol no es reconocido
                showError("Rol de usuario no reconocido");
                return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent dashboard = loader.load();

            // Dependiendo del controlador de la vista cargada, puedes obtener su controlador y realizar acciones específicas si es necesario

            Stage stage = (Stage) emailField.getScene().getWindow(); // Usar un nodo asociado a la escena
            stage.setScene(new Scene(dashboard));
            stage.show();
        } catch (IOException ex) {
            showError("No se pudo cargar el panel de control. Inténtalo de nuevo más tarde.");
             ex.printStackTrace();
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
