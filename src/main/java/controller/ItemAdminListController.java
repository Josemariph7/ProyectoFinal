package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.User;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ItemAdminListController {

    @FXML
    private Label lblUserId, lblName, lblEmail, lblPhone, lblRole, lblRegDate;
    @FXML
    private Button btnDelete, btnModify;

    private User user;

    private UserController userController;

    private Node node;

    private VBox pnItems;
    AdminDashboardController dashboard;


    public void initialize() {
        btnDelete.setOnAction(event -> handleDelete());
        btnModify.setOnAction(event -> handleModify());
    }

    public void initData(User user, UserController userController, Node node, VBox pnItems, AdminDashboardController adminDashboardController) {
        this.dashboard=adminDashboardController;
        this.pnItems=pnItems;
        this.user = user;
        this.node=node;
        this.userController=userController;
        lblUserId.setText(String.valueOf(user.getUserId()));
        lblName.setText(user.getName());
        lblEmail.setText(user.getEmail());
        lblPhone.setText(user.getPhone());
        lblRole.setText(user.getRole().toString());

        // Formatear la fecha de registro antes de establecerla en el Label
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = user.getRegistrationDate().format(formatter);
        lblRegDate.setText(formattedDate);
    }

    @FXML
    private void handleDelete() {
        // Borra el usuario de la base de datos
        userController.delete(user.getUserId());

        // Obtiene el índice del nodo que representa al usuario en el VBox
        int index = pnItems.getChildren().indexOf(node);

        // Elimina el nodo del VBox
        if (index != -1) {
            pnItems.getChildren().remove(index);
        } else {
            System.out.println("El nodo no se encontró en el VBox.");
        }
        dashboard.updateStatistics();
        System.out.println("Eliminar usuario: " + user);
    }

    @FXML
    private void handleModify() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Modify.fxml"));
            Parent root = loader.load();
            System.out.println("Usuario que se intenta modificar: "+user);
            ModifyController modify = loader.getController();
            modify.initData(user, userController);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));

            // Configurar el controlador actual como userData
            stage.setUserData(this);

            // Configurar el evento para el botón Cancelar
            ModifyController modifyController = loader.getController();
            modifyController.btnCancel.setOnAction(event -> {
                // Cerrar la ventana de modificación cuando se presiona Cancelar
                stage.close();
            });

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Modificar usuario: " + user);
    }


    public void updateUserData(User updatedUser) {
        this.user = updatedUser;
        lblUserId.setText(String.valueOf(user.getUserId()));
        lblName.setText(user.getName());
        lblEmail.setText(user.getEmail());
        lblPhone.setText(user.getPhone());
        lblRole.setText(user.getRole().toString());

        // Formatear la fecha de registro antes de establecerla en el Label
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = user.getRegistrationDate().format(formatter);
        lblRegDate.setText(formattedDate);
        dashboard.updateStatistics();
    }
}
