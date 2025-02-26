public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        manager.initializeProducts();
        manager.displayProducts();
        manager.collectSalesData();

    }
}