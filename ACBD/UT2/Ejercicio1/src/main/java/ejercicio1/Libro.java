
package ejercicio1;

/**
 *
 * @author dam
 */
public class Libro {
    String isbn;
    String nombre;
    String autor;
    String editorial;
    String year;
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public void imprimirDatos(){
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Nombre del Libro: " + this.nombre);
        System.out.println("Autor: " + this.autor);
        System.out.println("Editorial: " + this.editorial);
        System.out.println("Año de publicación: " + this.year);
    }
}
