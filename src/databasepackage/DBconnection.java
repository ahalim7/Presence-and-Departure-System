/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdelhalim
 */
public class DBconnection {

    /**
     * declare static Connection variable
     */
    private static Connection connection;

    /**
     * class constructor
     */
    public DBconnection() {
    }

    /**
     * implement static method for open connection
     */
    public static void openConnection() {
        if (connection == null) {
            try {
                String driverName = "com.mysql.jdbc.Driver";
                Class.forName(driverName);
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/presencedeparturesystem", "root", "root");
            } catch (ClassNotFoundException | SQLException exception) {
                Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE,
                        null, exception);
                System.out.println("connection = " + connection.toString());
                System.out.println("Exception = " + exception.getMessage());
            }
        }
    }

    /**
     * implement static method for close connection
     */
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE,
                    null, exception);
        }
    }
    
    public static Connection getConnection(){
        return connection;
    }
}
