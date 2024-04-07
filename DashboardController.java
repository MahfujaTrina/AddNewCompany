package Kalpika;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;

public class DashboardController {

    @FXML
    private Button backButton;
    
    @FXML
    private Button organizationPerformanceButton; // Button for Organization Performance

    @FXML
    public void backToLogin() {
        // Get the reference to the stage
        Stage stage = (Stage) backButton.getScene().getWindow();

        try {
            // Load the FXML file for the login screen
            FXMLLoader loader = new FXMLLoader();
            URL loginUrl = getClass().getResource("/helicopter_aviation_company/LoginPage.fxml");
            System.out.println("Login FXML URL: " + loginUrl);
            if (loginUrl == null) {
                throw new IOException("FXML file not found");
            }
            loader.setLocation(loginUrl);
            Parent root = loader.load();

            // Create a new scene with the login screen
            Scene scene = new Scene(root);

            // Set the scene to the stage
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
public void goToOrganizationPerformance() {
    // Get the reference to the stage
    Stage stage = (Stage) organizationPerformanceButton.getScene().getWindow();

    try {
        // Load the FXML file for the Organization Performance screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Kalpika/Orgper.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Set the scene to the stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}