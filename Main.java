import model.Product;
import service.*;
import util.IdGenerator;
import exception.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InventoryService inventoryService = new InventoryService();
        OrderService orderService = new OrderService(inventoryService);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Smart Inventory System ====");
            System.out.println("1. Add Product");
            System.out.println("2. View Inventory");
            System.out.println("3. Restock Product");
            System.out.println("4. Place Order");
            System.out.println("5. View Orders");
            System.out.println("0. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Product Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Stock: ");
                        int stock = sc.nextInt();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();

                        Product p = new Product(
                                IdGenerator.generateProductId(),
                                name, stock, price
                        );
                        inventoryService.addProduct(p);
                        System.out.println("Product added: " + p);
                        break;

                    case 2:
                        inventoryService.displayInventory();
                        break;

                    case 3:
                        System.out.print("Product ID: ");
                        int pid = sc.nextInt();
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        inventoryService.restockProduct(pid, qty);
                        System.out.println("Restocked successfully.");
                        break;

                    case 4:
                        System.out.print("Product ID: ");
                        int prodId = sc.nextInt();
                        System.out.print("Quantity: ");
                        int q = sc.nextInt();
                        orderService.placeOrder(
                                IdGenerator.generateOrderId(),
                                prodId, q
                        );
                        break;

                    case 5:
                        orderService.displayOrders();
                        break;

                    case 0:
                        System.out.println("Exiting system.");
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
