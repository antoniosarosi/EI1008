package tema1;

import java.util.Arrays;

public class Ej15VectorOrdenado {

	// Devuelve true si el vector está ordenado de menor a mayor y false si no lo está. 
	public static boolean estáOrdenado(int[] vector) {
		for (int i = 0; i < vector.length - 1; i++)
			if (vector[i] > vector[i + 1])
				return false;
		return true;
	}

	public static void main(String[] args) {
		int[] vector1 = { 1, 1, 9, 9, 4, 7, 7, 3, 3, 8, 1, 2, 6 };
		int[] vector2 = { 1, 1, 1, 2, 3, 3, 4, 6, 7, 7, 8, 9, 9 };
		System.out.println("vector1: " + Arrays.toString(vector1));
		System.out.println("vector2: " + Arrays.toString(vector2));
		System.out.println("\n¿Está ordenado el vector1?: " + estáOrdenado(vector1));
		System.out.println("¿Está ordenado el vector2?: " + estáOrdenado(vector2));
	}

}
