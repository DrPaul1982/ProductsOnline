package org.example.ProductsOnline;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Laptop", 1150));
        products.add(new Product(2, "Mouse", 20));
        products.add(new Product(3, "Keyboard", 70));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public Optional<Product> getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(product -> product.getId() == id);
    }
}
