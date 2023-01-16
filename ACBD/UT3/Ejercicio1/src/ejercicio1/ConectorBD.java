
package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Realiza una conexión a una base de datos local, con la obtención y volcado de resultados por pantalla
 * @author Fernando Santamaría
 */
public class ConectorBD {

    /**
     * Clase main. Realiza la visualización por pantalla de los resultados obtenidos de la consulta solicitada
     * 
     */
    public static void main(String[] args) throws SQLException{
        Connection conexionAbierta = abrirConexion();
        comprobarConexion(conexionAbierta);
        
        verActores(conexionAbierta);
        
        cerrarConexion(conexionAbierta);
    }
    
    /**
     * Realiza la apertura de la conexión a la BD
     * @return Conexión realizada
     */
    public static Connection abrirConexion(){
        String BD = "sakila";
        String servidor = "jdbc:mysql://localhost:3306/"+BD;
        String usuario = "userjava";
        String password = "SQLPassword";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection conexion = null;
        
        try{           
            Class.forName(driver);
            conexion=DriverManager.getConnection(servidor, usuario, password);
        }
        catch(Exception e){
            System.out.println("Se ha producido un error en la conexion");
        }
        finally{
            return conexion;
        }
    }
    
    /**
     * Comprueba la conexión a la base de datos, obteniendo meta datos
     * @param conexion Conexión a la BD
     * @throws SQLException 
     */
    public static void comprobarConexion(Connection conexion) throws SQLException{
           DatabaseMetaData datosConexion = conexion.getMetaData();
           
           System.out.println("Nombre del Servidor: "+datosConexion.getDatabaseProductName());
           System.out.println("Versión: "+datosConexion.getDriverVersion());
           System.out.println("URL: "+datosConexion.getURL());
           System.out.println("Usuario logueado: "+datosConexion.getUserName());         
    }
    
    /**
     * Realiza la obtención de los datos, y su plasmado en pantalla
     * @param conexion Conexión a la BD
     * @throws SQLException 
     */
    public static void verActores(Connection conexion) throws SQLException{
        String consulta = "select actor_id as id, first_name as nombre," +
                        "last_name as apellido from actor where first_name = \"julia\"";
        
        Statement stm = conexion.createStatement();
        ResultSet resultados = stm.executeQuery(consulta);
        
        verResultados(resultados);
    }
    
    /**
     * Formatea e imprime por pantalla los resultados obtenidos de la consulta
     * @param resultados Resultados obtenidos
     * @throws SQLException 
     */
    public static void verResultados(ResultSet resultados) throws SQLException{
        for (int x=1;x<=resultados.getMetaData().getColumnCount();x++){
            System.out.print(resultados.getMetaData().getColumnName(x)+ "\t");
        }
        System.out.println("");
	      

        while(resultados.next()) {
            for (int x=1;x<=resultados.getMetaData().getColumnCount();x++){
                System.out.print(resultados.getString(x)+ "\t\t");
            }
            System.out.println("");
        }
    }
    
    /**
     * Cierra la conexión
     * @param conexion Conexión a la BD
     * @throws SQLException 
     */
    public static void cerrarConexion(Connection conexion) throws SQLException{
        conexion.close();
    }
}
