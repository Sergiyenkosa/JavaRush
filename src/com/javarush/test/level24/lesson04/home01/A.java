package com.javarush.test.level24.lesson04.home01;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;

/**
 * Created by s.sergienko on 25.04.2016.
 */
public class A
{
    public static void main(String[] args) throws SQLException
    {
        Connection connection = null;
        String url  = "jdbc:mysql://localhost:3306/?user=root";
        String name = "root";
        String pass = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Драйвер установлен.");
            connection = getConnection(url, name, pass);
            System.out.println("Соединение с базой установленно.");
        } catch (Exception ex) {
            Logger.getLogger(A.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
