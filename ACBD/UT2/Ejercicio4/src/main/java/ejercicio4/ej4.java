
package ejercicio4;

import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 *Creación de un archivo nuevo, el cual adquiere copias de los nodos de un archivo
 * XML original, añadiendo algunos nodos extra para comparar
 * @author fSantaG
 */
public class ej4 {
    public static void main(String[] args) throws Exception{     
                //Ruta del archivo a generar
		String filePath = "nuevoEmpleados.xml";
 
		//Creación de la Factoría (No sé qué hace, honestamente. Sólo sé que es importante)
		DocumentBuilderFactory documentBuilderFactory = 
                             DocumentBuilderFactory.newInstance();
 
		//Obtención del contructor del documento (Tampoco sé qué hace, sólo sé que es importante)
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                
		//Obtención de los 2 archivos a tratar, el original y la copia		
                Document empleados = documentBuilder.parse(new InputSource(new FileInputStream("empleados.xml")));
                Document nuevoEmpleados = documentBuilder.newDocument();
                
                //Copia de la etiqueta raiz y sus hijos en el nuevo archivo
                Element etiquetaRaiz = empleados.getDocumentElement();
                Node etiquetaRaizCopia = nuevoEmpleados.importNode(etiquetaRaiz, true);
                nuevoEmpleados.appendChild(etiquetaRaizCopia);
                
                //Creación de un atributo
                Element etiquetaPadre = nuevoEmpleados.getDocumentElement();
                Attr atributoNuevo = nuevoEmpleados.createAttribute("soyNuevo");
                atributoNuevo.setValue("Buenas Tardes");
                etiquetaPadre.setAttributeNode(atributoNuevo);
                
                //Obtención de la última etiqueta hija, y añadido de un elemento propio
                Node ultimoEmpleado = (Node)(XPathFactory.newInstance().newXPath().evaluate("Empleados/Empleado[@id=\"4\"]", 
                        nuevoEmpleados, XPathConstants.NODE));
                if (ultimoEmpleado!=null){
                    Element elementoNuevo = nuevoEmpleados.createElement("estado");
                    elementoNuevo.appendChild(nuevoEmpleados.createTextNode("Casada"));
                    ultimoEmpleado.appendChild(elementoNuevo);
                }
                
		//Serialización
		TransformerFactory transformerFactory = 
		                     TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(nuevoEmpleados);
		StreamResult result = new StreamResult(new File(filePath));
		transformer.transform(source, result);

    }
}
