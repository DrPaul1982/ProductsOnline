package org.example.ProductsOnline;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<Product> cartProducts = new ArrayList<>();

    public List<Product> getAllProductsFromCart() {
        return new ArrayList<>(cartProducts);
    }

    public void addProductToCart(Product product) {
        cartProducts.add(product);
        System.out.println(product.getName() + " Product added to cart");
    }

    public boolean deleteProductFromCart(int id) {
        return cartProducts.removeIf(product -> product.getId() == id);
    }

    public void clearCart() {
        cartProducts = new ArrayList<>();
        System.out.println("Cart has been cleared.");
    }
}
