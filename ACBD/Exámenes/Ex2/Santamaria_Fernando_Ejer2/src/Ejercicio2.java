
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Carrera;
import pojos.Corre;
import pojos.CorreId;
import pojos.HibernateUtil;
import pojos.Piloto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dam
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String optionSelected = null;
               
        do{
            System.out.println("Seleccione una opción:");
            System.out.println("1.- Registrar Datos");
            System.out.println("2.- Consultar Datos");
            System.out.println("3.- Eliminar Datos");
            System.out.println("E.- Salir");
            optionSelected = myObj.nextLine();   
        }while(!"1".equals(optionSelected) && 
                !"2".equals(optionSelected) && 
                !"3".equals(optionSelected) && 
                !"4".equals(optionSelected) && 
                !"5".equals(optionSelected) && 
                !"E".equals(optionSelected.toUpperCase()));
        
        switch(optionSelected){
            case "1":
                registerData();
                break;
            case "2":
                selectData();
                break;
            case "3":
                deleteData();
                break;
            case "e":
            case "E":
                System.out.println("La aplicación se cerrará");
                break;
    }
}

    private static void deleteData() {   
        Session session = HibernateUtil.getSessionFactory().openSession();
        String seleccionarUsuario = "DELETE FROM Carrera c WHERE year(fecha)=2016*'";
        Query query = session.createQuery(seleccionarUsuario);
        session.close();
    }

    private static void registerData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        tx=session.beginTransaction();
        Corre corre1 = new Corre();
        corre1.setId(new CorreId(13, "C19"));
        corre1.setPiloto(new Piloto(13));
        corre1.setCarrera(new Carrera("C19"));
        corre1.setAverias("Calentamiento del Motor");
        corre1.setTiempo(2640);
        corre1.setRol("t");
        session.save(corre1);
        Corre corre2 = new Corre();
        corre2.setId(new CorreId(13, "C20"));
        corre2.setPiloto(new Piloto(13));
        corre2.setAverias("Calentamiento del Motor");
        corre2.setCarrera(new Carrera("C20"));
        corre2.setTiempo(4320);
        corre2.setRol("t");
        session.save(corre2);
        tx.commit();
        session.close();
    }

    private static void selectData() {
        String stringQuery = "SELECT p.nombre, e.nombre FROM Piloto p INNER JOIN Equipo e";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(stringQuery);
        List resultados = query.list();
        Iterator pilotosIterator = resultados.iterator();
        while(pilotosIterator.hasNext()){
            System.out.println("No c");
        }
        session.close();
    }
}