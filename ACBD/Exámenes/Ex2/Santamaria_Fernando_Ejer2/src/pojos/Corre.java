package pojos;
// Generated 17 feb. 2023 14:17:22 by Hibernate Tools 4.3.1



/**
 * Corre generated by hbm2java
 */
public class Corre  implements java.io.Serializable {


     private CorreId id;
     private Carrera carrera;
     private Piloto piloto;
     private String averias;
     private int tiempo;
     private String rol;

    public Corre() {
    }

	
    public Corre(CorreId id, Carrera carrera, Piloto piloto, int tiempo) {
        this.id = id;
        this.carrera = carrera;
        this.piloto = piloto;
        this.tiempo = tiempo;
    }
    public Corre(CorreId id, Carrera carrera, Piloto piloto, String averias, int tiempo, String rol) {
       this.id = id;
       this.carrera = carrera;
       this.piloto = piloto;
       this.averias = averias;
       this.tiempo = tiempo;
       this.rol = rol;
    }
   
    public CorreId getId() {
        return this.id;
    }
    
    public void setId(CorreId id) {
        this.id = id;
    }
    public Carrera getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    public Piloto getPiloto() {
        return this.piloto;
    }
    
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
    public String getAverias() {
        return this.averias;
    }
    
    public void setAverias(String averias) {
        this.averias = averias;
    }
    public int getTiempo() {
        return this.tiempo;
    }
    
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }




}


