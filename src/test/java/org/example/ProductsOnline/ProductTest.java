package org.example.ProductsOnline;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void testProductCreationWithValidData() {
        Product product = new Product(1, "Laptop", 1999.99);

        assertThat(product).isNotNull();
        assertThat(product.getId()).isPositive();
        assertThat(product.getName()).isNotBlank();
        assertThat(product.getPrice()).isGreaterThan(0);
    }

    @Test
    void testProductModification() {
        Product product = new Product(1, "Laptop", 999.99);

        product.setId(2);
        product.setName("Smartphone");
        product.setPrice(999.99);

        assertThat(product.getId()).isEqualTo(2);
        assertThat(product.getName()).isEqualTo("Smartphone");
        assertThat(product.getPrice()).isEqualTo(999.99);
    }


    @Test
    void testEdgeCasePrice() {
        Product product = new Product(10, "Headphones", 0);

        assertThat(product.getPrice()).isZero();
    }

    @Test
    void testLongProductName() {
        String longName = "Super Ultra Mega Pro Gaming Laptop with RGB Lights and Water Cooling System";
        Product product = new Product(100, longName, 2999.99);

        assertThat(product.getName()).isEqualTo(longName);
    }
}
