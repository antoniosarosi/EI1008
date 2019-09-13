package practica1;

import java.util.Scanner;

public class Ej05 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");

        int num = teclado.nextInt();

        teclado.close();

        System.out.print(num + "# = ");

        long primorial = 1;

        for (int i = 1; i <= num; i++) {             // Recorre los números

            boolean esPrimo = true;
            int candidato = 2;

            while (esPrimo && candidato < i) {      // Comprueba si es primo
                if (i % candidato == 0) {
                    esPrimo = false;
                }

                candidato++;
            }

            if (esPrimo) {                          // Si lo es lo añade al primorial
                primorial *= i;
            }
        }

        System.out.print(primorial);

    }
}
