package com.example.hilos;

import com.example.hilos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {
        new Thread(new ViajeTarea("Isala de pascua")).start();
        new Thread(new ViajeTarea("España")).start();
        new Thread(new ViajeTarea("Isla canaria")).start();
    }
}
