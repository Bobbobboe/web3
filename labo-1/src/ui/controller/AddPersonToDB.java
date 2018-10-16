package ui.controller;

import domain.model.Person;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class AddPersonToDB {
    public static void main(String[] args) throws SQLException {
        Person p = new Person();

        boolean validFirstName = false;
        String fistName = "";
        while(!validFirstName) {
            try {
                fistName = JOptionPane.showInputDialog("Please enter the first name of the person");
                p.setFirstName(fistName);
                validFirstName = true;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid first name");
            }
        }

        boolean validLastName = false;
        String lastName = "";
        while(!validLastName) {
            try {
                lastName = JOptionPane.showInputDialog("Please enter the last name of the person");
                p.setLastName(lastName);
                validLastName = true;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid last name");
            }
        }

        boolean validEmail = false;
        String email = "";
        while(!validEmail) {
            try {
                email = JOptionPane.showInputDialog("Please enter the email of the person");
                p.setEmail(email);
                validEmail = true;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address");
            }
        }

        boolean validPassword = false;
        String password = "";
        while(!validPassword) {
            try {
                password = JOptionPane.showInputDialog("Please enter the password for the person");
                p.setPassword(password);
                validPassword = true;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid password name");
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
        PreparedStatement statement = connection.prepareStatement("insert into \"2TX37\".r0702184.person (firstname, lastname, email, password) values ( ? , ? , ?, ?)");
        statement.setString(1, p.getFirstName());
        statement.setString(2, p.getLastName());
        statement.setString(3, p.getEmail());
        statement.setString(4, password);
        statement.executeUpdate();
        statement.close();
        connection.close();

        PersonDBOverview.main(null);
    }


}
