import java.util.ArrayList;

public class StockPredictor {
//    ○ Predicts when stock will run out based on average daily sales.
//    ○ Suggests a restocking strategy.
    private Product product;
    private double averageDailySales;


    // Constructor
    public StockPredictor(Product product, double averageDailySales) {
        this.product = product;
        this.averageDailySales = averageDailySales;
    }

    // Method to predict days until stock runs out
    public int calculateDaysUntilStockOut() {
        if (averageDailySales <= 0) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.ceil(product.getStockLevel() / averageDailySales);
    }

    // Method to suggest restocking strategy
    public String suggestRestockingStrategy() {
        int daysUntilOutOfStock = calculateDaysUntilStockOut();
        if (daysUntilOutOfStock <= product.getReorderThreshold()) {
            return "High: Restock immediately!";
        } else if (daysUntilOutOfStock <= product.getReorderThreshold() * 2) {
            return "Moderate: Consider restocking soon.";
        } else {
            return "Low: Stock level is sufficient.";
        }
    }

    // Display stock prediction
    public void displayStockPrediction() {
        System.out.println("Stock Prediction for " + product.getName() + ":");
        int days = calculateDaysUntilStockOut();
        String suggestion = suggestRestockingStrategy();

        System.out.println("Days until stock out: " + (days == Integer.MAX_VALUE ? "N/A" : days));
        System.out.println("Restock Suggestion: " + suggestion);
    }

}
