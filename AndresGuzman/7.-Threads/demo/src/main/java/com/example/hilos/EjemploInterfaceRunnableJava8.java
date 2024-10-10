package com.example.hilos;


public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        Runnable viaje = () -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
            };

        Thread v1 = new Thread(viaje, "Isla canaria");
        Thread v2 = new Thread(viaje, "España");
        Thread v3 = new Thread(viaje, "USA");

        v1.start();
        v2.start();
        v3.start();

        v1.join();
        v2.join();
        v3.join();

        // Thread.sleep(5000);
        // Justo cuando termina el ultimo, continua el main, se mantiene en un estado de waiting
        System.out.println("Continuando con la ejecucion del metodo main");
    }
}
