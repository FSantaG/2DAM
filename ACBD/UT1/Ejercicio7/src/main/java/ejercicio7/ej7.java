/*
*Crea un nuevo proyecto en Java llamado Ejercicio7:
*
*   o Crea tu propio ejercicio aplicando las clases que hemos visto para trabajar con ficheros binarios.
*   o Al inicio del fichero java expresa mediante un comentario lo que hace el programa. 
*     Comenta sobre el código lo necesario para que se entienda.
*/
package ejercicio7;
import java.io.*;
import java.util.*;

/**
 * Escritura de un archivo de texto mediante interacción directa del usuario con la consola, 
 * y lectura del mismo para comprobación del usuario de que sus datos han sido correctamente introducidos en
 * el archivo de texto.
 * @author Frenando Santamaria
 */
public class ej7 {
    public static void main(String[] args) {
        Boolean salir = false;
        String textoFinal = "";
        File log = new File("log.dat");
           try{
               do{ 
                   Scanner scanner = new Scanner(System.in);
                   FileOutputStream archivoTexto = new FileOutputStream(log);
                   FileInputStream archivoTextoR = new FileInputStream(log);
                   RandomAccessFile archivoRandom = new RandomAccessFile(log, "rw");
               
                   System.out.println("Escriba algo:");
                   String texto = scanner.nextLine();
               
                   textoFinal += texto + "\n";  
                   System.out.println("¿Desea seguir? S/N");
                   String checkSalida = scanner.nextLine();
                   
                   switch(checkSalida){
                       case "S":
                       case "s":                      
                           break;
                       case "N":
                       case "n":
                           byte caracteres[] = textoFinal.getBytes();
                           archivoTexto.write(caracteres);
                           archivoTexto.close();
                           System.out.println("Texto guardado:");
                           int i=0;    
                           while((i=archivoTextoR.read())!=-1){    
                                System.out.print((char)i);
                           }
                           archivoTextoR.close();
                           
                           System.out.println("Longitud del archivo: " + archivoRandom.length());
                           archivoRandom.close();
                           
                           salir = true;
                           break;
                       default:
                           System.out.println("El programa se ha cerrado");
                           archivoTexto.close();
                           salir=true;
                           break;
                   }
               }while(!salir);
           }catch(Exception e){
               System.out.println("Se ha producido un error: " + e.getMessage());
           }
    }
}
