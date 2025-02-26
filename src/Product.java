import java.util.UUID;

public class Product {
    final private UUID productId;
    private String name;
    private double price;
    private int stockLevel;
    private int reorderThreshold;

    // creating a Constructor
    public Product(String name, double price, int stockLevel, int reorderThreshold) {
        productId = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stockLevel = stockLevel;
        this.reorderThreshold = reorderThreshold;
    }

    // add setters and getters
    public UUID getProductId() {
        return productId;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public double getPrice () {
        return price;
    }

    public void setStockLevel (int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public int getStockLevel () {
        return stockLevel;
    }

    public void setReorderThreshold (int reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public int getReorderThreshold () {
        return reorderThreshold;
    }



    // toString method for display
    @Override
    public String toString() {
        return "Product ID: " + productId +
                "\nName: " + name +
                "\nPrice: $" + price +
                "\nStock Level: " + stockLevel +
                "\nReorder Threshold: " + reorderThreshold +
                "\n----------------------------";
    }
}
