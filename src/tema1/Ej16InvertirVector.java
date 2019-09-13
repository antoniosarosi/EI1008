package tema1;

import java.util.Arrays;

public class Ej16InvertirVector {

	// Invierte el orden de los elementos del vector dado.
	public static void invertirVector(int[] vector) {
		int mitad = vector.length / 2;
		for (int i = 0; i < mitad; i++) {
			int aux = vector[i];
			vector[i] = vector[vector.length - 1 - i];
			vector[vector.length - 1 - i] = aux;
		}
	}

	public static void main(String[] args) {
		int[] vector = { 7, 3, 1, 1, 9, 9, 4, 7, 3, 8, 1, 2, 6 };
		System.out.println("vector original : " + Arrays.toString(vector));
		invertirVector(vector);
		System.out.println("vector invertido: " + Arrays.toString(vector));
	}
}
