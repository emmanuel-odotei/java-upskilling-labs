package Week

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    private final List<Product> purchasedProducts;

    public User(String username) {
        this.username = username;
        this.purchasedProducts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void purchaseProduct(Product product) {
        purchasedProducts.add(product);
        System.out.println(username + " purchased " + product.getName());
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void viewPurchasedProducts() {
        if (purchasedProducts.isEmpty()) {
            System.out.println(username + " has not purchased any products.");
        } else {
            System.out.println("Purchased Products for " + username + ":");
            for ( Product product : purchasedProducts) {
                System.out.println(product);
            }
        }
    }
}
