package ex1ejercicio3;

import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

/**
 * Modificación del archivo original para añadir un nuevo nodo al final de las comidas
 * @author dam
 */
public class MenuCompletoModificado {

    public static void main(String[] args) throws Exception {
        //Ruta del archivo
        String rutaArchivo = "..\\MenuCompleto.xml";
        //DocumentBuilderFactory
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //DocumentBuilder que obtiene el archivo creado previamente
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document menu = documentBuilder.parse(new InputSource(new FileInputStream(rutaArchivo)));
        //Obtención de la etiqueta padre
        Element tagMenu = menu.getDocumentElement();
        //Creación de la etiqueta a añadir, y posterior añadido al final de todos los hijos
        Element tagServicio = menu.createElement("servicio");
        tagServicio.appendChild(menu.createTextNode("En local, en terraza y para llevar"));
        tagMenu.appendChild(tagServicio);
        //Creación del archivo en físico
        TransformerFactory transformerFactory = TransformerFactory.newInstance();		                     
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(menu);
        StreamResult result = new StreamResult(new File(rutaArchivo));
	transformer.transform(source, result);
    }
}
