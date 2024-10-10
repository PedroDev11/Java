package com.example.hilos.sync;

import com.example.hilos.sync.runnable.Consumidor;
import com.example.hilos.sync.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
