package ejercicio2;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ProcesaEjercicio2 {

    /*AUNQUE NO LO PIDA EL EJERCICIO HE TRABAJADO CON UNA CLASE COMIDA YA QUE AL HABER TRABAJADO ASI ANTERIORMENTE ME RESULTABA MAS COMODO
    Y FACIL A LA HORA DE RESOLVER EL EJERCICIO*/
    
    static ArrayList<Comida> comidas = new ArrayList();

    public static void main(String[] args) throws Exception {

        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new ManejadorEjercicio2());
        reader.parse(new InputSource(new FileInputStream("MenuCompleto.xml")));

        String ruta = "C:\\Users\\DAM\\Desktop\\EXAMEN ACBD_CRISTIAN GONZÁLEZ\\Ejercicio2\\MenuFinal.txt";
        FileWriter fw = new FileWriter(ruta);

        //AUNQUE NO PIDA EL OUTPUT LO HE PUESTO PARA ASUGURARME QUE FUNCIONA CORRECTAMENTE EL EJERCICIO
        for (int i = 0; i < comidas.size(); i++) {
            System.out.println("Se ha añadido el plato numero: " + i);
            System.out.println("---------------------------------------------------");

        //ESTO ES LO QUE PIDE EL EJERCICIO
            if (comidas.get(i).getPrecio() < 7) {
                fw.write(comidas.get(i).toString());
                fw.flush();
                fw.write("\n----------------------------------------------------\n");
                fw.flush();
            }
        }
    }

    public ProcesaEjercicio2(Comida comida) {
        comidas.add(comida);
    }
}
