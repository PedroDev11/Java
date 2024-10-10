package com.example.hilos.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class AgendarTareaTimerPeriodo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        AtomicInteger contadorAtomic = new AtomicInteger(3);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                if (i > 0) {
                    System.out.println("Tarea " + i + " periodica en: " + new Date().toString() + " nombre del Thread: "
                            + Thread.currentThread().getName());
                } else {
                    System.out.println("Finaliza el tiempo");
                    // Si ya no se va a utilizar lo podemos cancelar
                    timer.cancel();
                }
            }
        }, 0, 10000);

        System.out.println("Agendamos una tarea inmediata que se repite en 10 segundos ...");
    }
}
