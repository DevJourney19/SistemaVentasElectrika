package com.electrika.tech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD {

    private static ConectaBD instance = null;
    private static Connection connection = null;
    private final String URL = "jdbc:mysql://root:bEwwNOqdstENzObkKPEfJRPqjJyvErzq@roundhouse.proxy.rlwy.net:27772/railway";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String USER = "root";
    private final String PASS = "bEwwNOqdstENzObkKPEfJRPqjJyvErzq";
      
    //Patrón de diseño Singleton
    public static ConectaBD getInstance() {
        if (instance == null) {
            instance = new ConectaBD();
        }
        return instance;
    }

    public Connection getConexion() throws SQLException {
        try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return connection;
    }

}
