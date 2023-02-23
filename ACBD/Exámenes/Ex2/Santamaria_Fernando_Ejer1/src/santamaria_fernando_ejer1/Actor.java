/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santamaria_fernando_ejer1;

import javax.xml.bind.annotation.*;

/**
 *
 * @author dam
 */
@XmlRootElement(name="actor")
@XmlType(propOrder={"id","nombre","apellido"})
public class Actor {
    
    private int id;
    private String nombre;
    private String apellido;

    public Actor() {
        
    }
    
    @XmlAttribute(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
