package com.sakila.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase responsable de establecer la conexión con la base de datos MySQL Sakila.
 * Utiliza propiedades definidas en el archivo config.properties.
 */

public class DBConnection {
	
	private static Connection connection;

    public static Connection getConnection() 
    {
        if (connection == null) 
        {
            try 
            {
                PropertyFile config = new PropertyFile();
                String url = config.get("db.url");
                String user = config.get("db.user");
                String password = config.get("db.password");

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("✅ Conexion exitosa a la base de datos.");
            } catch (SQLException e) {
                System.out.println("❌ Error de conexion: " + e.getMessage());
            }
        }
        return connection;
    }

}
