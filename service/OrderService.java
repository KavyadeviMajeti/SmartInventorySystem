package service;

import model.Order;
import model.Product;
import exception.*;

import java.util.*;

public class OrderService {

    private final List<Order> orders = new ArrayList<>();
    private final InventoryService inventoryService;

    public OrderService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void placeOrder(int orderId, int productId, int quantity)
            throws ProductNotFoundException, InsufficientStockException {

        Product product = inventoryService.getProduct(productId);

        if (product.getStock() < quantity) {
            throw new InsufficientStockException("Insufficient stock for product: " + productId);
        }

        product.reduceStock(quantity);
        orders.add(new Order(orderId, productId, quantity));

        System.out.println("Order placed successfully.");
    }

    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders placed yet.");
            return;
        }
        orders.forEach(System.out::println);
    }
}
