/**
 * Crea un nuevo proyecto en Java llamado Ejercicio4
 * Hacemos dos versiones:
 * 1.- Lee y muestra por pantalla cada uno de los caracteres del fichero java de este mismo ejercicio.
 * 2.- Lee y muestra por pantalla de 20 en 20 caracteres del fichero java de este mismo ejercicio.
 */
package ejercicio4;
import java.io.*;
/**
 *
 * @author dam
 */
public class ej4 {
    public static void main(String[] args) {
        File archivoPropio = new File("src\\main\\java\\ejercicio4\\ej4.java");
        //Parte 1: Imprime todo el archivo seguido
        try{
            FileReader lecturaArchivo = new FileReader(archivoPropio);
            int i;
            while((i = lecturaArchivo.read())!= -1){
                System.out.print((char)i);
            }
            lecturaArchivo.close(); 
        }catch(Exception e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
        
        //Parte 2: Imprime cadenas de 20 caracteres del código propio.
        try{
            FileReader lecturaArchivoParcial = new FileReader(archivoPropio);
            int i;
            int tope = 20;
            int contadorCaracteres = 0;
            while((i = lecturaArchivoParcial.read())!= -1){
                if(contadorCaracteres <= tope){
                    System.out.print((char)i);
                    contadorCaracteres++;
                }else{
                    System.out.print((char)i);
                    System.out.println("\nSALTO");
                    contadorCaracteres = 1;
                }
            }
            lecturaArchivoParcial.close();
        }catch(Exception e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }
}
