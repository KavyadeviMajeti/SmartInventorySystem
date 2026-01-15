package model;

import java.time.LocalDateTime;

public class Order {
    private final int orderId;
    private final int productId;
    private final int quantity;
    private final LocalDateTime orderTime;

    public Order(int orderId, int productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId +
               ", ProductID: " + productId +
               ", Quantity: " + quantity +
               ", Time: " + orderTime;
    }
}
