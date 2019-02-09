package com.text.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
    private static Connection connection = null;

    public static synchronized Connection getConnection(){
        if(connection == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/txt_file_statistic?autoReconnect=true&useSSL=false","root","root");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}
