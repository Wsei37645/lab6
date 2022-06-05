package pl.lublin.wsei.java.cwiczenia.lab6.test;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String serverName = "localhost";
        String database = "mydb";
        Number portNumber = 3306;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "wsei");
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        Connection conn = null;

        conn = DriverManager.getConnection("jdbc:mysql://" +serverName +":" +portNumber +"/" +database, connectionProps);

        System.out.println("Connected to database");





    }
}
