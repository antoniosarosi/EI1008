package practica1;

import java.util.Scanner;

public class Ej03 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");

        int num = teclado.nextInt();

        teclado.close();

        boolean esPrimo = true;

        int candidato = 2;

        while (esPrimo && candidato < num) {
            if (num % candidato == 0) esPrimo = false;
            candidato++;
        }

        System.out.println(esPrimo && num != 1 ? "Es primo" : "No es primo");

    }
}
