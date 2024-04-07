package Kalpika;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.collections.FXCollections; // Import FXCollections class
import java.io.IOException;
import java.util.Random;
import java.util.Arrays; // Import Arrays class

public class OrgperController {

    @FXML
    private Button backButton;

    @FXML
    private LineChart<String, Number> performanceChart;

    @FXML
    public void initialize() {
        // Set up the x-axis with labels
        CategoryAxis xAxis = new CategoryAxis(); // Use CategoryAxis for custom categories
        xAxis.setLabel("Sector");

        // Set up the y-axis with labels
        NumberAxis yAxis = new NumberAxis(2019, 2023, 1); // Year range from 2019 to 2023
        yAxis.setLabel("Year");

        // Assigning custom categories to x-axis
        String[] categories = {"Aviation CEO", "Accounts", "Supply Chain", "Strategy", "Business"};
        xAxis.setCategories(FXCollections.observableArrayList(Arrays.asList(categories)));

        // Add random data to the chart (just for demonstration)
        Random random = new Random();
        for (int i = 2019; i <= 2023; i++) {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(String.valueOf(i));
            for (String category : categories) {
                series.getData().add(new XYChart.Data<>(category, random.nextInt(100)));
            }
            // Add series to the chart
            performanceChart.getData().add(series);
        }
    }

    @FXML
    public void goBackToDashboard() {
        // Get the reference to the stage
        Stage stage = (Stage) backButton.getScene().getWindow();

        try {
            // Load the FXML file for the Dashboard screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Kalpika/Dashboard.fxml"));
            Parent root = loader.load();

            // Create a new scene
            Scene scene = new Scene(root);

            // Set the scene to the stage
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Unable to load Dashboard.fxml");
        }
    }
}
