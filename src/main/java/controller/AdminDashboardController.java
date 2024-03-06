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
import javafx.stage.Stage;
import model.User;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {

    @FXML
    public Button btnExit;

    @FXML
    private Pane dragArea;

    @FXML
    public Label username;
    @FXML
    private VBox pnItems = null;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnUsers;

    @FXML
    private Button btnAccommodations;

    @FXML
    private Button btnForum;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

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
    private Circle circle;

    private User currentUser;

    private double xOffset = 0;
    private double yOffset = 0;

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

        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            final int j = i;
            try {
                nodes[i] = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ItemAdminList.fxml")));
                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #edf1ff");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #edf1ff");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
        if (currentUser != null) {
            this.username.setText(currentUser.getName());
            System.out.println("Usuario actual en initData: " + currentUser.getName());

            // Intentar cargar la imagen del perfil del usuario
            String imageUrl = currentUser.getProfilePicture();
            System.out.println(imageUrl);
            System.out.println(currentUser);
            if (imageUrl != null && !imageUrl.isEmpty()) {
                try {
                    // Se modifica para utilizar getResource en lugar de getResourceAsStream
                    // Esto es útil cuando se trabaja con Image en JavaFX que espera una URL
                    URL resource = getClass().getResource(imageUrl);
                    if (resource != null) {
                        Image profilePicture = new Image(resource.toExternalForm());
                        circle.setFill(new ImagePattern(profilePicture));
                    } else {
                        // Si no se encuentra el recurso, cargar la imagen predeterminada
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
        } else {
            System.out.println("No se pudo cargar la imagen predeterminada.");
        }
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