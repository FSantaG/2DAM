package ejercicio3;

import java.io.File;
import java.io.FileReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Ejercicio3 {

    public static void main(String[] args) throws Exception {
        String ruta = "MenuCompletoServicio.xml";//RUTA ABSOLUTA DEL NUEVO XML QUE VAMOS A GENERAR
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document documento = (Document) db.parse("MenuCompleto.xml");

        Node ultimaComida = (Node) (XPathFactory.newInstance().newXPath().evaluate("menu", documento, XPathConstants.NODE));
        if (ultimaComida != null) {
            Element elementoNuevo = documento.createElement("servicio");
            elementoNuevo.appendChild(documento.createTextNode("En local,en terraza y para llevar"));
            ultimaComida.appendChild(elementoNuevo);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(documento);
        StreamResult result = new StreamResult("MenuCompleto.xml");
        transformer.transform(source, result);

        FileReader fr = new FileReader("MenuCompleto.xml");
        int posCaracter = fr.read();
        while (posCaracter != -1) {
            System.out.print((char) posCaracter);
            posCaracter = fr.read();
        }
    }

}
