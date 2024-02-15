package controller;

import dao.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.User;

import java.util.List;

public class UserInterfaceController {

    private UserDAO userDAO = new UserDAO();
    private ObservableList<User> usersObservableList;

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
        vbox.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        try {
            List<User> userList = userDAO.getAll();

            for (User user : userList) {
                System.out.println("ID: " + user.getUserId() + " - Nombre: " + user.getName() + " - Email: " + user.getEmail());
            }

            if (userList != null) {
                usersObservableList = FXCollections.observableArrayList(userList);
            } else {
                usersObservableList = FXCollections.observableArrayList();
            }
        } catch (Exception e) {
            usersObservableList = FXCollections.observableArrayList();
            e.printStackTrace();
        }

        usersTable.setItems(usersObservableList);
        usersTable.refresh();
    }


    @FXML
    private void create(ActionEvent event) {
        User newUser = new User();
        newUser.setName(nameField.getText());

        boolean created = userDAO.create(newUser);
        if (created) {
            usersTable.getItems().add(newUser);
        } else {
            // Handle creation failure
        }
    }

    @FXML
    private void update(ActionEvent event) {
        User selectedUser = usersTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            selectedUser.setName(nameField.getText());

            boolean updated = userDAO.update(selectedUser);
            if (updated) {
                disableEditing(); // Deshabilita la edición de la tabla
                // Update table if necessary
            } else {
                // Handle update failure
            }
        }
    }

    private void disableEditing() {
        // Deshabilita la edición de la tabla
        usersTable.setEditable(false);
        for (TableColumn<User, ?> col : usersTable.getColumns()) {
            col.setEditable(false);
        }
    }

    private void enableEditing() {
        // Habilita la edición de la tabla
        usersTable.setEditable(true);
        for (TableColumn<User, ?> col : usersTable.getColumns()) {
            col.setEditable(true);
        }
    }

    @FXML
    private void edit(ActionEvent event) {
        enableEditing(); // Habilita la edición de la tabla
    }


    @FXML
    private void delete(ActionEvent event) {
        User selectedUser = usersTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            boolean deleted = userDAO.delete(selectedUser.getUserId());
            if (deleted) {
                usersTable.getItems().remove(selectedUser);
            } else {
                // Handle deletion failure
            }
        }
    }
}
