package service;

import model.Product;
import exception.ProductNotFoundException;

import java.util.*;

public class InventoryService {

    private final Map<Integer, Product> inventory = new HashMap<>();

    public Product addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        return product;
    }

    public Product getProduct(int productId) throws ProductNotFoundException {
        Product product = inventory.get(productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found: " + productId);
        }
        return product;
    }

    public void restockProduct(int productId, int quantity) throws ProductNotFoundException {
        Product product = getProduct(productId);
        product.addStock(quantity);
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        inventory.values().forEach(System.out::println);
    }
}
