package ui.controller;

import domain.model.Product;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class AddProductToDB {
    public static void main(String[] args) throws SQLException {
        Product p = new Product();

        boolean validName = false;
        String name = "";
        while(!validName) {
            try {
                name = JOptionPane.showInputDialog("Please enter the name of the product");
                p.setName(name);
                validName = true;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid product name");
            }
        }

        boolean validDesciption = false;
        String description = "";
        while(!validDesciption) {
            try {
                description = JOptionPane.showInputDialog("Please enter the desciption");
                p.setDescription(description);
                validDesciption = true;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid desciption");
            }
        }

        boolean validPrice = false;
        double price = 0;
        while(!validPrice) {
            try {
                price = Double.parseDouble(JOptionPane.showInputDialog("Please enter the price"));
                p.setPrice(price);
                validPrice = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid price");
            }
        }

        Properties properties = new Properties();
        String url = "jdbc:postgresql://databanken.ucll.be:61819/2TX37";
        properties.setProperty("user", "local_r0702184");
        properties.setProperty("password", "izà=xAn3$D7P;àH");
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode","prefer");

        Connection connection = DriverManager.getConnection(url,properties);
        PreparedStatement statement = connection.prepareStatement("insert into \"2TX37\".r0702184.product (name, description, price) values ( ? , ? , ?)");
        statement.setString(1, p.getName());
        statement.setString(2, p.getDescription());
        statement.setDouble(3, p.getPrice());
        statement.executeUpdate();
        statement.close();
        connection.close();

        ProductDBOverview.main(null);
    }
}

