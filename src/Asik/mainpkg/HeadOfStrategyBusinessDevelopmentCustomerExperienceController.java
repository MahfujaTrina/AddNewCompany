/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class HeadOfStrategyBusinessDevelopmentCustomerExperienceController implements Initializable {

    @FXML
    private TextField customerNameTextField;
    @FXML
    private TextField ageTextFileld;
    @FXML
    private RadioButton maleRadio;
    @FXML
    private RadioButton femaleRadio;
    @FXML
    private TextField exprienceTextField;
    @FXML
    private TableView<HeadOfStrategyBusinessDevelopmentCustomerExperienceTable> customerExprinceTable;
    @FXML
    private TableColumn<HeadOfStrategyBusinessDevelopmentCustomerExperienceTable, String> customerNameColumn;
    @FXML
    private TableColumn<HeadOfStrategyBusinessDevelopmentCustomerExperienceTable, String> ageColumn;
    @FXML
    private TableColumn<HeadOfStrategyBusinessDevelopmentCustomerExperienceTable, String> genderColumn;
    @FXML
    private TableColumn<HeadOfStrategyBusinessDevelopmentCustomerExperienceTable, String> exprienceColumn;

    private final ToggleGroup toggleGroup = new ToggleGroup();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        maleRadio.setToggleGroup(toggleGroup);
        femaleRadio.setToggleGroup(toggleGroup);
        
        
        customerNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("customerName")
        );
        ageColumn.setCellValueFactory(
                new PropertyValueFactory<>("age")
        );
        genderColumn.setCellValueFactory(
                new PropertyValueFactory<>("gender")
        );
        exprienceColumn.setCellValueFactory(
                new PropertyValueFactory<>("expriences")
        );
        
        
        
        
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("HeadOfStrategyBusinessDevelopmentDashboard.fxml"));
        Scene scene1= new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void AddButtonOnClick(ActionEvent event) {
        
        customerExprinceTable.getItems().add(new HeadOfStrategyBusinessDevelopmentCustomerExperienceTable(
                customerNameTextField.getText(),
                ageTextFileld.getText(),
                maleRadio.isSelected() ? "Male" : "Female",
                exprienceTextField.getText()));
        
    }
    
}
