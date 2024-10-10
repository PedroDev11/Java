package com.example.hilos.sync.runnable;

import java.util.concurrent.ThreadLocalRandom;

import com.example.hilos.sync.Panaderia;

public class Panadero implements Runnable {
    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            panaderia.hornear("Pan numero: " + i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
