package com.library.util;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    // TODO: Constantes com URL, USER, PASSWORD

    private static Properties loadProperties() {
        Properties props = new Properties();

        try(FileInputStream input = new FileInputStream("db.properties")){
            props.load(input);

        }catch (IOException e){
            throw new RuntimeException("Error loading db.properties" + e.getMessage());
        }
        return props;
    }


    // TODO: Método getConnection() que retorna Connection

    public static Connection getConnection() throws SQLException {
        Properties props = loadProperties();
        String url = props.getProperty("db.url");
        String username = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setURL(url);
        ds.setUser(username);
        ds.setPassword(password);

        return ds.getConnection();
    }
}


