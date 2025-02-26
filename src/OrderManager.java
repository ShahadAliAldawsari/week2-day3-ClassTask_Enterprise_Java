import java.io.*;
import java.util.*;
import java.util.concurrent.*;

// OrderManager class to manage orders
public class OrderManager {
    private final List<Order> orders; // List to store orders
    private final List<Product> products; // List to store products
    private final ExecutorService executorService; // ExecutorService for multi-threading
    private final String ORDER_FILE = "orders.txt"; // File for data persistence

    // Constructor initializes the order list, product list, and thread pool
    public OrderManager() {
        orders = new ArrayList<>();
        products = new ArrayList<>();
        executorService = Executors.newFixedThreadPool(5); // Pool with 5 threads
        loadOrdersFromFile(); // Load orders from file at startup
    }

    // Method to add a product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to get all the products
    public List<Product> getProducts() {
        return products;
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

    // Method to place an order
    public synchronized void placeOrder(String customerName, UUID productId, int quantity) {
        Optional<Product> productOpt = products.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst();

        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            if (product.getStockLevel() >= quantity) {
                product.setStockLevel(product.getStockLevel() - quantity);
                Order order = new Order(customerName, productId, quantity);
                orders.add(order);
                saveOrdersToFile(); // Save order to file
                processOrder(order); // Process order in background
            } else {
                System.out.println("Insufficient stock for " + product.getName());
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to process an order in a separate thread
    private void processOrder(Order order) {
        executorService.submit(() -> {
            try {
                System.out.println("Processing order: " + order.getOrderId());
                Thread.sleep(2000); // Simulating order processing delay
                synchronized (order) {
                    order.setStatus(Status.SHIPPED);
                    saveOrdersToFile();
                }
                System.out.println("Order shipped: " + order.getOrderId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Order processing interrupted: " + order.getOrderId());
            }
        });
    }

    // Display all products
    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Display all orders
    public void displayOrders() {
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Customer: " + order.getCustomerName());
            System.out.println("Product ID: " + order.getProductId());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("Status: " + order.getStatus());
            System.out.println("----------------------------");
        }
    }

    // Save orders to a file
    private synchronized void saveOrdersToFile() {
        try (FileWriter writer = new FileWriter(ORDER_FILE);
             BufferedWriter bw = new BufferedWriter(writer)) {

            for (Order order : orders) {
                bw.write(order.getOrderId() + "," + order.getCustomerName() + ","
                        + order.getProductId() + "," + order.getQuantity() + ","
                        + order.getStatus());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving orders: " + e.getMessage());
        }
    }

    // Load orders from a file
    private synchronized void loadOrdersFromFile() {
        File file = new File(ORDER_FILE);
        if (!file.exists()) return;

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    UUID orderId = UUID.fromString(data[0]);
                    String customerName = data[1];
                    UUID productId = UUID.fromString(data[2]);
                    int quantity = Integer.parseInt(data[3]);
                    Status status = Status.valueOf(data[4]);

                    Order order = new Order(customerName, productId, quantity);
                    order.setStatus(status);
                    orders.add(order);
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error loading orders: " + e.getMessage());
        }
    }

    // Shut down the executor service when done
    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}