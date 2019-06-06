package com.t1708m1.model;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHel {
    private static java.sql.Connection connection;
    private static final String DATABASE_NAME = "user-manager";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    public static java.sql.Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"
                    + DATABASE_NAME + "?user="
                    + DATABASE_USER + "&password="
                    + DATABASE_PASSWORD);
        }
        return connection;
    }
}
