package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rttit
 */
public class HeadOfSupplyChainEmergencyHelpController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private ComboBox<String> emergencyHelpComboBox;
    @FXML
    private TableView<HeadOfSupplyChainEmergencyHelpTableView> SupplyEmergencyHelpTable;
    @FXML
    private TableColumn<HeadOfSupplyChainEmergencyHelpTableView, String> nameColumn;
    @FXML
    private TableColumn<HeadOfSupplyChainEmergencyHelpTableView, Integer> ageColumn;
    @FXML
    private TableColumn<HeadOfSupplyChainEmergencyHelpTableView, String> genderColumn;
    @FXML
    private TableColumn<HeadOfSupplyChainEmergencyHelpTableView, String> emergencyHelpColumn;
    
    
    private final ToggleGroup toggleGroup = new ToggleGroup();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        maleRadioButton.setToggleGroup(toggleGroup);
        femaleRadioButton.setToggleGroup(toggleGroup);
        
        emergencyHelpComboBox.getItems().addAll(
                "Mechanical Failure",
                "Adverse Weather Conditions",
                "Fuel Exhaustion",
                "Terrorist Threat",
                "Medical Emergency");
        
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        ageColumn.setCellValueFactory(
                new PropertyValueFactory<>("age")
        );
        genderColumn.setCellValueFactory(
                new PropertyValueFactory<>("gender")
        );
        emergencyHelpColumn.setCellValueFactory(
                new PropertyValueFactory<>("emergencyHelp")
        );
        
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("HeadOfSupplyChainDashboard.fxml"));
        Scene scene1= new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void addToTheEmergencyHelpButtonOnClick(ActionEvent event) {
        
        int age = Integer.parseInt(ageTextField.getText());
        
        SupplyEmergencyHelpTable.getItems().add(new HeadOfSupplyChainEmergencyHelpTableView(
                nameTextField.getText(),
                age,
                maleRadioButton.isSelected() ? "Male" : "Female",
                emergencyHelpComboBox.getValue()
        ));
    }

    @FXML
    private void deleteButtonOnClick(ActionEvent event) {
        ObservableList<HeadOfSupplyChainEmergencyHelpTableView> selectedBudget, allHelp;
        allHelp = SupplyEmergencyHelpTable.getItems();
        selectedBudget = SupplyEmergencyHelpTable.getSelectionModel().getSelectedItems();
        selectedBudget.forEach(allHelp::remove);
    }
    
}
