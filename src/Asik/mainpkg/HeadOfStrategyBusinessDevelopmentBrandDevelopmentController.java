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
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
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
public class HeadOfStrategyBusinessDevelopmentBrandDevelopmentController implements Initializable {

    @FXML
    private TextField helicopterNameTextField;
    @FXML
    private ComboBox<String> helicopterBrandComboBox;
    @FXML
    private ComboBox<String> priceComboBox;
    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private TableView<HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable> brandDevelopmentTable;
    @FXML
    private TableColumn<HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable, String> helicopterNameColumn;
    @FXML
    private TableColumn<HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable, String> helicopterBrandColumn;
    @FXML
    private TableColumn<HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable, String> priceColumn;
    @FXML
    private TableColumn<HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable, LocalDate> dateColumn;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        helicopterBrandComboBox.getItems().addAll(
                "Airbus Helicopters",
                "Bell Helicopter",
                "Robinson Helicopter Company",
                "Leonardo Helicopters",
                "Kaman Aerospace",
                "AugustaWestland");
        priceComboBox.getItems().addAll(
                "$250,000",
                "$400,000",
                "$700,000.",
                "2 million",
                "7 million",
                "8 million");
        
    }    

    @FXML
    private void AddListButtonOnClick(ActionEvent event) {
       
        
        HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable i = new HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable(
                helicopterNameTextField.getText(), 
                helicopterBrandComboBox.getValue(),
                priceComboBox.getValue(),
                dateDatePicker.getValue());
                
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = null;
        try {
            f = new File("Brand.bin");
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
            Logger.getLogger(HeadOfStrategyBusinessDevelopmentBrandDevelopmentController.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(HeadOfStrategyBusinessDevelopmentBrandDevelopmentController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        ObservableList<HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable> venueschedules = FXCollections.observableArrayList();
        
            helicopterNameColumn.setCellValueFactory(new PropertyValueFactory<>("helicopterName"));
            helicopterBrandColumn.setCellValueFactory(new PropertyValueFactory<>("helicopterBrand"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Brand.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable p;
            try {
                while (true) {
                    p = (HeadOfStrategyBusinessDevelopmentBrandDevelopmentTable) ois.readObject();
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
        brandDevelopmentTable.setItems(venueschedules);
        
        
    }

    @FXML
    private void clearButtonOnClick(ActionEvent event) {
                helicopterNameTextField.clear();
                helicopterBrandComboBox.setValue(null);
                priceComboBox.setValue(null);
                dateDatePicker.setValue(null);
                
                
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("HeadOfStrategyBusinessDevelopmentDashboard.fxml"));
        Scene scene1= new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
}
