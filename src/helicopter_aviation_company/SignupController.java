package helicopter_aviation_company;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;

public class SignupController {

    @FXML
    private Button backButton;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> jobTitleComboBox;

    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private String jobTitle;

    @FXML
    private void initialize() {
        // Populate the job title combo box
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
    private void submitClicked() {
        // Get values from the fields
        username = usernameField.getText();
        password = passwordField.getText();
        dateOfBirth = datePicker.getValue();
        jobTitle = jobTitleComboBox.getValue();

        // Validate inputs (you can add your validation logic here)

        // Display a message with the entered values
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Signup Information");
        alert.setHeaderText(null);
        alert.setContentText("Username: " + username + "\nPassword: " + password + "\nDate of Birth: " + dateOfBirth + "\nJob Title: " + jobTitle);
        alert.showAndWait();
    }

    // Method to get username
    public String getUsername() {
        return username;
    }

    // Method to get password
    public String getPassword() {
        return password;
    }

    // Method to get date of birth
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    // Method to get job title
    public String getJobTitle() {
        return jobTitle;
    }
}
