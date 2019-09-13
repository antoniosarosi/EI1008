package practica1;

import java.util.Scanner;

public class Ej10 {

    private static int contarDivisores(int num) {
        int divisores = 0;

        for (int i = 1; i <= num; i++)
            if (num % i == 0) divisores++;

        return divisores;
    }


    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");

        int num = teclado.nextInt();
        teclado.close();
        int numConMasDivisores = 1, cantidadDivisores = 0;


        for (int i = 1; i <= num; i++) {

            if (contarDivisores(i) >= cantidadDivisores) {
                numConMasDivisores = i;
                cantidadDivisores = contarDivisores(i);
            }
        }

        System.out.print("El número con más divisores es " + numConMasDivisores + " (" + cantidadDivisores + " divisores)");
    }
}
