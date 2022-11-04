
package ejercicio1;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author dam
 */
public class ManejadorLibro extends DefaultHandler{
    
   Libro miLibro;
   String valorCampo;
    
    public ManejadorLibro(Libro miLibro){
        this.miLibro = miLibro;
    }
    
    /**
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
      if(localName == "libro"){ //attributes.getLength() > 0
          this.miLibro.isbn = attributes.getValue(0); 
      }
   }
   //Esto es para el texto
   @Override
   public void characters(char[] ch, int start, int length)
         throws SAXException {
       this.valorCampo = String.valueOf(ch, start, length);
   }
   
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
