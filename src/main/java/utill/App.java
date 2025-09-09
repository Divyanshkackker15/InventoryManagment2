package utill;   // 👈 Ye line zaroori hai

import Model.Product;
import Service.ProductManagement;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManagement manager = new ProductManagement();

        while (true) {
            System.out.println("\nChoose an option: ");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Remove Product");
            System.out.println("5. Exit");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Category: ");
                        String category = sc.nextLine();
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();

                        Product p = new Product(id, name, category, qty, price);
                        manager.addProduct(p);
                        System.out.println("✅ Product added successfully.");
                        break;

                    case 2:
                        List<Product> products = manager.viewAllProducts();
                        if (products.isEmpty()) {
                            System.out.println("⚠ No products available in inventory.");
                        } else {
                            products.forEach(System.out::println);
                        }
                        break;

                    case 3:
                        System.out.print("Enter Product ID: ");
                        int searchId = sc.nextInt();
                        Product found = manager.searchProductById(searchId);
                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("❌ Product not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Product ID to remove: ");
                        int removeId = sc.nextInt();
                        if (manager.removeProduct(removeId)) {
                            System.out.println("✅ Product removed.");
                        } else {
                            System.out.println("❌ Product not found.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
