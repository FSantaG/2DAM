package ejercicio2;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorEjercicio2 extends DefaultHandler {

    String localName;
    String textoEtiq;
    int pos = 0;
    boolean masComida = false;
    ArrayList<Comida> comidas = new ArrayList();
    ProcesaEjercicio2 procesaComida;

    @Override
    public void startElement(String uri, String localName, String name,
            Attributes attributes) throws SAXException {

        if (localName.equals("comida")) {
            comidas.add(new Comida());
            if (masComida) {
                pos++;
            }
            masComida = false;

        }
        this.localName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (!String.valueOf(ch, start, length).trim().equals("")) {
            textoEtiq = String.valueOf(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        float precio = 0;
        if (localName.equals("nombre")) {
            comidas.get(pos).setNombre(textoEtiq);
        }
        if (localName.equals("precio")) {
            precio = Float.parseFloat(textoEtiq);
            comidas.get(pos).setPrecio(precio);
        }
        if (localName.equals("descripcion")) {
            comidas.get(pos).setDescripcion(textoEtiq);
        }
        if (localName.equals("calorias")) {
            comidas.get(pos).setCalorias(textoEtiq);
        }
        if (localName.equals("comida")) {
            procesaComida = new ProcesaEjercicio2(comidas.get(pos));
            masComida = true;
        }
    }
}
