package ejercicio1;

import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Procesa un archivo XML que contiene info sobre un sólo libro.
 * @author Fernando Santamaría
 */
public class ProcesaLibro {
    public static void main(String[] args) {
      Libro miLibro = new Libro();
      try {
         // Se crea aquí la factoría
         XMLReader reader = XMLReaderFactory.createXMLReader();
         // Se añade el manejador al reader
         reader.setContentHandler(new ManejadorLibro(miLibro));         
         // El XML es procesado (La ruta escrita puede ser acortada)
         reader.parse(new InputSource(new FileInputStream("Fichero.xml")));
         miLibro.imprimirDatos();
      } catch (SAXException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
