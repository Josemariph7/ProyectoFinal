package controller;

import dao.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class UserInterfaceController {

    private UserController usercontroller= new UserController();

    @FXML
    private VBox vbox;
    @FXML
    private TableView<User> usersTable;
    @FXML
    private TextField nameField;
    @FXML
    private TextField otherField;

    @FXML
    private void initialize() {
        vbox.getStyleClass().add("root");
        vbox.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/styles.css")).toExternalForm());
        ObservableList<User> usersObservableList;
        try {
            List<User> userList = usercontroller.getAll();


            for (User user : userList) {
                System.out.println("ID: " + user.getUserId() + " - Nombre: " + user.getName() + " - Email: " + user.getEmail());
            }

            usersObservableList = FXCollections.observableArrayList(userList);
        } catch (Exception e) {
            usersObservableList = FXCollections.observableArrayList();
            e.printStackTrace();
        }

        usersTable.setItems(usersObservableList);
        usersTable.refresh();
    }


    @FXML
    private void create(ActionEvent event) throws IOException {
        User newUser = new User();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FormularioPrueba.fxml"));
        Parent form = loader.load();

        UserFormularioController formularioController = loader.getController();
        formularioController.initData(newUser);

        Stage stage = (Stage) usersTable.getScene().getWindow();
        Scene scene = new Scene(form);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void update(ActionEvent event) throws IOException {
        User selectedUser = usersTable.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FormularioPrueba.fxml"));
        Parent form = loader.load();

        UserFormularioController formularioController = loader.getController();
        formularioController.initData(selectedUser);

        Stage stage = (Stage) usersTable.getScene().getWindow();
        Scene scene = new Scene(form);
        stage.setScene(scene);
        stage.show();
        usersTable.refresh();
    }


    void refreshTable()  {

        usersTable.refresh();
    }


    @FXML
    private void delete(ActionEvent event) {
        User selectedUser = usersTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            boolean deleted = usercontroller.delete(selectedUser.getUserId());
            if (deleted) {
                usersTable.getItems().remove(selectedUser);
            } else {

            }
        }
        usersTable.refresh();
    }
}
