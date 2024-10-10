package com.example.hilos;

import com.example.hilos.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {

    public static void main(String[] args) {
        new Thread(new ImprimirFrases("Hola ", "Que tal")).start();
        new Thread(new ImprimirFrases("Quien eres ", "Tu?")).start();
        new Thread(new ImprimirFrases("Muchas ", "Gracias amigo")).start();
    }

    // Cada hilo va a ingresar a este metodo, lo va a utilizar en orden, cuando un hilo este 
    // Siendo utilizado, los demas hilos estaran bloqueados, esperando a que el primero hilo
    // termine de utilizar este metodo.
    public synchronized static void imprimirFrases(String frase1, String frase2) {
        System.out.print(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(frase2);
    }
}
