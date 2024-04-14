package Kalpika;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class GMDashboardController {

    @FXML
    private Button backButton;
    
    @FXML
    private Button organizationPerformanceButton;
    
    @FXML
    private Button safetyAndComplianceButton;
    
    @FXML
    private Button financialPerformanceButton;
    
    @FXML
    private Button customerSatisfactionButton;
    
    @FXML
    private Button employeeDetailsButton;
    
    @FXML
    private Button collaborationsButton;
    
    @FXML
    private Button marketTrendsButton;
    
    @FXML
    private Button operationalEfficiencyButton;

    @FXML
    public void backToLogin() {
        System.out.println("Back to Login method called");
        loadFXML("/helicopter_aviation_company/LoginPage.fxml");
    }
    
    @FXML
    public void goToOrganizationPerformance() {
        System.out.println("goToOrganizationPerformance method called");
        loadFXML("/Kalpika/Orgper.fxml");
    }

    @FXML
    public void goToSafetyAndCompliance() {
        System.out.println("goToSafetyAndCompliance method called");
        loadFXML("/Kalpika/SafetyAndCompliance.fxml");
    }
    
    @FXML
    public void goToFinancialPerformance() {
        System.out.println("goToFinancialPerformance method called");
        loadFXML("/Kalpika/FinancialPerformance.fxml");
    }

    @FXML
    public void goToCustomerSatisfaction() {
        System.out.println("goToCustomerSatisfaction method called");
        loadFXML("/Kalpika/CustomerSatisfaction.fxml");
    }

    @FXML
    public void goToEmployeeDetails() {
        System.out.println("goToEmployeeDetails method called");
        loadFXML("/Kalpika/EmployeeDetails.fxml");
    }

    @FXML
    public void goToCollaborations() {
        System.out.println("goToCollaborations method called");
        loadFXML("/Kalpika/Collaborations.fxml");
    }

    @FXML
    public void goToMarketTrends() {
        System.out.println("goToMarketTrends method called");
        loadFXML("/Kalpika/MarketTrends.fxml");
    }

    @FXML
    public void goToOperationalEfficiency() {
        System.out.println("goToOperationalEfficiency method called");
        loadFXML("/Kalpika/OperationalEfficiency.fxml");
    }
    
    private void loadFXML(String fxmlPath) {
        Stage stage = (Stage) backButton.getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            System.out.println("FXML loaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading FXML: " + e.getMessage());
        }
    }
}
