
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Actor;
import pojos.NewHibernateUtil;


public class PruebasHibernate {
    public static void main(String[] args) {       
        //addActor("Daniel", "Ontañón");
        Short id = 208;
        modifyActor(id, "DANIEL", "ONTAÑÓN");
        selectActor();
    }
    
    public static void addActor(String firstName, String lastName){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Date fecha = new Date();  
        tx=session.beginTransaction();
        Actor actor = new Actor();
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        actor.setLastUpdate(fecha);
        session.save(actor);
        tx.commit();
        session.close();
    }
    
    public static void modifyActor(Short id, String firstName, String lastName){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        Actor actor = new Actor(id);
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        actor.setLastUpdate(new Date());
        session.update(actor);
        tx.commit();
        System.out.println("Valor Modificado sin Problemas");
        session.close();
    }
    
    public static void deleteActor(Short id){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        Actor actor = new Actor(id);
        session.delete(actor);
        tx.commit();
        System.out.println("Actor borrado con éxito");
        session.close();
    }
    
    public static void obtainActor(Short id){
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Actor actor;
        actor = (Actor)session.get(Actor.class, id);
        System.out.println(actor.getActorId() + "- " + actor.getFirstName() + " " + actor.getLastName());
        session.close();
    }
    
        public static void selectActor(){
        //Hay que coger todos los datos, y poner el nombre de la clase (es decir, la primera mayúscula)
        String stringQuery = "SELECT a FROM Actor a";
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(stringQuery);
        List resultados = query.list();
        Iterator actoresIterator = resultados.iterator();
        while(actoresIterator.hasNext()){
            Actor actor = (Actor)actoresIterator.next();
            System.out.println(actor.getActorId() + "- " + actor.getFirstName() + " " + actor.getLastName());
        }
        session.close();
    }
    
}
