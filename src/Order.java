import java.util.UUID;

enum Status{
    PENDING, SHIPPED, DELIVERED
}
public class Order {
    final private UUID orderId; // after it's generated it does not change
    private String customerName;
    private UUID productId;
    private int quantity;
    private Status status;

    // Constructor
    public Order (String customerName, UUID productId, int quantity) {
        this.orderId = UUID.randomUUID();
        this.customerName = customerName;
        this.productId = productId;
        this.quantity = quantity;
        this.status = Status.PENDING; // Automatically assigned to the first status "PENDING"

    }

    // this ID only has a getter (no setter) since it's generated automatically
    public UUID getOrderId() {
        return orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }
    public UUID getProductId() {
        return productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //Automatic status update
//    public void updateStatus() {
//        if (status == Status.PENDING) {
//            this.status = Status.SHIPPED;
//        } else if (status == Status.SHIPPED) {
//            this.status = Status.DELIVERED;
//        } else { //if (status == Status.DELIVERED)
//            this.status = Status.PENDING;
//        }
//        System.out.println("Order " + orderId + " updated status to " + status);
//    }

    public Status getStatus() {
        return status;
    }


}











