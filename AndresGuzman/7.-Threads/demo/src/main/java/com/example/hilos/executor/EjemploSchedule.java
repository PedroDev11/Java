package com.example.hilos.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploSchedule {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main...");

        // Parte con un retraso de 1 segundo y despues ejecuta la tarea, donde toma una espera
        // de 1 segundo mas
        executor.schedule(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hola mundo tarea...");
        }, 2000, TimeUnit.MILLISECONDS);

        executor.shutdown();

        System.out.println("Alguna otra tarea en el main");
    }
}
