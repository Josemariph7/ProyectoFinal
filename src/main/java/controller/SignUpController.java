package controller;

import controller.UserController;
import model.User;
import model.User.UserRole;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

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
    private TextField passwordField2;

    @FXML
    private ChoiceBox<User.UserRole> roleChoiceBox;

    @FXML
    private Button signUpButton;

    private UserController userController = new UserController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleChoiceBox.getItems().addAll(User.UserRole.values());
        roleChoiceBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void signUp() {
        String email = fullNameField.getText();
        String fullName = signupEmailField.getText();
        String password = passwordField.getText();
        String phone = passwordField2.getText();
        UserRole role = roleChoiceBox.getValue();

        if (email.isEmpty() || fullName.isEmpty() || password.isEmpty() || phone.isEmpty() || role == null) {
            showError("Por favor, rellena todos los campos.");
            return;
        }
        try {
            if (userExists(email)) {
                showError("El usuario ya existe.");
                return;
            }
            User user = new User(email, fullName, password, phone, role);
            userController.create(user);
            showSuccess("Registro exitoso.");
            signupEmailField.setText("");
            fullNameField.setText("");
            passwordField.setText("");
            passwordField2.setText("");
        } catch (SQLException e) {
            showError("Error al registrar el usuario: " + e.getMessage());
        }
    }

    private boolean userExists(String email) throws SQLException {
        List<User> users = userController.getAll();
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
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

    @FXML
    private void closeApp() {
        System.exit(0);
    }
}
