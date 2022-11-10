package ejercicio2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Procesa un archivo XML que contiene info sobre varios libro.
 * @author Fernando Santamaría
 */
public class ProcesaLibro {
    public static void main(String[] args) {
      ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
      try {
         // Se crea aquí la factoría
         XMLReader reader = XMLReaderFactory.createXMLReader();
         // Se añade el manejador al reader
         reader.setContentHandler(new ManejadorLibro(arrayLibros));         
         // El XML es procesado (La ruta escrita puede ser acortada)
         reader.parse(new InputSource(new FileInputStream("Fichero.xml")));
         arrayLibros.forEach((n) -> redactarDatos(n));
      } catch (SAXException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
    
    private static void redactarDatos(Libro n){
        n.imprimirDatos();
        System.out.println("****************************************");
    }
}
