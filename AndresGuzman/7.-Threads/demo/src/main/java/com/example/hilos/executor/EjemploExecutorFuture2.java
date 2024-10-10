package com.example.hilos.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // Ejecuta un solo Thread (newSingleThreadExecutor)
        // Ejecuta n cantidad de Threads al mismo tiempo (newFixedThreadPool)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea...");

            try {
                System.out.println("Nombre del Thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                // Interrumpir la ejecucion del Thread actual
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.out.println("Finaliza la tarea...");
            return "Algún resultado de la consulta";
        };

        Callable<Integer> tarea3 = () -> {
            System.out.println("Iniciando tarea 3");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        Future<String> result = executor.submit(tarea);
        Future<String> result2 = executor.submit(tarea);
        Future<Integer> result3 = executor.submit(tarea3);

        executor.shutdown();
        System.out.println("Continuando con la ejecucion del main 1");

        while (!(result.isDone() && result2.isDone() && result3.isDone())) {
            System.out.println(String.format("result1: %s - result2: %s - result3: %s", 
            result.isDone()? "finalizó" : "en proceso",
            result2.isDone()? "finalizó" : "en proceso",
            result3.isDone()? "finalizó" : "en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        
        System.out.println("Obtenemos resultado de la tarea 1 (Callable): " + result.get(5, TimeUnit.SECONDS));
        System.out.println("Obtenemos resultado de la tarea 2 (Callable): " + result2.get(5, TimeUnit.SECONDS));
        System.out.println("Obtenemos resultado de la tarea 3 (Callable): " + result3.get(5, TimeUnit.SECONDS));
        
        System.out.println("Finaliza la tarea1?: " + result.isDone());
        System.out.println("Finaliza la tarea2?: " + result2.isDone());
        System.out.println("Finaliza la tarea3?: " + result3.isDone());
    }
}
