package Kalpika;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class FinancialPerformanceController {

    @FXML
    private Button backButton;

    @FXML
    private ListView<String> financialListView;

    @FXML
    public void initialize() {
        System.out.println("Initializing ListView...");

        // Generate random costs for each financial metric
        double revenue = getRandomCost(50000, 100000);
        double cogs = getRandomCost(20000, 50000);
        double grossProfit = revenue - cogs;
        double operatingExpenses = getRandomCost(10000, 30000);
        double operatingIncome = grossProfit - operatingExpenses;
        double netIncome = operatingIncome; // Assuming no other deductions for simplicity

        ObservableList<String> financialData = FXCollections.observableArrayList(
                "Revenue: $" + String.format("%.2f", revenue),
                "Cost of Flights(COFS): $" + String.format("%.2f", cogs),
                "Gross Profit: $" + String.format("%.2f", grossProfit),
                "Operating Expenses: $" + String.format("%.2f", operatingExpenses),
                "Operating Income: $" + String.format("%.2f", operatingIncome),
                "Net Income: $" + String.format("%.2f", netIncome)
        );

        financialListView.setItems(financialData);

        // Debugging to check items in ListView
        System.out.println("Items in ListView: " + financialListView.getItems());
    }

    private double getRandomCost(double min, double max) {
        return min + (Math.random() * (max - min));
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

            // Save financialData to a file using ObjectOutputStream
            saveFinancialData(financialListView.getItems(), "financialData.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFinancialData(ObservableList<String> data, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Write the ObservableList to the ObjectOutputStream
            oos.writeObject(data);

            oos.close();
            fos.close();
            System.out.println("Financial data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
