package helicopter_aviation_company;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
                "Director", "GM", "Aviation CEO", "Accounts Officer", "Supply chain", "Strategy and Business Development"));
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
            defaultPassword = "dir123";
        } else if (enteredJobTitle.equals("GM")) {
            defaultPassword = "gm123";
        } else if (enteredJobTitle.equals("Aviation CEO")) {
            defaultPassword = "ceo123";
        } else if (enteredJobTitle.equals("Accounts Officer")) {
            defaultPassword = "ac123";
        } else if (enteredJobTitle.equals("Supply chain")) {
            defaultPassword = "sup123";
        } else if (enteredJobTitle.equals("Strategy and Business Development")) {
            defaultPassword = "str123";
        }

        // Check if login credentials are valid
        if (enteredPassword.equals(defaultPassword)) {
            // Valid login, show success message
            System.out.println("Login successful for " + enteredJobTitle);
            try {
                openDashboard(enteredJobTitle); // Open dashboard based on job title
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Invalid login, show error message
            System.out.println("Invalid login.");
        }
    }

    private void openDashboard(String jobTitle) throws IOException {
        String dashboardPath = "";
        if (jobTitle.equals("Director")) {
            dashboardPath = "/Mahfuja/DirectorDashboard.fxml";
        } else if (jobTitle.equals("GM")) {
            dashboardPath = "/Kalpika/GMDashboard.fxml";
        } else if (jobTitle.equals("Aviation CEO")) {
            dashboardPath = "/Kalpika/CEODashboard.fxml";
        } else if (jobTitle.equals("Accounts Officer")) {
            dashboardPath = "/Mahfuja/AccountantDashboard.fxml";
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource(dashboardPath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
