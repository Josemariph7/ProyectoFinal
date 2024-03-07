package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {

    @FXML
    public Button btnExit;
    @FXML
    public Label namelabel;
    @FXML
    public Label idlabel;
    @FXML
    public Label passwordlabel;
    @FXML
    public Label datelabel;
    @FXML
    public Label rolelabel;
    @FXML
    public Label emaillabel;
    @FXML
    public Label phonelabel;

    @FXML
    private Pane dragArea;

    @FXML
    public Label username;

    @FXML
    private VBox pnItems;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnUsers;

    @FXML
    private Button btnAccommodations;

    @FXML
    private Button btnForum;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlProfile;

    @FXML
    private Pane pnlUsers;

    @FXML
    private Pane pnlForum;

    @FXML
    private Pane pnlAccommodations;

    @FXML
    private Label totalusers;

    @FXML
    private Label totalstudents;

    @FXML
    private Label totalowners;

    @FXML
    private Label lastweek;

    @FXML
    private Circle circle;

    @FXML
    private Circle circleProfile;

    private User currentUser;

    private double xOffset = 0;
    private double yOffset = 0;

    private int totalUsers = 0;
    private int totalStudents = 0;
    private  int totalOwners = 0;
    private int registeredLastWeek = 0;
    LocalDate oneWeekAgo = LocalDate.now().minusWeeks(1);

    private UserController userController = new UserController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        dragArea.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        dragArea.setOnMouseDragged(event -> {
            dragArea.getScene().getWindow().setX(event.getScreenX() - xOffset);
            dragArea.getScene().getWindow().setY(event.getScreenY() - yOffset);
        });
        dragArea.toFront();

        // Obtener todos los usuarios desde la base de datos
        List<User> users = userController.getAll();

        for (User user : users) {
            updateStatistics();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ItemAdminList.fxml"));
                Node node = loader.load();
                // Configurar el controlador del nodo
                ItemAdminListController controller = loader.getController();
                controller.initData(user, userController, node, pnItems, this); // Pasa el usuario al controlador del nodo

                pnItems.getChildren().add(node);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateStatistics() {
        // Obtener todos los usuarios desde la base de datos
        List<User> usersAux = userController.getAll();
         int totalUsers = 0;
         int totalStudents = 0;
         int totalOwners = 0;
         int registeredLastWeek = 0;

        for (User user : usersAux) {
            // Incrementar el contador total de usuarios
            totalUsers++;

            // Determinar si el usuario es estudiante
            if (user.getRole() == User.UserRole.STUDENT) {
                totalStudents++;
            }
            // Determinar si el usuario es propietario
            if (user.getRole() == User.UserRole.OWNER) {
                totalOwners++;
            }
            // Verificar si el usuario se registró la última semana
            LocalDate registrationDate = user.getRegistrationDate().toLocalDate();

            if (registrationDate.isAfter(oneWeekAgo) || registrationDate.equals(oneWeekAgo)) {
                registeredLastWeek++;
            }
        }
        totalusers.setText(String.valueOf(totalUsers));
        totalstudents.setText(String.valueOf(totalStudents));
        totalowners.setText(String.valueOf(totalOwners));
        lastweek.setText(String.valueOf(registeredLastWeek));
    }

    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnProfile) {
            pnlProfile.setVisible(true);
            pnlProfile.toFront();
            pnlUsers.setVisible(false);
            pnlAccommodations.setVisible(false);
            pnlForum.setVisible(false);
        }
        if(actionEvent.getSource()== btnUsers)
        {
            pnlUsers.setVisible(true);
            pnlUsers.toFront();
            pnlProfile.setVisible(false);
            pnlAccommodations.setVisible(false);
            pnlForum.setVisible(false);
        }
        if (actionEvent.getSource() == btnAccommodations) {
            pnlAccommodations.setVisible(true);
            pnlAccommodations.toFront();
            pnlProfile.setVisible(false);
            pnlUsers.setVisible(false);
            pnlForum.setVisible(false);
        }
        if (actionEvent.getSource() == btnForum) {
            pnlForum.setVisible(true);
            pnlForum.toFront();
            pnlProfile.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAccommodations.setVisible(false);
        }
    }


    public void signOut(MouseEvent actionEvent) {
        if (actionEvent.getSource() == btnSignout) {
            Stage stage = (Stage) btnSignout.getScene().getWindow();

            try {
                URL fxmlUrl = getClass().getResource("/fxml/LogIn.fxml");
                if (fxmlUrl == null) {
                    throw new IllegalArgumentException("No se pudo encontrar el archivo fxml");
                }
                Parent root = FXMLLoader.load(fxmlUrl);
                Scene scene = new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showError("Error al cargar la vista de inicio de sesión.");
            }
        }
    }

    public void initData(User user) {
        this.currentUser = user;
        username.setText(currentUser.getName());
        namelabel.setText(currentUser.getName());
        idlabel.setText(String.valueOf(currentUser.getUserId()));
        rolelabel.setText(currentUser.getRole().toString());
        passwordlabel.setText(currentUser.getPassword());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = currentUser.getRegistrationDate().format(formatter);
        datelabel.setText(formattedDate);
        emaillabel.setText(currentUser.getEmail());
        phonelabel.setText(currentUser.getPhone());
        if (currentUser != null) {
            this.username.setText(currentUser.getName());
            String imageUrl = currentUser.getProfilePicture();
            if (imageUrl != null && !imageUrl.isEmpty()) {
                try {
                    URL resource = getClass().getResource(imageUrl);
                    if (resource != null) {
                        Image profilePicture = new Image(resource.toExternalForm());
                        circle.setFill(new ImagePattern(profilePicture));
                        circleProfile.setFill(new ImagePattern(profilePicture));
                        circleProfile.setStroke(Color.web("#151928"));
                        circleProfile.setStrokeWidth(5);
                    } else {
                        cargarImagenPredeterminada();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    cargarImagenPredeterminada();
                }
            } else {
                cargarImagenPredeterminada();
            }
        } else {
            System.out.println("El usuario actual es nulo.");
        }
    }

    private void cargarImagenPredeterminada() {
        String defaultImageUrl = "/profilepictures/default.png";
        URL defaultResource = getClass().getResource(defaultImageUrl);
        if (defaultResource != null) {
            Image defaultProfilePicture = new Image(defaultResource.toExternalForm());
            circle.setFill(new ImagePattern(defaultProfilePicture));
            circleProfile.setFill(new ImagePattern(defaultProfilePicture));
            circleProfile.setStroke(Color.web("#151928"));
            circleProfile.setStrokeWidth(5);
        } else {
            System.out.println("No se pudo cargar la imagen predeterminada.");
        }
    }

    @FXML
    private void handleModify() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Modify.fxml"));
            Parent root = loader.load();
            System.out.println("Usuario que se intenta modificar: "+currentUser);
            ModifyController modify = loader.getController();
            modify.initData(currentUser, userController);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));

            // Configurar el controlador actual como userData
            stage.setUserData(this);

            // Configurar el evento para el botón Cancelar
            ModifyController modifyController = loader.getController();
            modifyController.btnCancel.setOnAction(event -> {
                stage.close();
            });

            modifyController.btnAccept.setOnAction(event -> {
                currentUser=modifyController.getUser();
                username.setText(currentUser.getName());
                namelabel.setText(currentUser.getName());
                idlabel.setText(String.valueOf(currentUser.getUserId()));
                rolelabel.setText(currentUser.getRole().toString());
                passwordlabel.setText(currentUser.getPassword());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDate = currentUser.getRegistrationDate().format(formatter);
                datelabel.setText(formattedDate);
                emaillabel.setText(currentUser.getEmail());
                phonelabel.setText(currentUser.getPhone());
                stage.close();
            });
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Modificar usuario: " + currentUser);
    }

    @FXML
    private void closeApp() {
        System.exit(0);
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}