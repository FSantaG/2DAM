package ejercicio2;

class Comida {

    private String nombre;
    private float precio;
    private String descripcion;
    private String calorias;

    public Comida() {
        this.nombre = "";
        this.precio = 0f;
        this.descripcion = "";
        this.calorias = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }
    
    @Override
    public String toString() {
        return "Nombre:" + nombre + "\nDescripcion:" + descripcion
                + "\nCalorias: " + calorias + "\nPrecio:" + precio;
    }

}
