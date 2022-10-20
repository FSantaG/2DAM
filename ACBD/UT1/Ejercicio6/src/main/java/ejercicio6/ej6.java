/**
 * Crea un nuevo proyecto en Java llamado Ejercicio6
    - Utiliza la buferización de datos.
    - Lee el fichero java de este ejercicio línea por línea y muéstralo por pantalla.
    - Crea un fichero llamado Ejercicio6.txt
    - Escribe 10 filas de caracteres con el número de cada fila:
        o Fila número 1
        o Fila número 2
        o ...
        o Fila número 10
    - Recuerda hacer un salto de línea por cada fila que escribes.
 */
package ejercicio6;
import java.io.*;
/**
 *
 * @author fsantag
 */
public class ej6 {
    public static void main(String[] args){
        File archivoEj6 = new File("src\\main\\java\\ejercicio6\\ej6.java");
        File archivoTexto = new File("ejercicio6.txt");
        try{
            FileReader lectorArchivo = new FileReader(archivoEj6);
            BufferedReader buffedLectorArchivo = new BufferedReader(lectorArchivo);
            
            FileWriter escritorArchivo = new FileWriter(archivoTexto);
            BufferedWriter buffedEscritorArchivo = new BufferedWriter(escritorArchivo);

            //Mientras el bufferedReader está listo, imprime las líneas del archivo
            while (buffedLectorArchivo.ready()) { 
                System.out.println(buffedLectorArchivo.readLine()); 
            }
            buffedLectorArchivo.close();
            
            //Escritura de las líneas en el txt
            for(int i = 1; i <= 10; i++){
                buffedEscritorArchivo.write("Fila número " + i);
                buffedEscritorArchivo.newLine();
            }
            buffedEscritorArchivo.close();
            
        }
        catch(Exception e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }
}
