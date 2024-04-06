package helicopter_aviation_company;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginPageController {

    @FXML
    private ComboBox<String> jobTitleComboBox;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button backButton;

    private SignupController signupController; // Reference to SignupController

    // Method to set reference to SignupController
    public void setSignupController(SignupController signupController) {
        this.signupController = signupController;
    }

    // This method will be called when the FXML is loaded
    public void initialize() {
        // Populate the ComboBox with job titles
        jobTitleComboBox.setItems(FXCollections.observableArrayList(
                "Director", "GM", "Aviation CEO", "Accountant", "Supply chain", "Strategy and Business Development"));
    }

    @FXML
    private void backToLoginSignup() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginSignup.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
private void loginClicked() {
    String enteredPassword = passwordField.getText();
    String enteredJobTitle = jobTitleComboBox.getValue(); // Retrieve selected job title

    // Adding default passwords for different job titles
    String defaultPassword = "";
    if (enteredJobTitle.equals("Director")) {
        defaultPassword = "directorPassword";
    } else if (enteredJobTitle.equals("GM")) {
        defaultPassword = "gmPassword";
    } else if (enteredJobTitle.equals("Aviation CEO")) {
        defaultPassword = "ceoPassword";
    } else if (enteredJobTitle.equals("Accountant")) {
        defaultPassword = "accountantPassword";
    } else if (enteredJobTitle.equals("Supply chain")) {
        defaultPassword = "supplyChainPassword";
    } else if (enteredJobTitle.equals("Strategy and Business Development")) {
        defaultPassword = "strategyPassword";
    }

    // Check if login credentials are valid
    if (enteredPassword.equals(defaultPassword)) {
        // Successful login, perform necessary actions
        System.out.println("Login successful for job title: " + enteredJobTitle);
    } else {
        // Invalid login, show error message
        System.out.println("Invalid login.");
    }
}
}