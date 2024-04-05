/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package helicopter_aviation_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginSignupController {

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    void loginButtonAction(ActionEvent event) {
        // Add your login logic here
        System.out.println("Login button clicked");
    }

    @FXML
    void signupButtonAction(ActionEvent event) {
        // Add your signup logic here
        System.out.println("Signup button clicked");
    }
}