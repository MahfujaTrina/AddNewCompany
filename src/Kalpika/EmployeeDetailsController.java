package Kalpika;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeDetailsController {

    @FXML
    private TextField sectorFilterField;

    @FXML
    private TableView<Employee> employeeTableView;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> sectorColumn;

    @FXML
    private TableColumn<Employee, LocalDate> joiningDateColumn;

    @FXML
    private Button backButton;

    private List<Employee> allEmployees;

    private final String[] names = {
        "Anil", "Chayan", "Aratrika", "Jenifer", "Rifat", 
        "Krish", "Asif", "Rana", "Niladri", "Limon","Mahfuja", "Lakshmi", "Mira", "Neha", "Nirav", "Pranav",
    "Raj", "Riya", "Rohan", "Sagar", "Shreya",
    "Siddharth", "Sneha", "Subhash", "Tanisha"
    };

    public void initialize() {
        // Initialize TableView columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        sectorColumn.setCellValueFactory(new PropertyValueFactory<>("sector"));
        joiningDateColumn.setCellValueFactory(new PropertyValueFactory<>("joiningDate"));

        // Sample data for employees
        allEmployees = new ArrayList<>();

        Random random = new Random();
        
        // Add IT Employees
        for (int i = 1; i <= 5; i++) {
            allEmployees.add(new Employee(names[random.nextInt(names.length)], LocalDate.of(2023, 2, 10).minusYears(1), "IT"));
        }
        
        // Add Aviation Employees
        for (int i = 1; i <= 5; i++) {
            allEmployees.add(new Employee(names[random.nextInt(names.length)], LocalDate.of(2023, 5,18).minusYears(1), "Aviation"));
        }
        
        // Add Supply Chain Employees
        for (int i = 1; i <= 5; i++) {
            allEmployees.add(new Employee(names[random.nextInt(names.length)], LocalDate.now().minusYears(1), "Supply Chain"));
        }
        
        // Add Finance Employees
        for (int i = 1; i <= 5; i++) {
            allEmployees.add(new Employee(names[random.nextInt(names.length)], LocalDate.now().minusYears(1), "Finance"));
        }
        
        // Add Accounts Employees
        for (int i = 1; i <= 5; i++) {
            allEmployees.add(new Employee(names[random.nextInt(names.length)], LocalDate.now().minusYears(1), "Accounts"));
        }

        employeeTableView.getItems().addAll(allEmployees);
    }

    @FXML
    public void handleFilter() {
        String filter = sectorFilterField.getText().trim();
        List<Employee> filteredEmployees = new ArrayList<>();

        if (!filter.isEmpty()) {
            for (Employee employee : allEmployees) {
                if (employee.getSector().equalsIgnoreCase(filter)) {
                    filteredEmployees.add(employee);
                }
            }
        } else {
            filteredEmployees.addAll(allEmployees);
        }

        employeeTableView.getItems().setAll(filteredEmployees);
    }

    @FXML
    public void backToDashboard() {
        Stage stage = (Stage) backButton.getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Kalpika/GMDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Employee {
        private String name;
        private LocalDate joiningDate;
        private String sector;

        public Employee(String name, LocalDate joiningDate, String sector) {
            this.name = name;
            this.joiningDate = joiningDate;
            this.sector = sector;
        }

        public String getName() {
            return name;
        }

        public LocalDate getJoiningDate() {
            return joiningDate;
        }

        public String getSector() {
            return sector;
        }
    }
}
