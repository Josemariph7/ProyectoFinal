package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import dao.UserDAO;
import javafx.scene.Scene;

import java.io.IOException;

public class UserFormularioController {

    @FXML
    private ComboBox<String> rolComboBox;
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField contraseñaTextField;
    @FXML
    private TextField telefonoTextField;
    @FXML
    private Button aceptarButton;
    @FXML
    private Button cancelarButton;


    private UserController usercontroller= new UserController();
    private User user;

    @FXML
    private void initialize() {
    }

    public void initData(User user) {
        this.user = user;

        if (this.user != null) {
            nombreTextField.setText(user.getName());
            emailTextField.setText(user.getEmail());
            contraseñaTextField.setText(user.getPassword());
            telefonoTextField.setText(user.getPhone());
            if (user.getRole() != null) {

                rolComboBox.setValue(String.valueOf(user.getRole()));
            } else {

                rolComboBox.setValue(null);
            }
        }
    }


    @FXML
    private void onAceptarClicked() {
        if (user == null) {
            user = new User();
        }
        user.setName(nombreTextField.getText());
        user.setEmail(emailTextField.getText());
        user.setPassword(contraseñaTextField.getText());
        user.setPhone(telefonoTextField.getText());
        user.setRole(User.UserRole.valueOf(rolComboBox.getValue()));

        boolean success;
        if (user.getUserId() == null) {
            success = usercontroller.create(user);
        } else {
            success = usercontroller.update(user);
        }

        if (success) {

            closeForm();
            openMainScreen();
        } else {

        }

    }

    @FXML
    private void onCancelarClicked() {
        closeForm();
        openMainScreen();
    }

    private void closeForm() {
        Stage stage = (Stage) cancelarButton.getScene().getWindow();
        stage.close();
    }

    private void openMainScreen() {
        try {
            Stage currentStage = (Stage) cancelarButton.getScene().getWindow();
            currentStage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CrudPrueba.fxml"));
            Parent root = loader.load();
            Stage mainStage = new Stage();
            mainStage.setTitle("Pantalla Principal");
            mainStage.setScene(new Scene(root));
            mainStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
