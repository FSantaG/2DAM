/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

import java.sql.*;

/**
 * Realiza una conexión a una base de datos local, con la obtención y volcado de
 * resultados por pantalla
 *
 * @author Fernando Santamaría
 */
public class ConectorBDMejorado {

    /**
     * Clase main. Realiza la visualización por pantalla de los resultados
     * obtenidos de la consulta solicitada
     *
     */
    public static void main(String[] args) throws SQLException {
        Connection conexionAbierta = abrirConexion();
        comprobarConexion(conexionAbierta);
        verActores(conexionAbierta);

        actualizarActores(conexionAbierta);
        insertarActores(conexionAbierta);
        borrarActores(conexionAbierta);

        cerrarConexion(conexionAbierta);
    }

    /**
     * Realiza la apertura de la conexión a la BD
     *
     * @return Conexión realizada
     */
    public static Connection abrirConexion() {
        String BD = "sakila";
        String servidor = "jdbc:mysql://localhost:3306/" + BD;
        String usuario = "userjava";
        String password = "SQLPassword";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection conexion = null;

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(servidor, usuario, password);
        } catch (Exception e) {
            System.out.println("Se ha producido un error en la conexion");
        } finally {
            return conexion;
        }
    }

    /**
     * Comprueba la conexión a la base de datos, obteniendo meta datos
     *
     * @param conexion Conexión a la BD
     * @throws SQLException
     */
    public static void comprobarConexion(Connection conexion) throws SQLException {
        DatabaseMetaData datosConexion = conexion.getMetaData();

        System.out.println("Nombre del Servidor: " + datosConexion.getDatabaseProductName());
        System.out.println("Versión: " + datosConexion.getDriverVersion());
        System.out.println("URL: " + datosConexion.getURL());
        System.out.println("Usuario logueado: " + datosConexion.getUserName());
    }

    /**
     * Realiza la obtención de los datos, y su plasmado en pantalla
     *
     * @param conexion Conexión a la BD
     * @throws SQLException
     */
    public static void verActores(Connection conexion) throws SQLException {
        String consulta = "select actor_id as id, first_name as nombre,"
                + "last_name as apellido from actor where first_name = \"julia\"";

        Statement stm = conexion.createStatement();
        ResultSet resultados = stm.executeQuery(consulta);

        verResultados(resultados);
    }

    /**
     * Formatea e imprime por pantalla los resultados obtenidos de la consulta
     *
     * @param resultados Resultados obtenidos
     * @throws SQLException
     */
    public static void verResultados(ResultSet resultados) throws SQLException {
        for (int x = 1; x <= resultados.getMetaData().getColumnCount(); x++) {
            System.out.print(resultados.getMetaData().getColumnName(x) + "\t");
        }
        System.out.println("");

        while (resultados.next()) {
            for (int x = 1; x <= resultados.getMetaData().getColumnCount(); x++) {
                System.out.print(resultados.getString(x) + "\t\t");
            }
            System.out.println("");
        }
    }

    /**
     * Cierra la conexión
     *
     * @param conexion Conexión a la BD
     * @throws SQLException
     */
    public static void cerrarConexion(Connection conexion) throws SQLException {
        conexion.close();
    }
    
    //****//
    //**ESTO ES PARTE DEL EJERCICIO 2**//
    //****//

    /**
     * Actualiza el nombre y apellidos del autor que se desea
     * @param conexion Conexión a la BD
     * @throws SQLException 
     */
    public static void actualizarActores(Connection conexion) throws SQLException {
        String consulta = "UPDATE actor\n"
                + "SET first_name = ?, last_name= ?\n"
                + "WHERE first_name = 'JULIA' AND last_name = 'FAWCETT'";
        //Consulta para reestablecer el valor por defecto. Usado en pruebas
        /*String consulta = "UPDATE actor\n"
                + "SET first_name = 'JULIA', last_name= 'FAWCETT'\n"
                + "WHERE first_name = ? AND last_name = ?";
        */
        PreparedStatement stm = conexion.prepareStatement(consulta);
        stm.setString(1, "FAWCETT");
        stm.setString(2, "PRUEBA");

        int i = stm.executeUpdate();
        if (i == 0) {
            System.out.println("No se han alterado valores");
        } else {
            System.out.println(i + " valores cambiados");
        }

    }
    
    /**
     * Inserta un nuevo actor en la tabla actor
     * @param conexion Conexión a la BD
     * @throws SQLException 
     */
    public static void insertarActores(Connection conexion) throws SQLException {
        String consulta = "INSERT INTO actor(first_name, last_name)\n"
                + "VALUES (?,?)";

        PreparedStatement stm = conexion.prepareStatement(consulta);
        stm.setString(1, "FERNANDO");
        stm.setString(2, "SANTAMARÍA");

        int i = stm.executeUpdate();
        if (i == 0) {
            System.out.println("No se han alterado valores");
        } else {
            System.out.println("Valor añadido correctamente");
        }
    }
    
    /**
     * Borra el actor creado cona nterioridad
     * @param conexion Conexión a la BD
     * @throws SQLException 
     */
    public static void borrarActores(Connection conexion) throws SQLException {
        String consulta = "DELETE FROM actor\n" + 
                "WHERE first_name = ? AND last_name = ?";

        PreparedStatement stm = conexion.prepareStatement(consulta);
        stm.setString(1, "FERNANDO");
        stm.setString(2, "SANTAMARÍA");

        int i = stm.executeUpdate();
        if (i == 0) {
            System.out.println("No se han alterado valores");
        } else {
            System.out.println(i +"valor/es borrados con éxito");
        }
    }
}
