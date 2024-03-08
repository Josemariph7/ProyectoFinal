package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;

public class ModifyController  {

    public TextField txtName;
    @FXML
    public TextField txtPhone;
    @FXML
    public TextField txtEmail;
    @FXML
    public TextField txtPassword;
    @FXML
    public Button btnAccept;
    @FXML
    public Button btnCancel;
    @FXML
    private ChoiceBox<User.UserRole> roleChoiceBox;

    private User user;

    public UserController userController;

    public User getUser() {
        return user;
    }

    public void handleAccept(ActionEvent actionEvent) {
        user.setRole(roleChoiceBox.getValue());
        user.setEmail(txtEmail.getText());
        user.setName(txtName.getText());
        user.setPassword(txtPassword.getText());
        user.setPhone(txtPhone.getText());
        userController.update(user);
        updateItemAdminList();
        ((Stage) btnAccept.getScene().getWindow()).close();
    }

    private void updateItemAdminList() {
        ItemAdminListController itemAdminListController = (ItemAdminListController) btnAccept.getScene().getWindow().getUserData();
        itemAdminListController.updateUserData(user);
    }

    public void handleCancel(ActionEvent actionEvent) {
        ((Stage) btnCancel.getScene().getWindow()).close();
    }

    public void initData(User user, UserController userController) {
        System.out.println("Usuario dentro de modify: "+user);
        this.userController=userController;
        this.user=user;
        if (user != null) {
            roleChoiceBox.getItems().addAll(User.UserRole.values());
            roleChoiceBox.getSelectionModel().select(user.getRole());
            txtName.setText(user.getName());
            txtEmail.setText(user.getEmail());
            txtPhone.setText(user.getPhone());
            txtPassword.setText(user.getPassword());
        }

    }
}
