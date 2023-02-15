/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codigo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author shyne
 */
public class CifradoG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, StandardCharsets.ISO_8859_1);
        String mensaje;
        char caracter;
        int codigoAscii;
        int intercambioValor1, intercambioValor2, intercambioValor3, intercambioValor4;
        String binario;

        String encriptado = "";
        String llave = "";
        System.out.println("mensaje");
        mensaje = sc.nextLine();
        for (int i = 0; i < mensaje.length(); i++) {
            caracter = mensaje.charAt(i);
            //System.out.println("caracter mensajecharat: "+ caracter);
            codigoAscii = caracter;
            System.out.println(codigoAscii);
            binario = "";
            //System.out.println("caracter 1: "+ caracter + " numero: "+ codigoAscii);
            //letras son 8 digitos en ASCII
            /**
             
             
             */
            for (int j = 7; j >= 0; j--) {
                boolean codigo = codigoAscii >= Math.pow(2, j);
                if (codigo) {
                    //para que no me repita el anterior
                    codigoAscii -= Math.pow(2, j);
                   
                    binario = binario.concat("1");
                } else {
                    binario = binario.concat("0");
                }
                System.out.println(binario);
            }

            do {
                intercambioValor1 = (int) (Math.random() * 10);
                System.out.println("int 1: "+intercambioValor1);
            } while (intercambioValor1 > 7);
            do {
                intercambioValor2 = (int) (Math.random() * 10);
                System.out.println("int 2: "+intercambioValor2);
            } while (intercambioValor2 > 7 || intercambioValor2 == intercambioValor1);
            do {
                intercambioValor3 = (int) (Math.random() * 10);
                System.out.println("int 3: "+intercambioValor3);
            } while (intercambioValor3 > 7 || intercambioValor3 == intercambioValor1
                    || intercambioValor3 == intercambioValor2);
            do {
                intercambioValor4 = (int) (Math.random() * 10);
                System.out.println("int 4: "+intercambioValor3);
            } while (intercambioValor4 > 7 || intercambioValor4 == intercambioValor1
                    || intercambioValor4 == intercambioValor2 || intercambioValor4 == intercambioValor3);
            String binarioEncriptado = "";
            for (int x = 0; x < 8; x++) {
                caracter = binario.charAt(x);
                //mediante 4 digitos se intercambian los 4 valores
                //es decir que el binario original se swapea valor por valor
                //si
                if (x == intercambioValor1) caracter = binario.charAt(intercambioValor2);
                if (x == intercambioValor2) caracter = binario.charAt(intercambioValor1);
                if (x == intercambioValor3) caracter = binario.charAt(intercambioValor4);
                if (x == intercambioValor4) caracter = binario.charAt(intercambioValor3);
                System.out.println("a: "+intercambioValor1+" "+" b: "+intercambioValor2+
                        " c: "+intercambioValor3+ " d: "+intercambioValor4);
                System.out.print("caracter: "+caracter);
                binarioEncriptado = binarioEncriptado.concat(Character.toString(caracter));
                
            }
            encriptado = encriptado.concat(binarioEncriptado);
            
            llave = llave.concat(String.valueOf(intercambioValor1) + String.valueOf(intercambioValor2
                    + String.valueOf(intercambioValor3 + String.valueOf(intercambioValor4))));
            

        }
        System.out.println(encriptado);
        System.out.println(llave);
        escribirFichero(encriptado, llave);
        leerFichero("mensajeEncriptado.txt", "llave.txt");

    }

    public static void escribirFichero(String encriptado, String llave) {

        try {
            FileWriter fichero = new FileWriter("mensajeEncriptado.txt");
            fichero.write(encriptado);
            fichero.close();
            fichero = new FileWriter("llave.txt");
            fichero.write(llave);
            fichero.close();
            System.out.println("El mensaje encriptado es: " + encriptado);
            System.out.println("La llave es: " + llave);
        } catch (Exception e) {
        }

    }

    public static void leerFichero(String encriptado, String llave) {
        try {
            FileReader fichero = new FileReader(llave);
            BufferedReader br = new BufferedReader(fichero);
            String lecturaLlave = br.readLine();
            fichero.close();
            System.out.println("");
            fichero = new FileReader(encriptado);
            br = new BufferedReader(fichero);
            String lecturaEncriptado = br.readLine();
            fichero.close();
            String binario = "";
            //se comienza con la primera letra, una vez que sean 8 digitos pasaremos a la segunda
            int letra = 0;
            //recorrer caracter a caracter
            int indexLlave = 0;
            //-48 es por que en ASCII el 1 es valor ascii 49 el 2 es 50
            //cuando leo el valor de la cadena para volver a la posicion original lo leo ne asi
            //le resto 48, y me queda el numero verdadero que tiene.
            //y con eso se que la posicion se tiene que intercambiar
            int intercambio1 = Character.valueOf(lecturaLlave.charAt(indexLlave)) - 48;
            indexLlave++;
            int intercambio2 = Character.valueOf(lecturaLlave.charAt(indexLlave)) - 48;
            indexLlave++;
            int intercambio3 = Character.valueOf(lecturaLlave.charAt(indexLlave)) - 48;
            indexLlave++;
            int intercambio4 = Character.valueOf(lecturaLlave.charAt(indexLlave)) - 48;
            indexLlave++;
            System.out.println(intercambio1 + " " + intercambio2 + " " + intercambio3 + " " + intercambio4);
            char caracter;
            int codigoAscii;
            int auxiliar = 0;

            String mensajeDesencriptado = "";

            for (int i = 0; i < lecturaEncriptado.length(); i++) {
                caracter = lecturaEncriptado.charAt(i);
                /*
                cuando la variable letra este en 0 letra = 0
                cuando este en 1 letra ira a la posicion 8
                cuando este en 2 valdra 16
                lo que tengo en la llave son valores relativos
                
                 */
                if (i - (letra * 8) == intercambio1) {
                    caracter = lecturaEncriptado.charAt((letra * 8) + intercambio2);
                }
                if (i - (letra * 8) == intercambio2) {
                    caracter = lecturaEncriptado.charAt((letra * 8) + intercambio1);
                }
                if (i - (letra * 8) == intercambio3) {
                    caracter = lecturaEncriptado.charAt((letra * 8) + intercambio4);
                }
                if (i - (letra * 8) == intercambio4) {
                    caracter = lecturaEncriptado.charAt((letra * 8) + intercambio3);
                }

                binario = binario.concat(Character.toString(caracter));
                System.out.println(binario);
                auxiliar++;

                //hemos avanzado una letra
                if (auxiliar % 8 == 0) {
                    codigoAscii = 0;
                    //se transforma el codigo a caracter
                    for (int j = 0; j < 8; j++) if (binario.charAt(j) == '1') codigoAscii += Math.pow(2, (7 - j));
                            caracter = (char) codigoAscii;
                            System.out.println(caracter);
                            binario = "";
                            letra++;

                    mensajeDesencriptado = mensajeDesencriptado.concat(Character.toString(caracter));

                    if (indexLlave < lecturaLlave.length()) {
                        intercambio1 = Character.valueOf(lecturaLlave.charAt(indexLlave)) - 48;
                        indexLlave++;
                        intercambio2 = Character.valueOf(lecturaLlave.charAt(indexLlave)) - 48;
                        indexLlave++;
                        intercambio3 = Character.valueOf(lecturaLlave.charAt(indexLlave)) - 48;
                        indexLlave++;
                        intercambio4 = Character.valueOf(lecturaLlave.charAt(indexLlave)) - 48;
                        indexLlave++;
                    }
                }
            }
            System.out.println("Mensaje desencriptado");
            System.out.println(mensajeDesencriptado);

        } catch (Exception e) {

        }
    }

    

}
