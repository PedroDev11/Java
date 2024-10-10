package com.example.hilos.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploSchedulePeriodo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main...");

        // Parte con un retraso de 1 segundo y despues ejecuta la tarea, y cada tarea se repite
        // en un periodo de 2 segundos
        executor.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hola mundo tarea...");
        }, 1000, 2000, TimeUnit.MILLISECONDS);

        TimeUnit.SECONDS.sleep(10);
        executor.shutdown();

        System.out.println("Alguna otra tarea en el main");
    }
}
