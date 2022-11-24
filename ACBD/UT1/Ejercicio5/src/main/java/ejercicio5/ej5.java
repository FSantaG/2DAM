/**
 * Crea un nuevo proyecto en Java llamado Ejercicio5
 * Crea un fichero de texto llamado FICHTEXTO.txt
 * Escribe en el fichero que acabas de crear: “Esto es una prueba de escribir cadenas de caracteres en un fichero de texto”.
 * Después añade al final tu nombre y apellidos.
 */
package ejercicio5;
import java.io.*;

/**
 *
 * @author dam
 */
public class ej5 {
    public static void main(String[] args) {
        File fichTexto = new File("FICHTEXT.txt");
        
        try{
            if(!(fichTexto.createNewFile())){
                System.out.println("Fichero ya existente");
            }else{
                FileWriter escribirArchivo = new FileWriter(fichTexto);
                escribirArchivo.write("Esto es una prueba de escribir cadenas de caracteres en un fichero de texto");
                escribirArchivo.close();
                FileWriter escribirArchivo2 = new FileWriter(fichTexto, true);
                escribirArchivo2.write("\n");
                escribirArchivo2.write("Fernando Santamaría García");
                escribirArchivo2.close();
            }
        }catch(Exception e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }
}
