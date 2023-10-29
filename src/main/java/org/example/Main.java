package org.example;

import org.example.Classes.Product;

public class Main {
    public static void main(String[] args) {
        Product newProduct = new Product.ProductBuilder("Iphone")
                .description("New iphone")
                .price(699)
                .quantity(15)
                .build();



    }
}