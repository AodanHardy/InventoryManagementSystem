package org.example.Classes;

/**
 * The type Product.
 */
public class Product {
    private final String name;
    private final String description;
    private final double price;
    private final int quantity;


    private Product(ProductBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.quantity = builder.quantity;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * The type Product builder.
     */
    public static class ProductBuilder {
        private final String name;
        private String description;
        private double price;
        private int quantity;

        /**
         * Instantiates a new Product builder.
         *
         * @param name the name
         */
        public ProductBuilder(String name) {
            this.name = name;
        }

        /**
         * Description product builder.
         *
         * @param description the description
         * @return the product builder
         */
        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Price product builder.
         *
         * @param price the price
         * @return the product builder
         */
        public ProductBuilder price(double price) {
            this.price = price;
            return this;
        }

        /**
         * Quantity product builder.
         *
         * @param quantity the quantity
         * @return the product builder
         */
        public ProductBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * Build product.
         *
         * @return the product
         */
        public Product build() {
            return new Product(this);
        }
    }

}
