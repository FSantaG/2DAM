package ejercicio5;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Clase que almacenará los juegos
 * @author Fernando Santamaría
 */

//Elemento raiz
@XmlRootElement(name="juego")
//Orden que siguen las etiquetas dentro del archivo
@XmlType(propOrder={"nombre","desarrolladora","fecha_salida"})
public class Juego {
    private String id;
    private String nombre;
    private String desarrolladora;
    private String fecha_salida;
    
    public Juego() {
    }
    
    //Denota un atributo
    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    /*
    * En el resto no hace falta poner que son elementos porque la propia
    * biblioteca lo entiende (siemrpe y cuando los nombres usados sean exactamente iguales a los de
    * el archivo XML
    */
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
}
