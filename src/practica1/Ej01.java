package practica1;

import java.util.Scanner;

public class Ej01 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");

        int num  = teclado.nextInt();

        teclado.close();

        long factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        System.out.print(num + "! = " + factorial);
    }
}
