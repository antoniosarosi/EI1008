package practica1;

import java.util.Scanner;

public class Ej02 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");

        int num = teclado.nextInt();

        teclado.close();

        long factorialDoble = 1;

        if (num % 2 == 0) {
            for (int i = 2; i <= num; i += 2) {
                factorialDoble *= i;
            }
        }

        else {
            for (int i = 1; i <= num; i += 2) {
                factorialDoble *= i;
            }
        }

        System.out.print(num + "!! = " + factorialDoble);

    }
}
