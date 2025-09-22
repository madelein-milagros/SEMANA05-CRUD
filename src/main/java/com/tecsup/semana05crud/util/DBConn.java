package com.tecsup.semana05crud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    private static final String URL = "jdbc:mysql://localhost:3306/escuela1?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "**************"; // <-- cambia aquí si tu clave es otra
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(DRIVER);
            System.out.println("✅ Driver MySQL cargado correctamente");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error cargando el driver: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        System.out.println("🔌 Conectando a: " + URL + " con usuario: " + USER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
