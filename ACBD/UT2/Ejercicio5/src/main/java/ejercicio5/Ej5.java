package ejercicio5;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *Clase que realizará la Lectura y Escritura de archivos XML
 * @author dam
 */
public class Ej5 {
    public static void main(String[] args) throws JAXBException {
        File bibliotecaSteam = new File("SteamBiblioteca.xml");
        
        //Esta parte es obligatoria siempre que se quiera trabajar con JAXB
        //NOTA: Cambiar el parámetro de newInstance por la clase contenedor (es decir,
        //cuya clase contenga la etiqueta raiz del archivo XML)
        JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
        
        //Parte 1: LECTURA DEL ARCHIVO XML
        
        //La clase Unmarshaller permite la lectura del archivo
        Unmarshaller um = context.createUnmarshaller();
        
        //Instanciamos una variable de clase Biblioteca (La raiz del XML),
        //haciendo cast al método unmarshal de la clase Unmarshaller creada
        Biblioteca biblioteca = (Biblioteca) um.unmarshal(bibliotecaSteam);
        
        ArrayList<Juego> juegosDisponibles = biblioteca.getJuegos();
        
        for(Juego juego: juegosDisponibles){
            imprimirJuego(juego);
        }
        
        //Parte 2: ESCRITURA DE XML
        //Si se quiere realizar esta operación por separado, se ha de de nuevo la línea del contexto JAXB
        
        //La clase Marshaller permite escribir en un XML
        Marshaller marshaller = context.createMarshaller();
        
        //En este caso, he decidido crear toda la información manualmente.
        //Lo idóneo en un caso de estos sería que el usuario introdujese los datos para luego agregarlo
        Biblioteca bibliotecaSecundaria = new Biblioteca();
        
        ArrayList<Juego> juegos = new ArrayList();
        Juego primerJuego = new Juego();
        primerJuego.setId("1");
        primerJuego.setNombre("Rocket League");
        primerJuego.setDesarrolladora("Psyonix");
        primerJuego.setFecha_salida("2013");
        juegos.add(primerJuego);
        
        Juego segundoJuego = new Juego();
        segundoJuego.setId("2");
        segundoJuego.setNombre("Killing Floor 2");
        segundoJuego.setDesarrolladora("Tripwire Interactive");
        segundoJuego.setFecha_salida("2016");
        juegos.add(segundoJuego);
        
        Juego tercerJuego = new Juego();
        tercerJuego.setId("3");
        tercerJuego.setNombre("Borderlands 2");
        tercerJuego.setDesarrolladora("Gearbox");
        tercerJuego.setFecha_salida("2012");
        juegos.add(tercerJuego);
        
        bibliotecaSecundaria.setJuegos(juegos);
        
        //setProperty da formato al archivo XML generado
        //Se utiliza Boolean.True porque hay que usar u objeto, no un primitivo. Así se puede lograr de forma sencilla
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        //Escribe dentro de un documento (existente o no) el archivo XML generado con la información suministrada
        marshaller.marshal(bibliotecaSecundaria, new File("EpicBiblioteca.xml"));
    }

    /**
     * Genera el formato de texto de cada juego
     * @param juego Juego obtenido
     */
    private static void imprimirJuego(Juego juego) {
        System.out.println("Juego número " + juego.getId());
        System.out.println("Nombre: " + juego.getNombre());
        System.out.println("Desarrollado por: " + juego.getDesarrolladora());
        System.out.println("Año de salida: " + juego.getFecha_salida());
        System.out.println("----------------------------------------------------------");
    }
}
