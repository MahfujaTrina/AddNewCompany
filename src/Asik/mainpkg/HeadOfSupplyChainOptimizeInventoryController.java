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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rttit
 */
public class HeadOfSupplyChainOptimizeInventoryController implements Initializable {

    @FXML
    private ComboBox<String> sparePartsComboBox;
    @FXML
    private ComboBox<String> eqquipmentComboBox;
    @FXML
    private ComboBox<String> suppliesComboBox;
    @FXML
    private TableView<HeadOfSupplyChainOptimizeInventoryTable> OptimizeInventoryTable;
    @FXML
    private TableColumn<HeadOfSupplyChainOptimizeInventoryTable, String> SparePaertsColumn;
    @FXML
    private TableColumn<HeadOfSupplyChainOptimizeInventoryTable, String> eqquipmentColumn;
    @FXML
    private TableColumn<HeadOfSupplyChainOptimizeInventoryTable, String> soppliesColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sparePartsComboBox.getItems().addAll(
                "Airframe",
                "Fuselage",
                "Landing gear",
                "Powerplant",
                "Transmission",
                "Main rotor system");
        
        eqquipmentComboBox.getItems().addAll(
                "Rotor System",
                "Engine",
                "Flight Controls",
                "Landing Gear",
                "Electrical System",
                "Hydraulic System");
        suppliesComboBox.getItems().addAll(
                "Maintenance and Repair Tools",
                "Fluids and Lubricants",
                "Fasteners and Hardware",
                "Airframe Components",
                "Filters and Filtration Systems",
                "Electrical Components");
        
        SparePaertsColumn.setCellValueFactory(
                new PropertyValueFactory<>("spare_Paerts")
        );
        eqquipmentColumn.setCellValueFactory(
                new PropertyValueFactory<>("eqquipment")
        );
        soppliesColumn.setCellValueFactory(
                new PropertyValueFactory<>("supplies")
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
    private void AddButtonOnClick(ActionEvent event) {
        
        OptimizeInventoryTable.getItems().add(new HeadOfSupplyChainOptimizeInventoryTable(
                sparePartsComboBox.getValue(),
                eqquipmentComboBox.getValue(),
                suppliesComboBox.getValue()));
    }
    
}
