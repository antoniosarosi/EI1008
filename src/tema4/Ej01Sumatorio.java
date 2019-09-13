package tema4;

import java.util.Scanner;

public class Ej01Sumatorio {

	public static void main(String[] args) {
		System.out.println("SUMATORIO DE 1 A N");

		Scanner consola = new Scanner(System.in);
		System.out.print("\nDame un número entero (<= 0 para acabar): ");
		int n = consola.nextInt();
		while (n > 0) {
			System.out.println("Sumatorio de 1 a " + n + ":");
			System.out.println("  1ª versión (constant): " + sumatorioConstante(n));
			System.out.println("  2ª versión (iterativa): " + sumatorioIterativo(n));
			System.out.println("  3ª versión (recursiva): " + sumatorioRecursivo(n));

			System.out.print("\nDame un número entero (<= 0 para acabar): ");
			n = consola.nextInt();
		}
		consola.close();
	}

	// Devuelve el sumatorio de los números enteros de 1 a n (n > 0).
	// Coste temporal O(1) y coste espacial O(1).
	public static long sumatorioConstante(int n) {
		return (1 + n) * n / 2;
	}

	// Devuelve el sumatorio de los números enteros de 1 a n (n > 0).
	// Coste temporal O(n) y coste espacial O(1).
	public static long sumatorioIterativo(int n) {
		int sumatorio = 0;
		for (int i = 1; i <= n; i++)
			sumatorio += i;
		return sumatorio;
	}
	
	// Devuelve el sumatorio de los números enteros de 1 a n (n > 0).
	// Coste temporal O(n) y coste espacial O(n).
	public static long sumatorioRecursivo(int n) {
		if (n == 1)  // Caso base
			return 1;
		else
			return sumatorioRecursivo(n - 1) + n;
	}

}
