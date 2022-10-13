/**
 * Crea un nuevo proyecto en Java llamado Ejercicio2

- Utiliza el paquete java.io
- Muestra por pantalla:
    o ¿Cuántos ficheros y/o directorios contiene el directorio actual?
    o ¿Qué tamaño en bytes tienen?
    o Los nombres de todos los ficheros y/o directorios
        ▪ Y por cada uno de ellos si es fichero o directorio
@author fsantag
 */
package ejercicio2;
import java.io.*;

public class ej2 {
    public static void main(String[] args){
        //Se crea una variable de tipo File en la que se almacena el directorio actual 
        File directorioActual = new File(System.getProperty("user.dir"));
        //Se crea un array con los archivos obtenidos, y se cuentan
        String[] archivos = directorioActual.list();
        System.out.println("El directorio actual tiene " +  archivos.length + " archivos");
        
        //Se recorre el array, asignando cada valor a una variable de tipo File, para usar los métodos de dicha clase y obtener
        //la información pertinente
        for(int i = 0; i < archivos.length; i++){
            File archivo = new File(archivos[i]);
            //Nombre del archivo
            System.out.print(archivo.getName());
            System.out.print(" ");
            //Si es directorio o fichero
            if(archivo.isFile()){
                System.out.print("(Es fichero): ");
            }else if(archivo.isDirectory()){
                System.out.print("(Es directorio): ");
            }
            //Tamaño en bytes
            System.out.print("Tamaño en bytes: " + archivo.length());
            System.out.print("\n");
        }
    }
}
