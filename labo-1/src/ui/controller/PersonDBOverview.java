package ui.controller;

import domain.model.Person;

import java.sql.*;
import java.util.Properties;

public class PersonDBOverview {
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
        ResultSet result = statement.executeQuery( "SELECT * FROM r0702184.person" );

        while(result.next()){
            String uid = result.getString("userid");
            String firstName = result.getString("firstname");
            String lastName = result.getString("lastname");
            String email = result.getString("email");
            String password = result.getString("password");
            try {	// validation of data stored in database
                Person person = new Person();
                person.setUserid(uid);
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setEmail(email);
                person.setPassword(password);
                System.out.println(person.toString());
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        statement.close();
        connection.close();
    }
}
