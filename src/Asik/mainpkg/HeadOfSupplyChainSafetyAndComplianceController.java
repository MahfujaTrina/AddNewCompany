/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rttit
 */
public class HeadOfSupplyChainSafetyAndComplianceController implements Initializable {

    @FXML
    private TextField NameTextField;
    @FXML
    private TextField numberTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private ComboBox<String> safetyComboBox;
    @FXML
    private TableView<HeadOfSupplyChainSafetyAndComplianceTable> safeAndComplianceTableView;
    @FXML
    private TableColumn<HeadOfSupplyChainSafetyAndComplianceTable, String> nameColumn;
    @FXML
    private TableColumn<HeadOfSupplyChainSafetyAndComplianceTable, Integer> numberColumn;
    @FXML
    private TableColumn<HeadOfSupplyChainSafetyAndComplianceTable, String> emailColumn;
    @FXML
    private TableColumn<HeadOfSupplyChainSafetyAndComplianceTable, String> safetyColumn;

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        safetyComboBox.getItems().addAll(
                "Regulatory Compliance",
                "Safety Management Systems (SMS)",
                "Pilot and Crew Training",
                "Emergency Response and Contingency Planning",
                "Supplier and Vendor Compliance",
                "Safety Equipment and Technology");
        
/*        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        numberColumn.setCellValueFactory(
                new PropertyValueFactory<>("number")
        );
        emailColumn.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );
        safetyColumn.setCellValueFactory(
                new PropertyValueFactory<>("safety")
        );
*/
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("HeadOfSupplyChainDashboard.fxml"));
        Scene scene1= new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();    }

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        
 /*       int numbers = Integer.parseInt(numberTextField.getText());
        
        safeAndComplianceTableView.getItems().add(new HeadOfSupplyChainSafetyAndComplianceTable(
                NameTextField.getText(),
                numbers,
                emailTextField.getText(),
                safetyComboBox.getValue()
        ));
        */
        int num = Integer.parseInt(numberTextField.getText());
        HeadOfSupplyChainSafetyAndComplianceTable i = new HeadOfSupplyChainSafetyAndComplianceTable(
                NameTextField.getText(), 
                num,
                emailTextField.getText(),
                safetyComboBox.getValue());
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("safety.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(i);
            System.out.println("write object sucessfull ");

        } catch (IOException ex) {
            Logger.getLogger(HeadOfSupplyChainSafetyAndComplianceController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HeadOfSupplyChainSafetyAndComplianceController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        ObservableList<HeadOfSupplyChainSafetyAndComplianceTable> venueschedules = FXCollections.observableArrayList();
        
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            safetyColumn.setCellValueFactory(new PropertyValueFactory<>("safety"));
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("safety.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            HeadOfSupplyChainSafetyAndComplianceTable p;
            try {
                while (true) {
                    p = (HeadOfSupplyChainSafetyAndComplianceTable) ois.readObject();
                    venueschedules.add(p);
                }
            } catch (Exception e) {
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        safeAndComplianceTableView.setItems(venueschedules);
        
    }

    @FXML
    private void clearButtonOnClick(ActionEvent event) {
        
        NameTextField.clear();
        numberTextField.clear();
        emailTextField.clear();
        safetyComboBox.setValue(null);
    }

    @FXML
    private void deleteButtonOnClick(ActionEvent event) {
        ObservableList<HeadOfSupplyChainSafetyAndComplianceTable> selectedBudget, allschedule;
        allschedule = safeAndComplianceTableView.getItems();
        selectedBudget = safeAndComplianceTableView.getSelectionModel().getSelectedItems();
        selectedBudget.forEach(allschedule::remove);
        
    }
    
}
