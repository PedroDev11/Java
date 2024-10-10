package com.example.hilos.sync;

public class Panaderia {
    private String pan;
    private boolean disponible;

    public synchronized void hornear(String masa) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.pan = masa;
        System.out.println("EL pan se esta horneando: " + this.pan);

        this.disponible = true;
        
        // notificamos que el pan esta listo
        notify();
    }

    public synchronized String consumir() {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cliente consumiento: " + this.pan);
        this.disponible = false;
        notify();
        return pan;
    }
}
