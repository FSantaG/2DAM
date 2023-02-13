package pojos;
// Generated 6 feb. 2023 9:34:18 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idusuario;
     private String nombre;
     private Integer edad;
     private Set prestamoses = new HashSet(0);

    public Usuario() {
    }
    
     public Usuario(int id) {
        this.idusuario = id;
    }
    
    public Usuario(String nombre, Integer edad, Set prestamoses) {
       this.nombre = nombre;
       this.edad = edad;
       this.prestamoses = prestamoses;
    }
   
    public Integer getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getEdad() {
        return this.edad;
    }
    
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public Set getPrestamoses() {
        return this.prestamoses;
    }
    
    public void setPrestamoses(Set prestamoses) {
        this.prestamoses = prestamoses;
    }




}


