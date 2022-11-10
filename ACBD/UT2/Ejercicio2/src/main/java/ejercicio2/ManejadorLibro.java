package ejercicio2;

import java.util.ArrayList;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Manejador del lector del archivo XML
 *
 * @author Fernando Santamaría
 */
public class ManejadorLibro extends DefaultHandler {

    //Variable de tipo Clase Libro que guardará los datos obtenidos
    Libro miLibro = new Libro();
    //Almacena el valor del campo analizado para su posterior inserción dentro del tipo Clase Libro
    String valorCampo;
    //Almacena el array de libros
    ArrayList<Libro> arrayLibros;
    //Contador de valores del Array
    int contador = 10;
    //Almacenamiento Temporal de los Valores
    
    /**
     * Constructor
     * @param arrayLibros 
     */
    public ManejadorLibro(ArrayList<Libro> arrayLibros) {
        this.arrayLibros = arrayLibros;
    }

    /**
     * Método que se ejecuta al leer la apertura de etiqueta
     *
     * @param uri
     * @param localName
     * @param name
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String name,
            Attributes attributes) throws SAXException {
        if (localName == "libro") { //attributes.getLength() > 0
            this.miLibro.isbn = attributes.getValue(0);
            //System.out.println(this.miLibro.isbn);
        }
    }

    /**
     * Asignación del valor de la etiqueta a la variable local que se encargará
     * de almacenarla para su posterior extracción
     *
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        this.valorCampo = String.valueOf(ch, start, length);
    }

    /**
     * Asignación a la clase de los valores obtenidos
     *
     * @param uri
     * @param localName
     * @param name
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        switch (localName) {
            case "titulo":
                this.miLibro.nombre = this.valorCampo;
                //System.out.println(this.miLibro.nombre);
                break;
            case "autor":
                this.miLibro.autor = this.valorCampo;
                //System.out.println(this.miLibro.autor);
                break;
            case "anyo":
                this.miLibro.year = this.valorCampo;
                //System.out.println(this.miLibro.year);
                break;
            case "editorial":
                this.miLibro.editorial = this.valorCampo;
                //System.out.println(this.miLibro.editorial);
                break;
        }
        if (this.miLibro.isbn != null
                && this.miLibro.editorial != null
                && this.miLibro.nombre != null
                && this.miLibro.autor != null
                && this.miLibro.year != null) {
            this.arrayLibros.add(this.miLibro);
            this.miLibro = new Libro();
        }
    }
}
