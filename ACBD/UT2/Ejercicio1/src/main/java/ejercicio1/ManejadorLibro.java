
package ejercicio1;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
/**
 * Manejador del lector del archivo XML
 * @author Fernando Santamaría
 */
public class ManejadorLibro extends DefaultHandler{
    //Variable de tipo Clase Libro que guardará los datos obtenidos
   Libro miLibro;
   //Almacena el valor del campo analizado para su posterior inserción dentro del tipo Clase Libro
   String valorCampo;
    
    public ManejadorLibro(Libro miLibro){
        this.miLibro = miLibro;
    }
    
    /**
     * Método que se ejecuta al leer la apertura de etiqueta
     * @param uri
     * @param localName
     * @param name
     * @param attributes
     * @throws SAXException 
     */
   @Override
   public void startElement(String uri, String localName, String name,
         Attributes attributes) throws SAXException {
      if(localName == "libro"){ //attributes.getLength() > 0
          this.miLibro.isbn = attributes.getValue(0); 
      }
   }
   /**
    * Asignación del valor de la etiqueta a la variable local que se encargará de almacenarla para su posterior extracción
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
    * @param uri
    * @param localName
    * @param name
    * @throws SAXException 
    */
   @Override
   public void endElement(String uri, String localName, String name)
         throws SAXException {
       switch (localName){
           case "titulo":
               this.miLibro.nombre = this.valorCampo;
               break;
           case "autor":
               this.miLibro.autor = this.valorCampo;
               break;
           case "anyo":
               this.miLibro.year = this.valorCampo;
               break;
           case "editorial":
               this.miLibro.editorial = this.valorCampo;
               break;
       }
   }
}
