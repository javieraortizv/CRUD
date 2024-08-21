
package com.mycompany.claseintroduccionjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    private static final String URL = "jdbc:mysql://198.74.53.25:3306/bibliotecaADSO";
    private static final String USUARIO = "cesarbd";
    private static final String PASSWORD = "Sarielsofia012023.";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}
