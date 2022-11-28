
package ex1ejercicio2;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *Manejador de SAX para la obtención de resultados
 * @author Fernando Santamaría
 */
public class ManejadorMenu extends DefaultHandler {
    //Variable de clase Comida
    Comida comidaNueva = new Comida();
    //Valor obtenido de cada etiqueta
    String valorCampo;
    //Lista de Comidas que se devolverá a la clase main
    ArrayList<Comida> listaComidas;
    
    /**
     * Constructor de la clase
     * @param listaComidas Lista de comidas a devolver
     */
    public ManejadorMenu(ArrayList<Comida> listaComidas){
        this.listaComidas = listaComidas;
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
            case "nombre":
                this.comidaNueva.nombre = this.valorCampo;
                break;
            case "descripcion":
                this.comidaNueva.descr = this.valorCampo;
                break;
            case "calorias":
                this.comidaNueva.calorias = this.valorCampo;
                break;
            case "precio":
                this.comidaNueva.precio = this.valorCampo;
                break;
        }
        if (this.comidaNueva.nombre != null
                && this.comidaNueva.descr != null
                && this.comidaNueva.calorias != null
                && this.comidaNueva.precio != null
                && Double.parseDouble(this.comidaNueva.precio) <= 7) {
            this.listaComidas.add(this.comidaNueva);
            this.comidaNueva = new Comida();
        }
    }
}
