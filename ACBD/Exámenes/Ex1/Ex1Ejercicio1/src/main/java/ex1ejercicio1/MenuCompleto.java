
package ex1ejercicio1;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *Corresponde al ejercicio 1 del examen: Crear un fichero XML con el formato e info dada, 
 * y usar XPATH para mostrar por pantalla el nombre de las comidas que tengan 900 cal
 * y las descripcionesde las comidas que valgan menos de 6 euros
 * @author Fernando Santamaría
 */
public class MenuCompleto {
    public static void main(String[] args) throws Exception{
        //PARTE 1: DOM
        //Ruta del archivo
        String rutaArchivo = "..\\MenuCompleto.xml";
        //Información que se añadirá a cada campo del XML
        String[] comidas = {"Tallarines con verduras y salsa de soja", "Patatas guisadas con chorizo", "Huevos fritos con patatas",
        "Calabacines rellenos", "Sopa castellana"};
        double[] precios = {6.95, 7.95, 5.95, 7.50, 6.95};
        String[] descripciones = {"Tallarines con pimiento y calabacin con salsa de soja", "Patatas guisadas con puerro y chorizo", 
            "Dos huevos fritos con una ración de patatas fritas", "Medio calabacín relleno de carne picada y gratinado",
        "Sopa a base de pan, huevo, pimentón y ajo"};
        int[] calorias = {650, 900, 900, 600, 950};
        
        //Document Factory
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //DocumentBuilder
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //Creación del documento
        Document menuCompleto = documentBuilder.newDocument();
        //Etiqueta padre
        Element tagMenu = menuCompleto.createElement("menu");
        /**
         * Buble for que se encargará de añadir las etiquetas al cuerpo del XML
         */
        for(int i = 0; i < 5; i++){
            Element tagComida = menuCompleto.createElement("comida");
            
            Element tagNombre = menuCompleto.createElement("nombre");
            tagNombre.appendChild(menuCompleto.createTextNode(comidas[i]));
            tagComida.appendChild(tagNombre);
            
            Element tagPrecio = menuCompleto.createElement("precio");
            tagPrecio.appendChild(menuCompleto.createTextNode(String.valueOf(precios[i])));
            tagComida.appendChild(tagPrecio);
            
            Element tagDescr = menuCompleto.createElement("descripcion");
            tagDescr.appendChild(menuCompleto.createTextNode(descripciones[i]));
            tagComida.appendChild(tagDescr);
            
            Element tagCalorias = menuCompleto.createElement("calorias");
            tagCalorias.appendChild(menuCompleto.createTextNode(String.valueOf(calorias[i])));
            tagComida.appendChild(tagCalorias);
            
            tagMenu.appendChild(tagComida);
        }
        //Añade los nodos al nodo padre
        menuCompleto.appendChild(tagMenu);
        
        //Creación del archivo físico
        TransformerFactory transformerFactory = TransformerFactory.newInstance();		                     
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(menuCompleto);
        StreamResult result = new StreamResult(new File(rutaArchivo));
	transformer.transform(source, result);
        
        //PARTE 2: XPATH
        //Parseado del documento xml
        Document xml = documentBuilder.parse(new File(rutaArchivo));
        xml.getDocumentElement().normalize();
        //XPathFactory
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        
        //Obtención de los nombres de las comidas que contengan 900 cal
        NodeList comidas900k = (NodeList)xPath.evaluate(
            "menu/comida[calorias = \"900\"]/nombre", xml,
            XPathConstants.NODESET);
        System.out.print("Nombre comida con 900 calorias: ");
        imprimirNodos(comidas900k);
        
        //Obtención de las descripciones de las comidas que cuesten menos de 6€
        NodeList comidasMenos6euros = (NodeList)xPath.evaluate(
                "menu/comida[precio < 6]/descripcion", xml, XPathConstants.NODESET);
        System.out.print("Descripción comida con precio menor a 6€: ");
        imprimirNodos(comidasMenos6euros);
    }
    /**
     * Formateo por consola de la lista de nodos obtenida como resultado de las operaciones pertinentes
     * @param nodos Lista de los nodos que cumplen la condición
     */
    public static void imprimirNodos(NodeList nodos)
    {
        for (int i = 0; i < nodos.getLength(); i++) {
            if(i == 0){
                System.out.print("[");
            }
            System.out.print(nodos.item(i).getTextContent());
            if(i != nodos.getLength()-1){
                System.out.print(", ");
            }else{
                System.out.print("]\n");
            }
        }
    }
}
