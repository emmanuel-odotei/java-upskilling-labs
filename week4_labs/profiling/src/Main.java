package Week

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our space!");
        Store store = new Store();
        User user = new User("JohnDoe");

        // Adding products to the store
        store.addProduct(new Product(1, "Laptop", 1500.00));
        store.addProduct(new Product(2, "Smartphone", 800.00));
        store.addProduct(new Product(3, "Headphones", 150.00));
        store.addProduct(new Product(4, "Monitor", 300.00));
        store.addProduct(new Product(5, "Keyboard", 100.00));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. View Products");
            System.out.println("2. Purchase Product");
            System.out.println("3. View Purchased Products");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.displayProducts();
                    break;
                case 2:
                    System.out.print("Enter the product ID to purchase: ");
                    int productId = scanner.nextInt();
                    Product product = store.findProductById(productId);
                    if (product != null) {
                        user.purchaseProduct(product);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                case 3:
                    user.viewPurchasedProducts();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}