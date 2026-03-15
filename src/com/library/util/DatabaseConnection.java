package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // TODO: Constantes com URL, USER, PASSWORD
    private static final String url = "jdbc:postgresql://localhost:5432/library_db";
    private static final String username = "rolandgarcia";
    private static final  String password = "";

    // TODO: Método getConnection() que retorna Connection

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
