package practica1;

import java.util.Scanner;

public class Ej09 {

    private static boolean esPrimo(int num) {

        if (num == 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");

        int num = teclado.nextInt();

        teclado.close();

        System.out.print(num + "# = ");

        long primorial = 1;

        for (int i = 1; i <= num; i++)               // Recorre los números
            if (esPrimo(i)) primorial *= i;          // Si lo es lo añade al primorial

        System.out.print(primorial);

    }
}
