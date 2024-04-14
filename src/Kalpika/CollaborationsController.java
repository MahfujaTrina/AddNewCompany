package Kalpika;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class CollaborationsController {

    @FXML
    private Button updateButton;

    @FXML
    private Button backButton;

    @FXML
    private Label sharedFlightsLabel;

    @FXML
    private Label codeshareAgreementsLabel;

    @FXML
    private Label jointMarketingLabel;

    @FXML
    private Label expensesByPartnerLabel;

    @FXML
    private Label totalExpensesLabel;

    @FXML
    private Label roiLabel;

    @FXML
    private TextField sharedFlightsInput;

    @FXML
    private TextField codeshareAgreementsInput;

    @FXML
    private TextField jointMarketingInput;

    @FXML
    private TextField expensesByPartnerInput;

    @FXML
    private TextField totalExpensesInput;

    @FXML
    private TextField roiInput;

    // Instance variables to store last valid percentages
    private double lastSharedFlightsPercentage = 100;
    private double lastCodeshareAgreementsPercentage = 100;
    private double lastJointMarketingPercentage = 100;
    private double lastExpensesByPartnerPercentage = 100;
    private double lastTotalExpensesPercentage = 100;
    private double lastRoiPercentage = 100;

    @FXML
    public void initialize() {
        // Set initial values
        setLabelAndInputText(sharedFlightsLabel, sharedFlightsInput, lastSharedFlightsPercentage);
        setLabelAndInputText(codeshareAgreementsLabel, codeshareAgreementsInput, lastCodeshareAgreementsPercentage);
        setLabelAndInputText(jointMarketingLabel, jointMarketingInput, lastJointMarketingPercentage);
        setLabelAndInputText(expensesByPartnerLabel, expensesByPartnerInput, lastExpensesByPartnerPercentage);
        setLabelAndInputText(totalExpensesLabel, totalExpensesInput, lastTotalExpensesPercentage);
        setLabelAndInputText(roiLabel, roiInput, lastRoiPercentage);
    }

    @FXML
    public void updatePercentages() {
        updateLabel(sharedFlightsLabel, sharedFlightsInput.getText(), "sharedFlights");
        updateLabel(codeshareAgreementsLabel, codeshareAgreementsInput.getText(), "codeshareAgreements");
        updateLabel(jointMarketingLabel, jointMarketingInput.getText(), "jointMarketing");
        updateLabel(expensesByPartnerLabel, expensesByPartnerInput.getText(), "expensesByPartner");
        updateLabel(totalExpensesLabel, totalExpensesInput.getText(), "totalExpenses");
        updateLabel(roiLabel, roiInput.getText(), "roi");
    }

    @FXML
    public void goBack() {
        try {
            // Load the dashboard FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Kalpika/GMDashboard.fxml"));
            Parent root = loader.load();

            // Create a new scene
            Scene scene = new Scene(root);

            // Get the current stage and set the new scene
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setLabelAndInputText(Label label, TextField textField, double percentage) {
        label.setText(String.format("%.2f%%", percentage));
        textField.setText(String.format("%.2f", percentage));
        setColorCodedIndicator(label, percentage);
    }

    private void updateLabel(Label label, String input, String labelType) {
        try {
            double percentage = Double.parseDouble(input);
            if (percentage >= 0 && percentage <= 100) {
                label.setText(String.format("%.2f%%", percentage));
                setColorCodedIndicator(label, percentage);
                
                // Update last valid percentage
                updateLastPercentage(labelType, percentage);
            } else {
                // Reset to last valid value if input is invalid
                label.setText(String.format("%.2f%%", getLastPercentage(labelType)));
                setColorCodedIndicator(label, getLastPercentage(labelType));
            }
        } catch (NumberFormatException e) {
            // Reset to last valid value if input is not a valid number
            label.setText(String.format("%.2f%%", getLastPercentage(labelType)));
            setColorCodedIndicator(label, getLastPercentage(labelType));
        }
    }

    private void updateLastPercentage(String labelType, double percentage) {
        switch (labelType) {
            case "sharedFlights":
                lastSharedFlightsPercentage = percentage;
                sharedFlightsInput.setText(String.format("%.2f", percentage));
                break;
            case "codeshareAgreements":
                lastCodeshareAgreementsPercentage = percentage;
                codeshareAgreementsInput.setText(String.format("%.2f", percentage));
                break;
            case "jointMarketing":
                lastJointMarketingPercentage = percentage;
                jointMarketingInput.setText(String.format("%.2f", percentage));
                break;
            case "expensesByPartner":
                lastExpensesByPartnerPercentage = percentage;
                expensesByPartnerInput.setText(String.format("%.2f", percentage));
                break;
            case "totalExpenses":
                lastTotalExpensesPercentage = percentage;
                totalExpensesInput.setText(String.format("%.2f", percentage));
                break;
            case "roi":
                lastRoiPercentage = percentage;
                roiInput.setText(String.format("%.2f", percentage));
                break;
        }
    }

    private double getLastPercentage(String labelType) {
        switch (labelType) {
            case "sharedFlights":
                return lastSharedFlightsPercentage;
            case "codeshareAgreements":
                return lastCodeshareAgreementsPercentage;
            case "jointMarketing":
                return lastJointMarketingPercentage;
            case "expensesByPartner":
                return lastExpensesByPartnerPercentage;
            case "totalExpenses":
                return lastTotalExpensesPercentage;
            case "roi":
                return lastRoiPercentage;
            default:
                return 100; // default value
        }
    }

    private void setColorCodedIndicator(Label label, double percentage) {
        if (percentage >= 70) {
            label.setTextFill(Color.GREEN);
        } else if (percentage >= 40) {
            label.setTextFill(Color.YELLOW);
        } else {
            label.setTextFill(Color.RED);
        }
    }
}
