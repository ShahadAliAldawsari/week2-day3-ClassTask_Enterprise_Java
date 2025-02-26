import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrderManager {
//    ○ Processes new orders.
//    ○ Automatically updates order status using multithreading using
//Java's ExecutorService.
//    ○ Logs each order update.

    private List<Product> products = new ArrayList<>();

    //List of all orders.
    // Add some products to the inventory
    public void initializeProducts() {
        products.add(new Product("Laptop", 1200.0, 20, 5));
        products.add(new Product("Smartphone", 800.0, 10, 3));
    }

    // Display all products
    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Collect average daily sales from the user
    public void collectSalesData() {
        Scanner scanner = new Scanner(System.in);
        for (Product product : products) {
            System.out.print("Enter average daily sales for " + product.getName() + ": ");
            double sales = scanner.nextDouble();
            StockPredictor predictor = new StockPredictor(product, sales);
            predictor.displayStockPrediction();
            System.out.println("----------------------------");
        }
        scanner.close();
    }

}
