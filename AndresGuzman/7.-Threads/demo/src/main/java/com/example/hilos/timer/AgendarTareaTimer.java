package com.example.hilos.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AgendarTareaTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea realizada en: " + new Date().toString() + " nombre del Thread: "
                        + Thread.currentThread().getName());
                System.out.println("Finaliza el tiempo");
                
                // Si ya no se va a utilizar lo podemos cancelar
                timer.cancel();
            }
        }, 5000);

        System.out.println("Agendamos una tarea para 5 segundos mas ...");
    }
}
