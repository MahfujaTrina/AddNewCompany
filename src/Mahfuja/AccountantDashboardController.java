/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mahfuja;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trina
 */
public class AccountantDashboardController {
     @FXML
    private Button backButton;
    
    @FXML
    private Button salaryButton; 

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

    /**
     * Initializes the controller class.
     */
    @FXML
       public void goToSalary() {
    // Get the reference to the stage
    Stage stage = (Stage)salaryButton.getScene().getWindow();

    try {
        // Load the FXML file for the Organization Performance screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mahfuja/AccountantDashboard.fxml"));
        Parent root = loader.load();

        // Create a new scene
        Scene scene = new Scene(root);

        // Set the scene to the stage
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void setJobTitle(String value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}