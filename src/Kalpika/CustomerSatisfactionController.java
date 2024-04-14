package Kalpika;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CustomerSatisfactionController {

    @FXML
    private Button backButton;
    
    @FXML
    private TextField yearInput;

    @FXML
    private TableView<CustomerIntegrity> integrityTable;
    
    @FXML
    private TableColumn<CustomerIntegrity, Integer> yearColumn;

    @FXML
    private TableColumn<CustomerIntegrity, Double> integrityPercentageColumn;

    @FXML
    private TableColumn<CustomerIntegrity, Integer> numberOfFlightsColumn;

    private ObservableList<CustomerIntegrity> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        integrityPercentageColumn.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        numberOfFlightsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfFlights"));
        
        // Sample data for demonstration
        data.add(new CustomerIntegrity(2022, 75.5, 80));
        data.add(new CustomerIntegrity(2021, 68.3, 81));
        data.add(new CustomerIntegrity(2013, 66.7, 24));
        data.add(new CustomerIntegrity(2014, 58.5, 37));
        data.add(new CustomerIntegrity(2015, 67.3, 41));
        data.add(new CustomerIntegrity(2016, 71.7, 46));
        data.add(new CustomerIntegrity(2017, 73.5, 55));
        data.add(new CustomerIntegrity(2018, 79.3, 54));
        data.add(new CustomerIntegrity(2019, 80.7, 58));
        data.add(new CustomerIntegrity(2020, 83.5, 66));
        data.add(new CustomerIntegrity(2021, 81.3, 79));
        data.add(new CustomerIntegrity(2023, 91.7, 87));
        integrityTable.setItems(data);
    }

    @FXML
    public void backToDashboard() {
        Stage stage = (Stage) backButton.getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Kalpika/GMDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void filterData() {
        String userInput = yearInput.getText().trim();
        
        ObservableList<CustomerIntegrity> filteredData = FXCollections.observableArrayList();

        if (userInput.isEmpty()) {
            for (int year = 2013; year <= 2022; year++) {
                for (CustomerIntegrity item : data) {
                    if (item.getYear() == year) {
                        filteredData.add(item);
                        break;
                    }
                }
            }
        } else {
            try {
                int year = Integer.parseInt(userInput);
                for (CustomerIntegrity item : data) {
                    if (item.getYear() == year) {
                        filteredData.add(item);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid year input");
            }
        }
        
        integrityTable.setItems(filteredData);
    }
}
