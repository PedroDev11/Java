package com.example.hilos;

import com.example.hilos.threads.NombreThread;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Thread hilo = new NombreThread("Jhon");
        hilo.start();
        // Thread.sleep(100); // RUNNABLE OR TERMINATED

        Thread hilo2 = new NombreThread("Pepe");
        hilo2.start();
        
        System.out.println(hilo.getState());
    }
}