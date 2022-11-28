
package ex1ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Realizado de las operaciones pertinentes para el ejercicio
 * @author Fernando Santamaría
 */
public class MenuFinal {
    public static void main(String[] args) throws Exception{
        //Creación del ArrayList que contendrá los datos obtenidos
       ArrayList<Comida> listaComidas = new ArrayList<Comida>();
       //Archivo donde los resultados se guardarán
       File menuFinal = new File("..\\MenuFinal.txt");
       //XMLReader
       XMLReader reader = XMLReaderFactory.createXMLReader();
       reader.setContentHandler(new ManejadorMenu(listaComidas));
       //Gestor de escritura del archivo
       FileOutputStream archivoMF = new FileOutputStream(menuFinal);
       reader.parse(new InputSource(new FileInputStream("..\\MenuCompleto.xml")));
       //Buble que recorre cada comida, y obtiene los valores
       listaComidas.forEach((n) -> {
           try {
               imprimirResultados(n, archivoMF);
           } catch (IOException e) {
               e.printStackTrace();
           }
       });
       //Cierre de la operación de escritura del archivo
       archivoMF.close();

    }
    /**
     * Impresión de los resultados obtenidos en un archivo de texto, con formato
     * @param n Comida
     * @param archivoMF archivo dónde se guardara la información obtenida
     * @throws IOException 
     */
    public static void imprimirResultados(Comida n, FileOutputStream archivoMF)
    throws IOException{
        //Almacena el caracter salto de línea en forma de byte
        String saltoLineas = "\n";
        byte[] salto = saltoLineas.getBytes();
        
        //Almacena una linea de guiones en forma de bytes
        String guiones = "----------------------------------------------------------------------------------";
        byte[] separaciones = guiones.getBytes();
        
        byte[] nombre = n.nombre.getBytes();
        archivoMF.write(nombre);
        
        archivoMF.write(salto);
        
        byte[] descr = n.descr.getBytes();
        archivoMF.write(descr);
        
        archivoMF.write(salto);
        
        byte[] calorias = n.calorias.getBytes();
        archivoMF.write(calorias);
        
        archivoMF.write(salto);
        
        byte[] precio = n.precio.getBytes();
        archivoMF.write(precio);
        archivoMF.write(salto);
        archivoMF.write(separaciones);
        archivoMF.write(salto);
    }
}
