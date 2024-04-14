package Kalpika;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

public class OperationalEfficiencyController {

    @FXML
    private Button backButton;

    @FXML
    private Button automationButton;

    @FXML
    private Label automationInfoLabel;

    @FXML
public void displayAutomationInfo() {
    System.out.println("Info button clicked");  // Debug line
    try {
        String maintenanceInfo = generateMaintenanceInfo();
        automationInfoLabel.setText(maintenanceInfo);
        saveMaintenanceInfo(maintenanceInfo);
    } catch (Exception e) {
        System.out.println("Error displaying automation info: " + e.getMessage());
        e.printStackTrace();
    }
}


    private String generateMaintenanceInfo() {
        Random rand = new Random();
        int totalTasks = rand.nextInt(50) + 20;
        int completedTasks = rand.nextInt(totalTasks + 1);
        int ongoingTasks = totalTasks - completedTasks;

        String data = "Ongoing Maintenance Activities:\n\n";
        data += "Total Maintenance Tasks: " + totalTasks + "\n";
        data += "Completed Maintenance Tasks: " + completedTasks + "\n";
        data += "Ongoing Maintenance Tasks: " + ongoingTasks + "\n";

        for (int i = 1; i <= ongoingTasks; i++) {
            int status = rand.nextInt(3);
            data += "Task " + i + ": ";
            switch (status) {
                case 0:
                    data += "Scheduled\n";
                    break;
                case 1:
                    data += "In Progress\n";
                    break;
                case 2:
                    data += "Pending\n";
                    break;
            }
        }

        return data;
    }

    private void saveMaintenanceInfo(String maintenanceInfo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("maintenanceInfo.dat"))) {
            oos.writeObject(maintenanceInfo);
            System.out.println("Maintenance info saved to maintenanceInfo.dat");
        } catch (IOException e) {
            System.out.println("Error saving maintenance info: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void backToDashboard() {
        System.out.println("Back button clicked");  // Debug line
        Stage stage = (Stage) backButton.getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Kalpika/GMDashboard.fxml"));
            Parent root = loader.load();
            System.out.println("Loaded FXML: " + root);  // Debug line

            Scene scene = new Scene(root);

            stage.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error loading dashboard: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
