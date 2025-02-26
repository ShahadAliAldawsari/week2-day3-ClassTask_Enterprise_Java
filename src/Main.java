public class Main {
    public static void main(String[] args) {

        //First part of the main
//        Inventory Management System
//            ● Build a system that tracks product inventory and predicts when restocking is needed using basic logic.

        OrderManager manager_ = new OrderManager();

        manager_.addProduct(new Product("Laptop", 1200.0, 20, 5));
        manager_.addProduct(new Product("Smartphone", 800.0, 10, 3));

        manager_.collectSalesData();
        manager_.displayProducts();




        //Second part of the main
//        Implement a Multi-Threaded Background Order Processor
//            ● Modify the OrderManager class to handle multiple orders simultaneously using Java's ExecutorService.
//            ● Each order should be processed in a separate thread to simulate high-volume order management.
//            ● Implement proper synchronization to ensure correct order status updates.

        // Create an instance of OrderManager
        OrderManager manager = new OrderManager();

        // Add some products to the inventory
        manager.addProduct(new Product("Laptop", 1200.0, 20, 5));
        manager.addProduct(new Product("Smartphone", 800.0, 10, 3));
        manager.addProduct(new Product("Headphones", 150.0, 15, 2));

        // Display available products
        System.out.println("Available Products:");
        manager.displayProducts();

        // Simulate placing multiple orders
        System.out.println("\nPlacing Orders...");
        manager.placeOrder("Alice", manager.getProducts().get(0).getProductId(), 2);
        manager.placeOrder("Bob", manager.getProducts().get(1).getProductId(), 1);
        manager.placeOrder("Charlie", manager.getProducts().get(2).getProductId(), 3);

        // Wait for some time to allow order processing
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Display all orders and their status
        System.out.println("\nAll Orders:");
        manager.displayOrders();

        // Shutdown the executor service to terminate the application gracefully
        manager.shutdown();
    }
}