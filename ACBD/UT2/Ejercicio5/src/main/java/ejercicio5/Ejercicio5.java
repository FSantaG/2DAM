package ejercicio5;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Ejercicio5 {

    public static void main(String[] args) throws JAXBException {
        //Esto es universal
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        
        //Parte 1: Lectura de XML con JAXB
        //Permite leer el XML
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //visualización del XML
        Libreria libreria = (Libreria) unmarshaller.unmarshal(new File("libreria.xml"));
        System.out.println("Nombre: " + libreria.getNombre());
        
        ArrayList<Libro> libros = libreria.getLibros();
        for(Libro libro: libros){
            System.out.println(libro.getIsbn() + " " + libro.getTitulo() + " " + libro.getAutor());
        }
        
        //Parte 2: Escritura de XML con JAXB
        //En caso de que se quisiera realizar esta operación
        //Permite escribir en XML
        Marshaller marshaller = context.createMarshaller();
        Libreria nuevaLibreria = new Libreria();
        
        libreria.setNombre("Libreria Juason2224");
        ArrayList<Libro> nuevosLibros = new ArrayList();
        Libro libroPrueba = new Libro();
        libroPrueba.setIsbn("1213131314414");
        libroPrueba.setAutor("Autor de Prueba 1");
        libroPrueba.setTitulo("Libro de Prueba 1");
        nuevosLibros.add(libroPrueba);
        
        Libro libroPrueba2 = new Libro();
        libroPrueba2.setIsbn("75865877269471");
        libroPrueba2.setAutor("Autor de Prueba 2");
        libroPrueba2.setTitulo("Libro de Prueba 2");
        nuevosLibros.add(libroPrueba2);
        
        libreria.setLibros(nuevosLibros);
        //Permite dar formato al XML
        //Se utiliza Boolean.True porque hay que usar u objeto, no un primitivo. Así se puede lograr de forma sencilla
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(libreria, new File("nuevaLibreria.xml"));
    }
}
