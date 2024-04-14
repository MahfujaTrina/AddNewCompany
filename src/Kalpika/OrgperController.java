package Kalpika;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OrgperController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private Button loadButton;
    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the bar chart
        xAxis.setLabel("Departments");
        yAxis.setLabel("Performance");
    }

    @FXML
    private void loadBarChartOnClick(ActionEvent event) {
        // Create the series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("IT", 65));
        series.getData().add(new XYChart.Data<>("Accounts", 70));
        series.getData().add(new XYChart.Data<>("Finance", 78));
        series.getData().add(new XYChart.Data<>("Aviation", 88));
        series.getData().add(new XYChart.Data<>("Supply Chain", 84));

        // Add series to the bar chart
        barChart.getData().add(series);
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GMDashboard.fxml"));
            Parent root = loader.load();

            // Get the stage from the event source
            Stage stage = (Stage) backButton.getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
