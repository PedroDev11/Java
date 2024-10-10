package org.example.bisiesto;

// Test 4
public class BisiestoUtil {

    // Metodo para verificar si un año es bisiesto
    public static boolean isLeapYear(int year) {

        // Si el año es divisible por 4 pero no por 100 es bisiesto
        // El año es bisiesto si es divisible por 400 (% resto de la division entera, si el resto de la
        // division de 400 es 0, es por que el año es divisible por 400)
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
        // Podemos refactorizar o simplificar en una sola linea ->
        // return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
