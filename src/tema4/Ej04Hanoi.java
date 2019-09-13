package tema4;

import java.util.Scanner;

public class Ej04Hanoi {
	
	private static final int MAX_DISCOS = 10;

	public static void main(String[] args) {
		System.out.println("TORRES DE HANOI\n");
		
		// Pedir número de discos (entre 1 y MAX_DISCOS).
		Scanner consola = new Scanner(System.in);
		int numDiscos;
		do {
			System.out.println("Dame el número de discos (entre 1 y " + MAX_DISCOS + "): ");
			numDiscos = consola.nextInt();
		} while (numDiscos < 1 || numDiscos > MAX_DISCOS);
		
		System.out.println("\nSolución para " + numDiscos + " discos:");
		resuelveHanoi(numDiscos);
		consola.close();
	}

	public static void resuelveHanoi(int numDiscos) {
		resuelveHanoi(numDiscos, "izquierda", "derecha", "central");
	}

	private static void resuelveHanoi(int numDiscos, String inicio, String fin, String libre) {
		if (numDiscos == 1)
			System.out.println("Mover disco superior de la aguja " + inicio + " a la aguja " + fin);
		else {
			resuelveHanoi(numDiscos - 1, inicio, libre, fin);
			System.out.println("Mover disco superior de la aguja " + inicio + " a la aguja " + fin);
			resuelveHanoi(numDiscos - 1, libre, fin, inicio);
		}
	}
	
}
