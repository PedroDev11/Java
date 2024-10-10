package com.example.hilos.sync.runnable;

import com.example.hilos.sync.Panaderia;

public class Consumidor implements Runnable {
    private Panaderia panaderia;

    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            panaderia.consumir();
        }
    }

}
