package org.example.Data;

import org.example.Classes.Product;
import org.example.Constants.ProductConstants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductCSVDao {
    private final String csvFilePath;

    public ProductCSVDao() {
        this.csvFilePath = ProductConstants.CSV_FILE_PATH;
        try {
            File file = new File(csvFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createProduct(Product product) {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProductsToCsv(products);
    }

//    public Product getProductById(int productId) {
//        List<Product> products = getAllProducts();
//        for (Product product : products) {
//            if (product.getProductId() == productId) {
//                return product;
//            }
//        }
//        return null;
//    }
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[1];
                    String description = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    int quantity = Integer.parseInt(parts[4]);
                    Product product = new Product.ProductBuilder(name)
                            .description(description)
                            .price(price)
                            .quantity(quantity)
                            .build();
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

//    public void updateProduct(Product product) {
//        List<Product> products = getAllProducts();
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getProductId() == product.getProductId()) {
//                products.set(i, product);
//                break;
//            }
//        }
//        saveProductsToCsv(products);
//    }
//
//    public void deleteProduct(int productId) {
//        List<Product> products = getAllProducts();
//        products.removeIf(product -> product.getProductId() == productId);
//        saveProductsToCsv(products);
//    }

    private void saveProductsToCsv(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            for (Product product : products) {
                writer.write(String.format("%d,%s,%s,%.2f,%d\n",
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getQuantity()
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
