package practica1;

import java.util.Scanner;

public class Ej06 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");

        int num = teclado.nextInt();
        teclado.close();
        int numConMasDivisores = 1, cantidadDivisores = 0;


        for (int i = 1; i <= num; i++) {

            int divisores = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisores++;
                }
            }

            if (divisores >= cantidadDivisores) {
                numConMasDivisores = i;
                cantidadDivisores = divisores;
            }

        }

        System.out.print("El número con más divisores es " + numConMasDivisores + " (" + cantidadDivisores + " divisores)");
    }
}
