package Kalpika;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class SafetyAndComplianceController {

    @FXML
    private Button backButton;

    @FXML
    private Button loadButton;

    @FXML
    private PieChart safetyCompliancePieChart;

    @FXML
    public void initialize() {
        // Do not load the chart data initially, wait for the load button press
    }

    @FXML
    public void loadChartData() {
        safetyCompliancePieChart.setData(getChartData());
    }

    @FXML
    public void backToDashboard() {
        // Get the reference to the stage
        Stage stage = (Stage) backButton.getScene().getWindow();

        try {
            // Load the FXML file for the dashboard screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Kalpika/GMDashboard.fxml"));
            Parent root = loader.load();

            // Create a new scene
            Scene scene = new Scene(root);

            // Set the scene to the stage
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ObservableList<PieChart.Data> getChartData() {
        // Create an ObservableList of PieChart.Data
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("SMS", 89), // Safety Management System
                new PieChart.Data("Training", 97), // Training and Education
                new PieChart.Data("Maintenance", 75), // Maintenance and Inspections
                new PieChart.Data("Emergency", 98), // Emergency Preparedness
                new PieChart.Data("Compliance", 66) // Regulatory Compliance
        );

        return pieChartData;
    }
}
