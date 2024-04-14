package Kalpika;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class MarketTrendsController {

    @FXML
    private Button backButton;

    @FXML
    private TextArea trendsTextArea;

    @FXML
    public void initialize() {
        // Initialize the text area with some default text or leave it empty
        trendsTextArea.setText("Select a global economic trend to learn more.");
    }

    @FXML
    public void backToDashboard() {
        // Get the reference to the stage
        Stage stage = (Stage) backButton.getScene().getWindow();

        try {
            // Load the FXML file for the dashboard screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Kalpika/GMDashboard.fxml"));
            Parent root = loader.load();

            // Create a new scene
            Scene scene = new Scene(root);

            // Set the scene to the stage
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   @FXML
public void showInflation() {
    trendsTextArea.setText("Inflation:\n\n"
        + "Inflation refers to the rate at which the general level of prices for goods and services rises, leading to a decrease in the purchasing power of money. It is typically measured as an annual percentage increase in the Consumer Price Index (CPI) or other price indices.\n\n"
        + "Key Causes of Inflation:\n"
        + "1. Demand-Pull Inflation: When demand for goods and services exceeds supply, leading to increased prices.\n"
        + "2. Cost-Push Inflation: When production costs, such as wages and raw materials, rise, leading to increased prices.\n"
        + "3. Built-In Inflation: When expectations of future inflation lead workers to demand higher wages and businesses to raise prices.\n\n"
        + "Effects of Inflation:\n"
        + "1. Decreased Purchasing Power: Consumers can buy fewer goods and services with the same amount of money.\n"
        + "2. Interest Rates: Central banks may increase interest rates to combat inflation, affecting borrowing and saving rates.\n"
        + "3. Investment Decisions: Inflation can impact investment strategies, with investors seeking assets that provide returns higher than the inflation rate.\n\n"
        + "Strategies to Combat Inflation:\n"
        + "1. Monetary Policy: Central banks use tools like interest rates and reserve requirements to control the money supply.\n"
        + "2. Fiscal Policy: Governments can adjust taxation and government spending to manage inflation.\n"
        + "3. Wage and Price Controls: Temporary measures to limit wage increases and price hikes.\n\n"
        + "Global Trends in Inflation:\n"
        + "Inflation rates vary across countries and regions due to factors like economic growth, monetary policy, and external shocks. Monitoring inflation trends is crucial for policymakers, investors, and consumers to make informed decisions and manage financial risks.");
}


    @FXML
    public void showGlobalizationVsLocalization() {
        trendsTextArea.setText("Globalization vs. Localization:\n\n"
        + "Globalization and localization represent two contrasting trends in the global economy, affecting the way businesses operate, trade policies, and consumer preferences.\n\n"
        + "Globalization:\n"
        + "- Definition: The process by which businesses and other organizations develop international influence or start operating on an international scale.\n"
        + "- Key Features:\n"
        + "  1. Expansion of Global Supply Chains: Businesses source materials and labor from around the world to optimize costs.\n"
        + "  2. International Trade: Trade agreements and treaties promote free trade and economic integration among countries.\n"
        + "  3. Cultural Exchange: Sharing of ideas, values, and cultural practices across borders.\n\n"
        + "Localization:\n"
        + "- Definition: Adapting products, services, or content to meet the specific needs and preferences of a local market or culture.\n"
        + "- Key Features:\n"
        + "  1. Customization: Tailoring products and services to cater to local tastes, languages, and regulations.\n"
        + "  2. Community Engagement: Building relationships with local communities and supporting local economies.\n"
        + "  3. Regulatory Compliance: Adhering to local laws, standards, and cultural norms.\n\n"
        + "Impacts on Businesses and Consumers:\n"
        + "- Businesses:\n"
        + "  - Globalization allows businesses to access larger markets and achieve economies of scale.\n"
        + "  - Localization helps businesses build brand loyalty and trust among local consumers.\n"
        + "- Consumers:\n"
        + "  - Globalization provides consumers with a wider variety of products and services at competitive prices.\n"
        + "  - Localization ensures that consumers receive products and services that meet their specific needs and preferences.\n\n"
        + "Challenges and Controversies:\n"
        + "- Globalization:\n"
        + "  - Economic Inequality: Concerns about widening income disparities between wealthy and poor nations.\n"
        + "  - Cultural Homogenization: Loss of cultural diversity due to the dominance of global brands and values.\n"
        + "- Localization:\n"
        + "  - Higher Costs: Customizing products and services for local markets can increase production and operational costs.\n"
        + "  - Market Fragmentation: Differences in local regulations and consumer preferences can create barriers to market entry.\n\n"
        + "Future Trends:\n"
        + "The balance between globalization and localization is likely to continue shifting as businesses and governments adapt to changing economic conditions, technological advancements, and consumer behavior. Embracing a hybrid approach that combines the strengths of both globalization and localization is becoming increasingly important for sustainable growth in the global marketplace.");


    }

    @FXML
    public void showGeopoliticalEvents() {
       trendsTextArea.setText("Geopolitical Events:\n\n"
        + "Geopolitical events refer to political actions, conflicts, or disputes between nations that have significant impacts on global markets, trade relations, and investor confidence.\n\n"
        + "Types of Geopolitical Events:\n"
        + "- Political Conflicts: Wars, civil unrest, and political instability affecting countries or regions.\n"
        + "- Trade Disputes: Tariffs, sanctions, and trade wars between countries impacting international trade.\n"
        + "- Diplomatic Relations: Changes in diplomatic relations, alliances, or treaties influencing foreign policies.\n\n"
        + "Impacts on Global Markets:\n"
        + "- Stock Markets: Geopolitical events can lead to volatility in stock markets, affecting investor sentiment and stock prices.\n"
        + "- Currency Markets: Fluctuations in currency exchange rates due to geopolitical tensions or uncertainties.\n"
        + "- Commodity Prices: Geopolitical events can impact the prices of commodities like oil, gold, and agricultural products due to supply disruptions or demand changes.\n\n"
        + "Effects on Businesses:\n"
        + "- Supply Chain Disruptions: Businesses may face disruptions in their supply chains due to trade restrictions or political conflicts.\n"
        + "- Investment Decisions: Geopolitical uncertainties can influence investment decisions, with investors becoming more risk-averse or shifting investments to safer assets.\n"
        + "- Regulatory Changes: Changes in regulations or trade policies can affect business operations, compliance requirements, and profitability.\n\n"
        + "Strategies to Mitigate Risks:\n"
        + "- Diversification: Diversifying investments and supply chains to reduce dependency on a single market or region.\n"
        + "- Political Risk Insurance: Purchasing insurance to protect against losses due to political events or expropriation.\n"
        + "- Scenario Planning: Developing contingency plans and strategies to address potential geopolitical risks and uncertainties.\n\n"
        + "Future Outlook:\n"
        + "The geopolitical landscape is constantly evolving, with new challenges and uncertainties emerging over time. Businesses and investors need to stay informed,adapt to changes, and implement effective risk management strategies to navigate the complexities of geopolitical events and safeguard their interests.");


    }

   @FXML
public void showSustainableAviation() {
    trendsTextArea.setText("Sustainable Aviation:\n\n"
        + "Sustainable aviation focuses on reducing the environmental impact of air travel through various initiatives such as alternative fuels, fuel efficiency, carbon offsetting, and technological innovations.\n\n"
        + "Key Aspects:\n"
        + "1. Alternative Fuels\n"
        + "2. Fuel Efficiency\n"
        + "3. Carbon Offsetting\n"
        + "4. Technological Innovations\n"
        + "5. Regulatory Policies\n\n"
        + "Impact on the Industry:\n"
        + "- Costs\n"
        + "- Consumer Demand\n"
        + "- Competitive Advantage\n\n"
        + "Future Outlook:\n"
        + "The trend towards sustainable aviation is expected to continue growing as the industry strives to achieve net-zero emissions and environmental sustainability.");

}

    

    @FXML
    public void saveTrendsToFile() {
        String textToSave = trendsTextArea.getText();

        try {
            // Create a new FileOutputStream to write to a file named "trends.txt"
            FileOutputStream fileOut = new FileOutputStream("trends.txt");
            
            // Create an ObjectOutputStream to write objects to the FileOutputStream
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            
            // Write the text to the ObjectOutputStream
            objectOut.writeObject(textToSave);
            
            // Close the ObjectOutputStream and FileOutputStream
            objectOut.close();
            fileOut.close();
            
            System.out.println("Text saved successfully to trends.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
