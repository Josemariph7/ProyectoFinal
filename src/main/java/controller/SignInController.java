package controller;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.User;

import java.io.IOException;
import java.util.List;

public class SignInController {

    public Stage splashStage;

    @FXML
    private AnchorPane root;

    @FXML
    private VBox vbox;

    public UserController userController = new UserController();

    @FXML
    public TextField emailField;

    @FXML
    public PasswordField passwordField;

    @FXML
    private void initialize() {
        emailField.requestFocus();
        vbox = new VBox();
    }

    @FXML
    public void login() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showError("Por favor, introduce el correo electrónico y la contraseña.");
            return;
        }
        List<User> userList = userController.getAll();
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                showSplashScreen(() -> Platform.runLater(() -> loadDashboard(user.getRole(), user)));
                return;
            }
        }
        showError("Credenciales inválidas. Por favor, inténtalo de nuevo.");
    }


    private void loadDashboard(User.UserRole role, User user) {
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
                showError("Rol de usuario no reconocido");
                return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent dashboard = loader.load();

            AdminDashboardController adminController = loader.getController();
            adminController.initData(user);

            Scene scene = new Scene(dashboard);

            Stage stage = (Stage) emailField.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
            closeSplashScreen();
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

    private void showSplashScreen(Runnable onSplashScreenFinished) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SplashScreen.fxml"));
            Parent root = loader.load();
            splashStage = new Stage();
            splashStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            splashStage.setScene(scene);
            splashStage.show();

            PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
            delay.setOnFinished(event -> onSplashScreenFinished.run());
            delay.play();
        } catch (IOException e) {
            e.printStackTrace();
            onSplashScreenFinished.run();
        }
    }

    private void closeSplashScreen() {
        if (splashStage != null) {
            splashStage.close();
        }
    }

    @FXML
    private void closeApp() {
        System.exit(0);
    }
}