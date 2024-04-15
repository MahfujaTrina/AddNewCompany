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

import java.io.*;

public class BusinessOperationsController {

    @FXML
    private Button backButton;

    @FXML
    private Button loadButton;

    @FXML
    private PieChart safetyCompliancePieChart;

    @FXML
    public void initialize() {
        safetyCompliancePieChart.setData(getInitialChartData());
    }

    @FXML
    public void loadChartData() {
        safetyCompliancePieChart.setData(getChartData());
    }

    @FXML
    public void saveChartData() {
        ObservableList<PieChart.Data> chartData = safetyCompliancePieChart.getData();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("chartData.ser"))) {
            oos.writeObject(chartData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadChartDataFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("chartData.ser"))) {
            ObservableList<PieChart.Data> loadedData = (ObservableList<PieChart.Data>) ois.readObject();
            safetyCompliancePieChart.setData(loadedData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void backToDashboard() {
        Stage stage = (Stage) backButton.getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Kalpika/AvCEO Dashboard.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ObservableList<PieChart.Data> getChartData() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Production or Manufacturing: ", 47),
                new PieChart.Data("Sales and Marketing:", 97),
                new PieChart.Data("Administration and Overheads:", 75),
                new PieChart.Data("Supply Chain and Logistics:", 98),
                new PieChart.Data("Technology and IT", 66)
        );

        return pieChartData;
    }

    private ObservableList<PieChart.Data> getInitialChartData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("chartData.ser"))) {
            return (ObservableList<PieChart.Data>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return getChartData();
        }
    }
}
