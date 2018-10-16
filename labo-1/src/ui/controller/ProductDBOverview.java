package ui.controller;

import domain.model.Person;
import domain.model.Product;

import java.sql.*;
import java.util.Properties;

public class ProductDBOverview {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        String url = "jdbc:postgresql://databanken.ucll.be:61819/2TX37";
        properties.setProperty("user", "local_r0702184");
        properties.setProperty("password", "izà=xAn3$D7P;àH");
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode","prefer");

        Connection connection = DriverManager.getConnection(url,properties);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery( "SELECT * FROM r0702184.product" );

        while(result.next()){
            int id = result.getInt("id");
            String name = result.getString("name");
            String description = result.getString("description");
            double price = result.getDouble("price");
            try {	// validation of data stored in database
                Product product = new Product();
                product.setProductId(id);
                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
                System.out.println(product.toString());
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        statement.close();
        connection.close();
    }
}
