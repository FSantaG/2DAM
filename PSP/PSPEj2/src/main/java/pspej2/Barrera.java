/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pspej2;

/**
 *
 * @author dam
 */
import java.util.Random;

class Barrera {

    private int plazas[];
    private int n_plazas;
    private int libres;

    Barrera(int N) {
        n_plazas = N;
        plazas = new int[N];
        for (int i = 0; i < n_plazas; i++) {
            plazas[i] = 0;
        }
        libres = n_plazas;
    }

    synchronized public int entrada(int coche) throws
            InterruptedException {
        int plaza = 0;
        imprimir();
        while (libres == 0) {
            System.out.println("Coche " + coche + "esperando");
            wait();
        }
        while (plazas[plaza] != 0) {
            plaza++;
        }
        plazas[plaza] = coche;
        libres--;
        return plaza;
    }

    synchronized public void salida(int plaza) {
        plazas[plaza] = 0;
        libres++;
        notify();
    }

    public void imprimir() {
        System.out.print(
                "Parking:");
        for (int i = 0; i < n_plazas; i++) {
            System.out.print("[" + plazas[i]
                    + "] ");
        }
        System.out.println("");
    }
}
