package com.example.hilos.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea...");

            try {
                System.out.println("Nombre del Thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // Interrumpir la ejecucion del Thread actual
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.out.println("Finaliza la tarea...");
        };

        executor.submit(tarea);
        executor.shutdown();

        // Esperar a que finalize todas las tareas, y luego que se detenga el executor 
        // para continuar con la ejecucion del main. Esperar a que finalize los procesos Thread 
        // o deja de esperar cuando ocurre el timeout que se recibe como argumento y continua con el main
        // Recibe como argumento el numero y la unidad de tiempo
        System.out.println("Continuando con la ejecucion del main 1");
        executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Continuando con la ejecucion del main 2");
    }
}
