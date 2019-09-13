package tema1;

import java.util.Arrays;

public class Ej14PrimeraAparicionEnVector {

	// Devuelve la primera posición del vector que contiene el elemento dado
	// o un valor negativo si el elemento no está en el vector.
	public static int buscarPrimeraAparición(int[] vector, int elemento) {
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] == elemento)
				return i;
		}
		return -1; // No encontrado
	}

	public static void main(String[] args) {
		int[] vector = { 7, 3, 1, 1, 9, 9, 4, 7, 3, 8, 1, 2, 6 };
		
		System.out.println("vector: " + Arrays.toString(vector) + "\n");
		for (int valor = 0; valor < 10; valor++) {
			int posición = buscarPrimeraAparición(vector, valor);
			if (posición < 0) {
				System.out.println("El elemento " + valor + " no aparece en el vector");
			} else {
				System.out.println("El elemento " + valor + " aparece por primera vez en la posición " + posición);
			}
		}
	}

}
