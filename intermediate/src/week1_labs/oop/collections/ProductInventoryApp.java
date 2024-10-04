package intermediate.src.week1_labs.oop.collections;

import java.util.ArrayList;
import java.util.List;

public class ProductInventoryApp {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.0, 10));
        products.add(new Product("Mouse", 25.5, 100));
        products.add(new Product("Keyboard", 45.0, 75));
        products.add(new Product("Monitor", 300.0, 20));
        products.add(new Product("Printer", 150.0, 5));
        products.add(new Product("Scanner", 300.0, 20));
        
        // Sort products by price using the custom comparator
        products.sort(new ProductPriceComparator());
        
        System.out.println("Sorted Products by Price:");
        products.forEach(System.out::println);
        
        // Use Stream API to filter, transform, and process
        // 1. Filter products with price < 100
        List<Product> affordableProducts = products.stream()
                .filter(product -> product.price() < 100)
                .toList();
        
        System.out.println("\nAffordable Products (price < $100):");
        affordableProducts.forEach(System.out::println);
        
        // 2. Map each product to its name
        List<String> productNames = products.stream()
                .map(Product::name )
                .toList();
        
        System.out.println("\nProduct Names:");
        productNames.forEach(System.out::println);
        
        // 3. Get products in stock (quantityInStock > 0) and collect to a list
        List<Product> productsInStock = products.stream()
                .filter(product -> product.quantityInStock() > 0)
                .toList();
        
        System.out.println("\nProducts in Stock:");
        productsInStock.forEach(System.out::println);
    }
}
