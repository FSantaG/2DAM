/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santamaria_fernando_ejer1;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

/**
 *
 * @author dam
 */
@XmlRootElement(name="sakila")
public class Sakila {
    private ArrayList<Actor> actores = new ArrayList();
    
    public Sakila(){
    }
    
    @XmlElementWrapper(name="actores")
    @XmlElement(name="actor")
    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }
}
