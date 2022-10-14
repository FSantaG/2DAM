
package ejercicio3;
import java.io.*;
/**
 *
 * @author fsantaG
 */
public class ej3 {
    public static void main(String[] args){
       //Creación del nuevo directorio
       File nuevoDir = new File("NUEVODIR");
       //mkdirs -> Crea un nuevo directorio
       if(nuevoDir.mkdirs()){
           System.out.println("El directorio se ha creado correctamente");
       }else{
           System.out.println("El directorio no se ha creado, o ya existía");
       }
       
       //Creación de los 2 archivos de texto de dentro del nuevo directorio
       File fichero1 = new File("NUEVODIR\\FICHERO1.txt");
       File fichero2 = new File("NUEVODIR\\FICHERO2.txt");
       File fichero1Nuevo = new File ("NUEVODIR\\FICHERO1NUEVO.txt");
       
       try{
           //Está dentro de un grupo try/catch porque createNewFile() puede dar una excepción
           //createNewFile() -> Crea el archivo siguiendo la ruta ofrecida
            if(fichero1.createNewFile()){
                System.out.println("Fichero1 se ha creado correctamente");
            }else{
                System.out.println("Fichero1 no se ha creado, o ya existía");
            }
            
            if(fichero2.createNewFile()){
               System.out.println("Fichero2 se ha creado correctamente");
            }else{
                System.out.println("Fichero2 no se ha creado, o ya existía");
            }
            //renameTo() -> Renombra el archivo según la información ofrecida por otra variable de tipo File.
            if(fichero1.renameTo(fichero1Nuevo)){
                System.out.println("Fichero1 ha sido renombrado a Fichero1Nuevo");
            }else{
                System.out.println("No se ha renombrado el archivo porque ya existía");
            }
            
            //delete() -> Borra el archivo o directorio
            if(fichero2.delete()){
               System.out.println("Fichero2 se ha eliminado correctamente");
            }else{
                System.out.println("Fichero2 no se ha eliminado, o no existía");
            }
            
            
       }catch(Exception e){
           System.out.println("Se ha producido un error: " + e.getMessage());
        }
       
    }
    

}
