
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.HibernateUtil;
import pojos.Libros;
import pojos.Usuario;


/**
 *
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
                createLoan();
                break;
            case "4":
                deleteUser();
                break;
            case "5":
                finishLoan();
                break;
            case "e":
            case "E":
                System.out.println("La aplicación se cerrará");
                break;
        }
        debug();
        System.exit(0);
    }

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

    private static void createLoan() {
        
    }

    private static void deleteUser() {
        
    }

    private static void finishLoan() {
        
    }
    private static void debug(){
        String stringQuery = "SELECT u FROM Libros u";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(stringQuery);
        List resultados = query.list();
        Iterator actoresIterator = resultados.iterator();
        while(actoresIterator.hasNext()){
            Libros actor = (Libros)actoresIterator.next();
            System.out.println(actor.getIdlibros()+ "- " + actor.getTitulo() + "(" + actor.getAutor() + ")");
        }
        session.close();
    }
}
