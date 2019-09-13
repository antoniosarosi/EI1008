package tema1;

import java.util.Arrays;

public class Ej19MultiplicarVector {

	public static void main(String[] args) {
		int[] v1 = {1, 3, 5, 7, 9};
		int[] v2 = v1;

		System.out.println("Contenido inicial de v1: " + Arrays.toString(v1));
		System.out.println("Contenido inicial de v2: " + Arrays.toString(v2));

		System.out.println("\nSe ejecuta multiplicar(v1, 3);");
		multiplicar(v1, 3);

		System.out.println("\nNuevo contenido de v1: " + Arrays.toString(v1));
		System.out.println("Nuevo contenido de v2: " + Arrays.toString(v2));
	}

	// Multiplica los elementos del vector por el factor dado.
	public static void multiplicar(int[] vector, int factor) {
		for (int i = 0; i < vector.length; i++)
			vector[i] *= factor;
	}
	
}
