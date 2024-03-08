package controller;

import model.User;
import model.User.UserRole;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SignUpController implements Initializable {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
    private static final String PHONE_REGEX = "^\\+34[0-9]{9}$";
    private static final String NAME_REGEX = "^[\\p{L}]+(?: [\\p{L}]+)+$";

    private final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
    private final Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);
    private final Pattern phonePattern = Pattern.compile(PHONE_REGEX);
    private final Pattern namePattern = Pattern.compile(NAME_REGEX);

    @FXML
    public TextField fullNameField;
    @FXML
    public TextField signupEmailField;
    @FXML
    public TextField passwordField;
    @FXML
    public TextField passwordField2;
    @FXML
    public ChoiceBox<UserRole> roleChoiceBox;
    @FXML
    private Button signUpButton;

    public UserController userController = new UserController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleChoiceBox.getItems().addAll(UserRole.values());
        roleChoiceBox.getSelectionModel().selectFirst();
    }

    @FXML
    public void signUp() {
        String email = signupEmailField.getText();
        String fullName = fullNameField.getText();
        String password = passwordField.getText();
        String phone = passwordField2.getText();
        UserRole role = roleChoiceBox.getValue();

        StringBuilder errors = new StringBuilder();
        if (!validateEmail(email)) errors.append("Formato de email inválido.\n");
        if (!validateName(fullName)) errors.append("El nombre debe contener al menos un apellido y solo caracteres válidos.\n");
        if (!validatePassword(password)) errors.append("La contraseña debe tener más de 8 caracteres y contener al menos una letra mayúscula y un número.\n");
        if (!validatePhone(phone)) errors.append("El teléfono debe comenzar con +34 seguido de 9 dígitos.\n");

        if (errors.length() > 0) {
            showError(errors.toString());
            return;
        }

        if (email.isEmpty() || fullName.isEmpty() || password.isEmpty() || phone.isEmpty() || role == null) {
            showError("Por favor, rellena todos los campos.");
            return;
        }
        try {
            if (userExists(email)) {
                showError("El usuario ya existe.");
                return;
            }
            User user = new User(fullName, email, password, phone, role);
            userController.create(user);
            showSuccess("Registro exitoso.");
            fullNameField.setText("");
            signupEmailField.setText("");
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

    private boolean validateEmail(String email) {
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    private boolean validatePassword(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    private boolean validatePhone(String phone) {
        Matcher matcher = phonePattern.matcher(phone);
        return matcher.matches();
    }

    private boolean validateName(String name) {
        Matcher matcher = namePattern.matcher(name);
        return matcher.matches();
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
