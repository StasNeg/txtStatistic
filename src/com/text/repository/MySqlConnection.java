package com.text.repository;

import com.text.CLIController;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySqlConnection {
    private static Connection connection = null;

    public static synchronized Connection getConnection() {
        if (connection == null) {
            Properties properties = new Properties();
            try (final InputStream stream =
                         ClassLoader.class.getResourceAsStream("..\\..\\resources\\dataBase.properties")) {
                properties.load(stream);
                String driver = properties.getProperty("jdbcDriver");
                String host = properties.getProperty("host");
                String schema = properties.getProperty("schema");
                String port = properties.getProperty("port");
                String username = properties.getProperty("username");
                String password = properties.getProperty("password");
                String url = String.format("jdbc:mysql://%s:%s/%s?autoReconnect=true&useSSL=false", host, port, schema);

                Class.forName(driver);
                connection = DriverManager.getConnection(
                        url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
