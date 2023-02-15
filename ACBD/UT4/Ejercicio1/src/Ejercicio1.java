
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.HibernateUtil;
import pojos.Libros;
import pojos.Prestamos;
import pojos.Usuario;


/**
 * Hibernate Cosas
 * @author dam
 */
public class Ejercicio1 {


    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String optionSelected = null;
        
        
        do{
            System.out.println("Seleccione una opción:");
            optionSelected = myObj.nextLine();   
        }while(!"1".equals(optionSelected) && 
                !"2".equals(optionSelected) && 
                !"3".equals(optionSelected) && 
                !"4".equals(optionSelected) && 
                !"5".equals(optionSelected) && 
                !"E".equals(optionSelected.toUpperCase()));
        
        switch(optionSelected){
            case "1":
                System.out.println("Introduzca su nombra");
                String nombre = myObj.nextLine();
                System.out.println("Introduzca su edad");
                int edad = Integer.parseInt(myObj.nextLine());
                insertUser(nombre, edad);
                break;
            case "2":
                System.out.println("Introduzca nombre y apellidos del autor");
                String autor = myObj.nextLine();
                System.out.println("Introduzca el título del libro");
                String titulo = myObj.nextLine();
                insertBook(autor, titulo);
                break;
            case "3":
                System.out.println("Introduzca nombre y apellidos del usuario");
                String nomUsuario = myObj.nextLine();
                System.out.println("Introduzca título del libro");
                String nomLibro = myObj.nextLine();
                createLoan(nomUsuario, nomLibro);
                break;
            case "4":
                System.out.println("Introduzca nombre y apellidos del usuario");
                String nomUsuarioBorrar = myObj.nextLine();
                deleteUser(nomUsuarioBorrar);
                break;
            case "5":
                System.out.println("Introduzca nombre y apellidos del usuario");
                String nomUsuarioEditar = myObj.nextLine();
                System.out.println("Introduzca título del libro");
                String nomLibroEditar = myObj.nextLine();
                finishLoan(nomUsuarioEditar, nomLibroEditar);
                break;
            case "e":
            case "E":
                System.out.println("La aplicación se cerrará");
                break;
        }
        System.exit(0);
    }
    /**
     * Insercción del usuario en la BD
     * @param nombre
     * @param edad 
     */
    private static void insertUser(String nombre, int edad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Date fecha = new Date();  
        tx=session.beginTransaction();
        Usuario newUsuario = new Usuario();
        newUsuario.setNombre(nombre);
        newUsuario.setEdad(edad);
        session.save(newUsuario);
        tx.commit();
        session.close();
    }
    /**
     * Insercción de libro
     * @param autor
     * @param titulo 
     */
    private static void insertBook(String autor, String titulo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Date fecha = new Date();  
        tx=session.beginTransaction();
        Libros newLibro = new Libros();
        newLibro.setTitulo(titulo);
        newLibro.setAutor(autor);
        session.save(newLibro);
        tx.commit();
        session.close();
    }
    
    /**
     * Creación de un préstamo,comprobando que el usuario ingresado 
     * tiene en su disposición menos de 3 libros sin devolver
     * @param nomUsuario
     * @param nomLibro 
     */
    private static void createLoan(String nomUsuario, String nomLibro) {
        
        int idUsuario = 0;
        int idLibro = 0;
        int prestamosCounter = 0;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.clear();
        String seleccionarLibro = "SELECT l FROM Libros l WHERE titulo='" + nomLibro + "'";
        Query consultaLibro = session.createQuery(seleccionarLibro);
        List libros = consultaLibro.list();
        Iterator libroIterator = libros.iterator();
        while(libroIterator.hasNext()){
            Libros libro = (Libros)libroIterator.next();
            idLibro= libro.getIdlibros();
        }
        
        String seleccionarUsuario = "SELECT u FROM Usuario u WHERE nombre='" + nomUsuario + "'";
        Query query = session.createQuery(seleccionarUsuario);
        List usuarios = query.list();
        Iterator usuarioIterator = usuarios.iterator();
        while(usuarioIterator.hasNext()){
            Usuario usuario = (Usuario)usuarioIterator.next();
            idUsuario= usuario.getIdusuario();
        }
        if(idUsuario!= 0){
            String seleccionarPrestamos = "SELECT p FROM Prestamos p WHERE idUsuario=" + idUsuario+ " AND fechaRealDev=null";
            query =session.createQuery(seleccionarPrestamos);
            List prestamos = query.list();
            Iterator prestamosIterator = prestamos.iterator();
            while(prestamosIterator.hasNext()){
                prestamosCounter++;
            }
            if(prestamosCounter < 3){
                Transaction tx = null;
                Date fechaHoy = new Date();
                Calendar calendar = Calendar.getInstance();	
                calendar.setTime(fechaHoy);	
                calendar.add(Calendar.DAY_OF_YEAR, 15);
                Prestamos prestamo = new Prestamos();
                prestamo.setLibros(new Libros(idLibro));
                prestamo.setUsuario(new Usuario(idUsuario));
                prestamo.setFechaPrestamo(fechaHoy);
                prestamo.setFechaDevolucion(calendar.getTime());
                prestamo.setFechaRealDev(null);
                
                tx=session.beginTransaction();
                session.save(prestamo);
                tx.commit();
            }else{
                System.out.println("El usuario ya posee 3 libros sin devovler. Márquelos como devueltos antes");
            }
        } 
        session.close();
    }
    
    /**
     * Borrado de Usuario (No funciona correctamente. No sé si es mi propia BD o qué)
     * @param nomUsuario 
     */
    private static void deleteUser(String nomUsuario) {
        Transaction tx = null;   
        int idUsuario = 0;
        int edadUsuario = 0;
        String nombreUsuario = "";
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String seleccionarUsuario = "SELECT u FROM Usuario u WHERE nombre='" + nomUsuario + "'";
        Query query = session.createQuery(seleccionarUsuario);
        List usuarios = query.list();
        Iterator usuarioIterator = usuarios.iterator();
        while(usuarioIterator.hasNext()){
            Usuario usuario = (Usuario)usuarioIterator.next();
            idUsuario= usuario.getIdusuario();
            nombreUsuario = usuario.getNombre();
            edadUsuario = usuario.getEdad();
        }
        System.out.println(idUsuario);
        tx = session.beginTransaction();
        Usuario usuarioABorrar = new Usuario(idUsuario, nombreUsuario, edadUsuario);
        session.delete(usuarioABorrar);
        tx.commit();
        session.close();
    }
    
    /**
     * Terminar un préstamo (cambia de nulo a la fecha actual el campo fechaDevReal
     * @param nomUsuario
     * @param nomLibro 
     */
    private static void finishLoan(String nomUsuario, String nomLibro){
        int idUsuario = 0;
        int idLibro = 0;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String seleccionarLibro = "SELECT l FROM Libros l WHERE titulo='" + nomLibro + "'";
        Query consultaLibro = session.createQuery(seleccionarLibro);
        List libros = consultaLibro.list();
        Iterator libroIterator = libros.iterator();
        while(libroIterator.hasNext()){
            Libros libro = (Libros)libroIterator.next();
            idLibro= libro.getIdlibros();
        }
        
        String seleccionarUsuario = "SELECT u FROM Usuario u WHERE nombre='" + nomUsuario + "'";
        Query query = session.createQuery(seleccionarUsuario);
        List usuarios = query.list();
        Iterator usuarioIterator = usuarios.iterator();
        while(usuarioIterator.hasNext()){
            Usuario usuario = (Usuario)usuarioIterator.next();
            idUsuario= usuario.getIdusuario();
        }
        String seleccionarPrestamos = "SELECT p FROM Prestamos p WHERE idUsuario=" + idUsuario+ " AND idLibros=" + idLibro;
        query =session.createQuery(seleccionarPrestamos);
        List prestamos = query.list();
        Iterator prestamosIterator = prestamos.iterator();
        while(prestamosIterator.hasNext()){
            Prestamos prestamo = (Prestamos)prestamosIterator.next();
            Transaction tx = null;              
            Date fechaHoy = new Date();
            prestamo.setFechaRealDev(fechaHoy);           
            tx=session.beginTransaction();
            session.update(prestamo);
            tx.commit();
        }
    }
}
