/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author dam
 */
public class ProcesaLibro {
    public static void main(String[] args) {
      Libro miLibro = new Libro();
      try {
         // Creamos la factoria de parseadores por defecto
         XMLReader reader = XMLReaderFactory.createXMLReader();
         // Añadimos nuestro manejador al reader
         reader.setContentHandler(new ManejadorLibro(miLibro));         
         // Procesamos el xml de ejemplo
         reader.parse(new InputSource(new FileInputStream("C:\\Users\\dam\\2DAM\\ACBD\\UT2\\Ejercicio1\\Fichero.xml")));
         miLibro.imprimirDatos();
      } catch (SAXException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
