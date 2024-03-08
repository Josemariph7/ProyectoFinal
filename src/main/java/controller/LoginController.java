package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


public class LoginController implements Initializable {

    @FXML
    public VBox vbox;
    private Parent fxml;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(0.01), vbox);
        vbox.setLayoutX(vbox.getLayoutX() * 17);
        t.setToX(0);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/SignIn.fxml")));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ignored){

            }
        });
    }
    @FXML
    public void open_signin(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(0.8), vbox);
        t.setToX(0);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/SignIn.fxml")));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ignored){

            }
        });
    }
    @FXML
    public void open_signup(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(0.8), vbox);
        t.setToX(vbox.getLayoutX() / -1.084);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/SignUp.fxml")));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ignored){
            }
        });
    }
}
