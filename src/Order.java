import java.util.UUID;

enum Status{
    PENDING, SHIPPED, DELIVERED
}
public class Order {
    final private UUID orderId;
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
        this.status = Status.PENDING;

    }

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
    public Status getStatus() {
        return status;
    }
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "orderId=" + orderId +
//                ", customerName='" + customerName + '\'' +
//                ", productId=" + productId +
//                ", quantity=" + quantity +
//                ", orderStatus=" + status +
//                '}';
//    }


}
