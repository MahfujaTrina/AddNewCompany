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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rttit
 */
public class HeadOfStrategyBusinessDevelopmentCostOptimizationController implements Initializable {

    @FXML
    private Button loadlineChartFxId;
    @FXML
    private LineChart<String, Number> lineChartFxId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void loadPieChartButtonOnClick(ActionEvent event) {
        lineChartFxId.getData().clear();
        XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
        series1.getData().add(new XYChart.Data<String,Number>("Jan",20000000));
        series1.getData().add(new XYChart.Data<String,Number>("Feb",50000000));
        series1.getData().add(new XYChart.Data<String,Number>("Mar",30000000));
        series1.getData().add(new XYChart.Data<String,Number>("Apr",60000000));
        series1.setName("Month-1");
        
        XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
        series2.getData().add(new XYChart.Data<String,Number>("Jan",40000000));
        series2.getData().add(new XYChart.Data<String,Number>("Feb",10000000));
        series2.getData().add(new XYChart.Data<String,Number>("Mar",80000000));
        series2.getData().add(new XYChart.Data<String,Number>("Apr",50000000));
        series2.setName("Month-2");
        
        XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
        series3.getData().add(new XYChart.Data<String,Number>("Jan",50000000));
        series3.getData().add(new XYChart.Data<String,Number>("Feb",90000000));
        series3.getData().add(new XYChart.Data<String,Number>("Mar",45000000));
        series3.getData().add(new XYChart.Data<String,Number>("Apr",65000000));
        series3.setName("Month-3");
        
        lineChartFxId.getData().addAll(series1,series2,series3);
        
    }
    
}
