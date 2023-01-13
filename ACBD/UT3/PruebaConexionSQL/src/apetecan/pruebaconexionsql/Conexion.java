/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apetecan.pruebaconexionsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String BD = "sakila";
        String servidor = "jdbc:mysql://localhost:3306/"+BD;
        String usuario = "userjava";
        String password = "SQLPassword";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection conexion;

        Class.forName(driver);
        conexion = DriverManager.getConnection(servidor, usuario, password);
        conexion.close();
    }
}
