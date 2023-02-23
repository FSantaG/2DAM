/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santamaria_fernando_ejer1;

import java.sql.*;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.*;

/**
 *
 * @author dam
 */
public class Ejercicio1 {
    public static void main(String[] args) throws JAXBException {
        //PARTE 1 JAXB
        
        /*File sakila = new File("sakila.xml");
        
        JAXBContext context = JAXBContext.newInstance(Sakila.class);
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        Sakila root = (Sakila) unmarshaller.unmarshal(sakila);
        
        ArrayList<Actor> actoresArray = root.getActores();
        
        for(Actor actor: actoresArray){
            printActors(actor);
        }
        
        Marshaller marshaller = context.createMarshaller();     
        
        ArrayList<Actor> actores = new ArrayList();
        
        Actor actorUno = new Actor();
        actorUno.setId(214);
        actorUno.setNombre("WESLEY");
        actorUno.setApellido("SNIVES");
        actores.add(actorUno);
        
        Actor actorDos = new Actor();
        actorDos.setId(214);
        actorDos.setNombre("KATHERINE");
        actorDos.setApellido("ZETA");
        actores.add(actorDos);
        
        root.setActores(actores);
        
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(root, sakila);*/
        
        
        //PARTE 2. JDBC
        try{
            Connection conexionAbierta = openConnection();
            checkConnection(conexionAbierta);
            
            insertActors(conexionAbierta, 212, "WESLEY", "SNIVES");
            insertActors(conexionAbierta, 213, "KATHERINE", "ZETA");
            
            updateActors(conexionAbierta, 212, 82);
            updateActors(conexionAbierta, 213, 92);
            
            showPaymentQuantity(conexionAbierta);
        }catch(Exception e){
            
        }
    }
    
    private static void printActors(Actor actor) {
        System.out.println("Actor " + actor.getId() + ": " + 
                actor.getNombre() + " " + actor.getApellido());
    }
    
    public static Connection openConnection() {
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
    
    public static void checkConnection(Connection conexion) throws SQLException {
        DatabaseMetaData datosConexion = conexion.getMetaData();

        System.out.println("Nombre del Servidor: " + datosConexion.getDatabaseProductName());
        System.out.println("Versión: " + datosConexion.getDriverVersion());
        System.out.println("URL: " + datosConexion.getURL());
        System.out.println("Usuario logueado: " + datosConexion.getUserName());
    }
    
    public static void insertActors(Connection conexion, int id, String nombre, String apellido) throws SQLException {
        String consulta = "INSERT INTO actor(actor_id, first_name, last_name)\n"
                + "VALUES (?,?,?)";

        PreparedStatement stm = conexion.prepareStatement(consulta);
        stm.setInt(1, id);
        stm.setString(2, nombre);
        stm.setString(3, apellido);

        int i = stm.executeUpdate();
        if (i == 0) {
            System.out.println("No se han alterado valores");
        } else {
            System.out.println("Valor añadido correctamente");
        }
    }
    
    public static void updateActors(Connection conexion, int idNueva, int idVieja) throws SQLException {
        String consulta = "UPDATE film_actor\n"
                + "SET actor_id = ?\n"
                + "WHERE actor_id = ? AND film_id = 104";

        PreparedStatement stm = conexion.prepareStatement(consulta);
        stm.setInt(1, idNueva);
        stm.setInt(2, idVieja);

        int i = stm.executeUpdate();
        if (i == 0) {
            System.out.println("No se han alterado valores");
        } else {
            System.out.println(i + " valores cambiados");
        }

    }

    private static void showPaymentQuantity(Connection conexionAbierta) {
        //TODO
    }
    
}
