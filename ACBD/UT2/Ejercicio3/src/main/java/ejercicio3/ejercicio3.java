
package ejercicio3;

import java.io.File;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;

/**
 * Práctica de XPATH
 * @author dam
 */
public class ejercicio3 {
    public static void main(String[] args) throws Exception{
        File archivoEmpleados = new File("Empleados.xml");
        
        //Obtención del DOM
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document xml = db.parse(archivoEmpleados);
        xml.getDocumentElement().normalize();
        
        // Obtención del XPath
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        
        //Comprueba el empleado o empleada con id = 4
        String empId4 = (String)xpath.evaluate(
            "Empleados/Empleado[@id = \"4\"]/nombre", xml,
            XPathConstants.STRING);
        System.out.println("Empleado/a con ID 4: " + empId4);
        
        //Comprueba los empleados menores de 30
        NodeList empMayor30 = (NodeList)xpath.evaluate(
            "Empleados/Empleado[edad < 30]/nombre", xml,
            XPathConstants.NODESET);
        System.out.print("Empleados/as con menos de 30 años: ");
        imprimirNodos(empMayor30);
        
        //Encuentra las empleadas
        NodeList empleadas = (NodeList)xpath.evaluate(
            "Empleados/Empleado[genero = \"Mujer\"]/nombre", xml,
            XPathConstants.NODESET);
        System.out.print("Nombre/s de empleada/s mujer/es: ");
        imprimirNodos(empleadas);
        
        //Sigue los nodos del primer empleado
        String empNodos = (String)xpath.evaluate(
            "Empleados/Empleado[@id = \"1\"]", xml,
            XPathConstants.STRING);
        System.out.print("Nodos: " + empNodos);
        //imprimirNodos(empNodos);
    }
    
    /**
     * Imprime los nodos siguiendo el formato establecido
     * @param nodos Lista de resultados
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
