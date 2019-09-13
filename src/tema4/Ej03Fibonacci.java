package tema4;

import java.util.Scanner;

public class Ej03Fibonacci {

	public static void main(String[] args) {
		System.out.println("NÚMEROS DE FIBONACCI\n");
		
		Scanner consola = new Scanner(System.in);
		int n;
		do {
			System.out.print("Dame un número positivo: ");
			n = consola.nextInt();
		} while (n <= 0);	
		
		System.out.println("Fibonacci(" + n + ") = " + fibonacciIterativo(n) + " (versión iterativa)");
		long fibonacci = fibonacciRecursivoTraza(n);
		System.out.println("Fibonacci(" + n + ") = " + fibonacci + " (versión recursiva)");
		consola.close();
	}
	
	// Devuelve el n-ésimo número de Fibonacci (n > 0)
	// Coste temporal: O(2^n)
	// Coste espacial: O(n)
	public static long fibonacciRecursivo(int n) {
		if (n == 1 || n == 2) {  // Casos base
			return 1;
		} else {
			return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
		}
	}

	// Devuelve el n-ésimo número de Fibonacci (n > 0)
	// Coste temporal: O(n)
	// Coste espacial: O(1)
	public static long fibonacciIterativo(int n) {
		long penúltimo = 1;
		long último = 1;
		long aux = 1;
		for (int i = 2; i < n; i++) {
			aux = penúltimo + último;
			penúltimo = último;
			último = aux;
		}
		return último;
	}

	public static long fibonacciRecursivoTraza(int n) {
		System.out.println("\n--- Comienza la traza ---");
		long fibonacci = fibonacciRecursivoTraza(n, 0);
		System.out.println("--- Fin de la traza ---\n");
		return fibonacci;
	}
	
	public static long fibonacciRecursivoTraza(int n, int espacios) {
		mostrarEspacios(espacios);
		System.out.println("Llamada a fibonacci(" + n + ")");
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fibonacciRecursivoTraza(n - 1, espacios + 2) + fibonacciRecursivoTraza(n - 2, espacios + 2);
		}
	}

	public static void mostrarEspacios(int espacios) {
		for (int i = 0; i < espacios; i++)
			System.out.print(" ");
	}

}
