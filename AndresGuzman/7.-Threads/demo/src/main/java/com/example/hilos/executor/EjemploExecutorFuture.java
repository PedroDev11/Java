package com.example.hilos.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

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

        Future<String> result = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecucion del main 1");

        System.out.println("Resultado boolean " + result.isDone());

        // No siempre es bueno llamarlo, porque bloquea el Thread actual (main), queda 
        // en espera hasta que se finalize el Thread en ejecucion y devuelve valor.
        // Al método get podemos pasarle como argumento un tiempo en el cual puede esperar 
        // a que se ejecute la tarea, en este caso dos segundos, sí se demora mas de 
        // lo esperado, ejecutará una excepcion (TimeOut)
        System.out.println("Resultado future (Callable) " + result.get(5, TimeUnit.SECONDS));
    }
}
