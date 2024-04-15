package Kalpika;

import helicopter_aviation_company.LoginPageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AvCEODashboardController {

    @FXML
    private Button backButton;
    
    @FXML
    private Button recruitmentButton;

    @FXML
    private Button strategicInitiativesButton;

    @FXML
    private Button environmentalMetricsButton;

    @FXML
    private Button flightManagementButton;

    @FXML
    private Button businessOperationsButton;

    @FXML
    private Button riskManagementButton;

    @FXML
    private Button operationMetricsButton;

    @FXML
    private Button stakeholdersEngagementButton;
    
    private LoginPageController loginPageController;

    // Method to set reference to LoginPageController
    public void setLoginPageController(LoginPageController loginPageController) {
        this.loginPageController = loginPageController;
    }

    @FXML
    private void backToLogin() throws IOException {
        loadFXML("/helicopter_aviation_company/LoginPage.fxml");
    }

    @FXML
    private void openRecruitment() throws IOException {
        loadFXML("/Kalpika/Recruitment.fxml");
    }

    @FXML
    private void openStrategicInitiatives() throws IOException {
        loadFXML("/Kalpika/StrategicInitiatives.fxml");
    }

    @FXML
    private void openEnvironmentalMetrics() throws IOException {
        loadFXML("/Kalpika/EnvironmentalMetrics.fxml");
    }

    @FXML
    private void openFlightManagement() throws IOException {
        loadFXML("/Kalpika/FlightManagement.fxml");
    }

    @FXML
    private void openBusinessOperations() throws IOException {
        loadFXML("/Kalpika/BusinessOperations.fxml");
    }

    @FXML
    private void openRiskManagement() throws IOException {
        loadFXML("/Kalpika/RiskManagement.fxml");
    }

    @FXML
    private void openOperationMetrics() throws IOException {
        loadFXML("/Kalpika/OperationMetrics.fxml");
    }

    @FXML
    private void openStakeholdersEngagement() throws IOException {
        loadFXML("/Kalpika/StakeholdersEngagement.fxml");
    }

    private void loadFXML(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    void setPrimaryStage(Stage primaryStage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
