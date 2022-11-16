/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pspej2;

/**
 *
 * @author dam
 */
public class Parking {

    public static void main(String[] args) {
        int N = Integer.parseInt("5");
//Inicializar el parking
        Barrera barrera = new Barrera(N);
        int C = Integer.parseInt("6");
        Coche coches[] = new Coche[C];
        for (int i = 0; i < C; i++) {
            coches[i] = new Coche(i + 1, barrera);
            coches[i].start();
        }
        try {
            for (int i = 0; i < C; i++) {
                coches[i].join();
            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo principal interrumpido.");
        }
    }
}
