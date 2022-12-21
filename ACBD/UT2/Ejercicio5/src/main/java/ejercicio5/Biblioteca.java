package ejercicio5;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *Clase que almacena los datos de los juegos disponibles en la Biblioteca
 * @author Fernando Santamaría
 */

//Anotación que denota la etiqueta raiz del XML a leer
@XmlRootElement(name="biblioteca")
public class Biblioteca {
    private ArrayList<Juego> juegos = new ArrayList();
    
    public Biblioteca(){
    }
    
    //Anotación que demarca que juegos será una etiqueta con etiquetas dentro (wrapper)
    @XmlElementWrapper(name="juegos")
    //Demarca la cada etiqueta hija del contenedor
    @XmlElement(name="juego")
    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<Juego> juegos) {
        this.juegos = juegos;
    }
    
}
