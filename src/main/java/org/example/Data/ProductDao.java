package org.example.Data;

import org.example.Classes.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

                Product product = new Product.ProductBuilder(name)
                        .description(description)
                        .price(price)
                        .quantity(quantity)
                        .build();

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return products;
    }

    public void createProduct(Product product) {
        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO products (name, description, price, quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public Product getProductById(int productId) {
        Product product = null;
        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection();
            String selectQuery = "SELECT * FROM products WHERE product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

                product = new Product.ProductBuilder(name)
                        .description(description)
                        .price(price)
                        .quantity(quantity)
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return product;
    }

    // Implement update and delete methods similarly

    // Don't forget to handle exceptions and resource management properly
}


