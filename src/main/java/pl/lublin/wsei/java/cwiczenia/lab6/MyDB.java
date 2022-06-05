package pl.lublin.wsei.java.cwiczenia.lab6;

import java.sql.*;
import java.util.Properties;

public class MyDB {

    String serverName;
    String database;
    Number portNumber;
    private String user;
    private String password;

    public MyDB(String adres, Number port, String NameDB){
        serverName=adres;
        database=NameDB;
        portNumber=port;

    }

    public void setUser(String root) {
        user = root;
    }

    public void setPassword(String wsei) {
        password=wsei;
    }

    private Connection conn= null;
    private Statement statement= null;

    private void connect(){

        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString= "jdbc:mysql://"+ serverName+ ":"+ portNumber+ "/"+ database;

        try{
            conn= DriverManager.getConnection(jdbcString, connectionProps);
            statement = conn.createStatement();
        }
        catch (SQLException e) {
            System.out.println("Blad podlaczenia do bazy:"+ jdbcString);
            System.out.println("Komunikat bledu:"+e.getMessage());
            conn= null;
        }
        System.out.println("Connected to database: "+ database);
    }

    public Connection getConnection(){
        if (conn == null){
            connect();
        }
        return conn;
    }

    public void closeConnection(){
        if(conn!= null){
            try{
                conn.close();
            }
            catch (SQLException e) {
                System.out.println("Blad przy zamykaniu polaczenia bazodanowego"+ e.getMessage());
            }
            conn=null;
        }
    }

    public ResultSet selectData(String selectStatement){
        if((conn!=null) && (statement !=null)){
            try{
                return statement.executeQuery(selectStatement);
            }
            catch (SQLException e){
                System.out.println("Blad realizacji zapytania:"+ selectStatement+ ", "+ e.getMessage());
            }
        }
        return null;
    }


}
