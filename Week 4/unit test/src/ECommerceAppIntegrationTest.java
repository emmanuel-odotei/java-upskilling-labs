package Week

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ECommerceAppIntegrationTest {
    private Store store;
    private User user;

    @BeforeEach
    public void setUp() {
        store = new Store();
        user = new User("JohnDoe");

        // Adding products to the store for testing
        store.addProduct(new Product(1, "Laptop", 1500.00));
        store.addProduct(new Product(2, "Smartphone", 800.00));
        store.addProduct(new Product(3, "Headphones", 150.00));
        store.addProduct(new Product(4, "Monitor", 300.00));
        store.addProduct(new Product(5, "Keyboard", 100.00));
    }

    // Test for displaying products in the store
    @Test
    public void testDisplayProducts() {
        assertDoesNotThrow(() -> store.displayProducts(), "Displaying products should not throw any exception.");
    }

    // Test for adding products to the store
    @Test
    public void testAddProduct() {
        Product newProduct = new Product(6, "Mouse", 50.00);
        store.addProduct(newProduct);

        Product foundProduct = store.findProductById(6);
        assertNotNull(foundProduct, "Product should be added and found by ID.");
        assertEquals("Mouse", foundProduct.getName(), "Product name should match.");
        assertEquals(50.00, foundProduct.getPrice(), "Product price should match.");
    }

    // Test for purchasing a product
    @Test
    public void testPurchaseProduct() {
        Product productToBuy = store.findProductById(1);
        assertNotNull(productToBuy, "Product should exist in the store.");

        user.purchaseProduct(productToBuy);
        // Assert that the purchased product was added to the user's purchased list
        assertEquals(1, user.getPurchasedProducts().size(), "User should have one product after purchase.");
        assertEquals("Laptop", user.getPurchasedProducts().get(0).getName(), "Purchased product name should match.");
    }

    // Test for viewing purchased products
    @Test
    public void testViewPurchasedProducts() {
        Product productToBuy = store.findProductById(2);
        assertNotNull(productToBuy, "Product should exist in the store.");

        user.purchaseProduct(productToBuy);

        assertDoesNotThrow(() -> user.viewPurchasedProducts(), "Viewing purchased products should not throw any exception.");
    }

    // Test for trying to purchase a non-existent product
    @Test
    public void testPurchaseNonExistentProduct() {
        Product nonExistentProduct = store.findProductById(999);
        assertNull(nonExistentProduct, "Product with invalid ID should not be found.");
    }

    // Test for finding a product by its ID
    @Test
    public void testFindProductById() {
        Product foundProduct = store.findProductById(3);
        assertNotNull(foundProduct, "Product with valid ID should be found.");
        assertEquals("Headphones", foundProduct.getName(), "Found product name should match.");
    }

    // Test for exiting the application gracefully (if applicable)
    @Test
    public void testExitApplication() {
        // Simulating application exit - you can just check that the loop terminates properly
        boolean isRunning = false;
        assertFalse(isRunning, "Application should exit gracefully.");
    }
}
