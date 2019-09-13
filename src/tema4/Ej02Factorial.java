package tema4;

import java.util.Scanner;

public class Ej02Factorial {

	public static void main(String[] args) {
		System.out.println("FACTORIAL DE UN NÚMERO");

		Scanner consola = new Scanner(System.in);
		System.out.print("\nDame un número entero (< 0 para acabar): ");
		int n = consola.nextInt();
		while (n >= 0) {
			System.out.println(n + "! = " + factorialIterativo(n) + " (versión iterativa)");
			System.out.println(n + "! = " + factorialRecursivoTraza(n) + " (versión recursiva)");

			System.out.print("\nDame un número entero (< 0 para acabar): ");
			n = consola.nextInt();
		}
		consola.close();
	}

	// Devuelve el factorial de n (n >= 0).
	// Coste temporal O(n) y coste espacial O(1).
	public static long factorialIterativo(int n) {
		long productorio = 1;
		for (int i = 1; i <= n; i++)
			productorio *= i;
		return productorio;
	}

	// Devuelve el factorial de n (n >= 0).
	// Coste temporal O(n) y coste espacial O(n).
	public static long factorialRecursivo(int n) {
		if (n == 0) // Caso base
			return 1;
		else
			return factorialRecursivo(n - 1) * n;
	}

	public static long factorialRecursivoTraza(int n) {
		System.out.println("\n---Comienza la traza---");
		long resultado = factorialRecursivoTraza(n, 0);
		System.out.println("---Fin de la traza---\n");
		return resultado;
	}

	public static long factorialRecursivoTraza(int n, int espacios) {
		mostrarEspacios(espacios);
		System.out.println("Llamada a factorial(" + n + ")");
		if (n == 0) { // Caso base
			mostrarEspacios(espacios);
			System.out.println("Devuelve 1");
			return 1;
		} else {
			long f = factorialRecursivoTraza(n - 1, espacios + 2);
			mostrarEspacios(espacios);
			System.out.println("Devuelve " + f + " * " + n + " = " + (f *= n));
			return f;
		}
	}

	public static void mostrarEspacios(int espacios) {
		for (int i = 0; i < espacios; i++)
			System.out.print(" ");
	}

}
