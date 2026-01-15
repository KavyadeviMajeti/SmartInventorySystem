package model;

public class Product {
    private final int productId;
    private String name;
    private int stock;
    private double price;

    public Product(int productId, String name, int stock, double price) {
        this.productId = productId;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }

    public void addStock(int quantity) {
        this.stock += quantity;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId +
               ", Name: " + name +
               ", Stock: " + stock +
               ", Price: ₹" + price;
    }
}
