
import java.io.File;
/**
 *
 * @author dam
 */

class ejercicio{
    public static void main(String[] args){
        File archivo = new File("C:\\Users\\dam\\Documents\\NetBeansProjects\\Ejercicio1\\alumno.xml");
        System.out.println("Nombre del Archivo: " + archivo.getName());
        System.out.println("Carpeta Padre: " + archivo.getParent());
        System.out.println("Ruta Absoluta: " + archivo.getAbsolutePath());
        System.out.println("Ruta Relativa: " + archivo.getPath());
        
        if(archivo.exists()){
            System.out.println("El fichero alumno.xml existe");
            if(archivo.canRead()){
                System.out.println("El fichero alumno.xml puede ser leído");
            }else{
                System.out.println("El fichero alumno.xml no puede ser leído");
            }
            if(archivo.canWrite()){
                System.out.println("El fichero alumno.xml puede ser escrito");
            }else{
                System.out.println("El fichero alumno.xml no puede ser escroto");
            }
            System.out.println("Tamaño del archivo: " + archivo.length());
        }else{
            System.out.println("El fichero alumno.xml no existe");
        }
    }
}

