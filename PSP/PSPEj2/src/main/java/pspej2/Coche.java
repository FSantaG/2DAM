/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pspej2;

import java.util.Random;

/**
 *
 * @author dam
 */
class Coche extends Thread {

    private static final int MAX_DELAY = 2000;
    private int id;
    private Barrera barrera;

    Coche(int id, Barrera bar) {
        this.id = id;
        this.barrera = bar;
    }

    public void run() {
        try {
            Thread.sleep(new Random().nextInt(MAX_DELAY));
            System.out.println("Coche " + id + " intenta entrar en parking");
            int plaza = barrera.entrada(id);
            System.out.println("Coche " + id + " aparcado en " + plaza);
            barrera.imprimir();
            Thread.sleep(new Random().nextInt(MAX_DELAY));
            barrera.salida(plaza);
            System.out.println("Coche " + id
                    + " saliendo");
            barrera.imprimir();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
