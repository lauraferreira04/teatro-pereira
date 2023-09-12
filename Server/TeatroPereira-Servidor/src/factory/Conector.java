/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class Conector {
    public static Connection getConnection() {
        Connection con;
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String banco = "teatropereira";
            String usuario = "root";
            String senha = "";
            
            con = DriverManager.getConnection(url + banco, usuario, senha);
        } catch(SQLException exc) {
            System.out.println("Erro " + exc.getMessage());
            con = null;
        }
        return con;
    }
}
