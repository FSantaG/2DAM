package ejercicio1;

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
 * @author Cristian
 */
public class Ejercicio1 {

    public static void main(String[] args) throws Exception {
        String ruta = "MenuCompleto.xml";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.newDocument();

        Element raiz = doc.createElement("menu");
        doc.appendChild(raiz);

        Element hijoRaiz = doc.createElement("comida");
        raiz.appendChild(hijoRaiz);

        //1ºCOMIDA
        Element hijo1 = doc.createElement("nombre");
        hijo1.appendChild(doc.createTextNode("Tallarines con verduras y salsa de soja"));
        hijoRaiz.appendChild(hijo1);

        Element hijo2 = doc.createElement("precio");
        hijo2.appendChild(doc.createTextNode("6.95"));
        hijoRaiz.appendChild(hijo2);

        Element hijo3 = doc.createElement("descripcion");
        hijo3.appendChild(doc.createTextNode("Tallarines con pimiento y calabacin con salsa de soja"));
        hijoRaiz.appendChild(hijo3);

        Element hijo4 = doc.createElement("calorias");
        hijo4.appendChild(doc.createTextNode("650"));
        hijoRaiz.appendChild(hijo4);

        /*2ºCOMIDA*/
        Element hijoRaiz2 = doc.createElement("comida");
        raiz.appendChild(hijoRaiz2);

        Element hijo1_2 = doc.createElement("nombre");
        hijo1_2.appendChild(doc.createTextNode("Patatas guisadas con chorizo"));
        hijoRaiz2.appendChild(hijo1_2);

        Element hijo2_2 = doc.createElement("precio");
        hijo2_2.appendChild(doc.createTextNode("7.95"));
        hijoRaiz2.appendChild(hijo2_2);

        Element hijo3_2 = doc.createElement("descripcion");
        hijo3_2.appendChild(doc.createTextNode("Patatas guisadas con puerro y chorizo"));
        hijoRaiz2.appendChild(hijo3_2);

        Element hijo4_2 = doc.createElement("calorias");
        hijo4_2.appendChild(doc.createTextNode("900"));
        hijoRaiz2.appendChild(hijo4_2);

        //3ºCOMIDA
        Element hijoRaiz3 = doc.createElement("comida");
        raiz.appendChild(hijoRaiz3);

        Element hijo1_3 = doc.createElement("nombre");
        hijo1_3.appendChild(doc.createTextNode("Huevo fritos con patatas"));
        hijoRaiz3.appendChild(hijo1_3);

        Element hijo2_3 = doc.createElement("precio");
        hijo2_3.appendChild(doc.createTextNode("5.95"));
        hijoRaiz3.appendChild(hijo2_3);

        Element hijo3_3 = doc.createElement("descripcion");
        hijo3_3.appendChild(doc.createTextNode("Dos huevos fritos con una racion de patatas fritas"));
        hijoRaiz3.appendChild(hijo3_3);

        Element hijo4_3 = doc.createElement("calorias");
        hijo4_3.appendChild(doc.createTextNode("900"));
        hijoRaiz3.appendChild(hijo4_3);

        //4ºCOMIDA
        Element hijoRaiz4 = doc.createElement("comida");
        raiz.appendChild(hijoRaiz4);

        Element hijo1_4 = doc.createElement("nombre");
        hijo1_4.appendChild(doc.createTextNode("Calabacines rellenos"));
        hijoRaiz4.appendChild(hijo1_4);

        Element hijo2_4 = doc.createElement("precio");
        hijo2_4.appendChild(doc.createTextNode("7.50"));
        hijoRaiz4.appendChild(hijo2_4);

        Element hijo3_4 = doc.createElement("descripcion");
        hijo3_4.appendChild(doc.createTextNode("Medio calabacin relleno de carne picada y gratinado"));
        hijoRaiz4.appendChild(hijo3_4);

        Element hijo4_4 = doc.createElement("calorias");
        hijo4_4.appendChild(doc.createTextNode("600"));
        hijoRaiz4.appendChild(hijo4_4);

        //5ºCOMIDA
        Element hijoRaiz5 = doc.createElement("comida");
        raiz.appendChild(hijoRaiz5);

        Element hijo1_5 = doc.createElement("nombre");
        hijo1_5.appendChild(doc.createTextNode("Sopa castellena"));
        hijoRaiz5.appendChild(hijo1_5);

        Element hijo2_5 = doc.createElement("precio");
        hijo2_5.appendChild(doc.createTextNode("6.95"));
        hijoRaiz5.appendChild(hijo2_5);

        Element hijo3_5 = doc.createElement("descripcion");
        hijo3_5.appendChild(doc.createTextNode("Sopa a base de pan,huevo,pimenton y ajo"));
        hijoRaiz5.appendChild(hijo3_5);

        Element hijo4_5 = doc.createElement("calorias");
        hijo4_5.appendChild(doc.createTextNode("950"));
        hijoRaiz5.appendChild(hijo4_5);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(ruta));
        transformer.transform(source, result);
        //FIN CREACION XML

        //XPATH:
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        NodeList mas900Calorias = (NodeList) xPath.evaluate("menu/comida[calorias=900]/nombre", doc, XPathConstants.NODESET);
        NodeList menos6Euros = (NodeList) xPath.evaluate("menu/comida[precio<\"6\"]/descripcion", doc, XPathConstants.NODESET);

        System.out.print("Nombre comida con 900 calorias: [");
        imprimirTexto(mas900Calorias);
        System.out.println("]");
        System.out.print("Descripcion comida con un precio menor a 6€: [");
        imprimirTexto(menos6Euros);
        System.out.println("]");
    }

    private static void imprimirTexto(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (i == nodeList.getLength() - 1) {
                System.out.print(nodeList.item(i).getTextContent());
            } else {
                System.out.print(nodeList.item(i).getTextContent() + ", ");
            }
        }
    }

}
