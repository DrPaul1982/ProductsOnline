package org.example.ProductsOnline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class ProductsOnlineApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ProductsOnlineApplication.class, args);

        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Menu:");
            System.out.println("1. Show all products.");
            System.out.println("2. Add product to cart.");
            System.out.println("3. Show cart.");
            System.out.println("4. Delete product from cart.");
            System.out.println("5. Clear cart.");
            System.out.println("6. Exit.");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showProducts(productRepository);
                    break;
                case 2:
                    addToCart(cart, productRepository, scanner);
                    break;
                case 3:
                    showCart(cart);
                    break;
                case 4:
                    removeFromCart(cart, scanner);
                    break;
                case 5:
                    clearCart(cart);
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static void showProducts(ProductRepository productRepository) {
        System.out.println("\nAvailable Products:");
        for (Product product : productRepository.getAllProducts()) {
            System.out.println(product);
        }
    }

    private static void addToCart(Cart cart, ProductRepository productRepository, Scanner scanner) {
        System.out.print("\nEnter the product ID to add to the cart: ");
        int productId = scanner.nextInt();

        productRepository.getProductById(productId).ifPresentOrElse(product -> {
            cart.addProductToCart(product);
        }, () -> System.out.println("Product not found."));
    }

    private static void removeFromCart(Cart cart, Scanner scanner) {
        System.out.print("\nEnter the product ID to delete from the cart: ");
        int productId = scanner.nextInt();

        if (cart.deleteProductFromCart(productId)) {
            System.out.println("The product was deleted from the cart.");
        } else {
            System.out.println("The product wasn't found in the cart.");
        }
    }

    private static void showCart(Cart cart) {
        System.out.println("\nProducts in the cart:");
        for (Product product : cart.getAllProductsFromCart()) {
            System.out.println(product);
        }
    }

    private static void clearCart(Cart cart) {
        cart.clearCart();
    }
}
