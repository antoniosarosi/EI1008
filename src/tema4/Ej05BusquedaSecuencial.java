package tema4;

import java.util.Arrays;

public class Ej05BusquedaSecuencial {

	public static void main(String[] args) {
		System.out.println("BÚSQUEDA SECUENCIAL\n");

		int[] v1 = {29, 3, 19, 17, 11, 13, 7, 5, 23, 2};
		int[] v2 = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};
		int dato;
         //
		// Búsqueda secuencial en un vector.
		System.out.println("Vector v1: " + Arrays.toString(v1));
		dato = 7;
		int posición = búsquedaSecuencial(v1, dato);
		if (posición >= 0)
			System.out.println("El valor " + dato + " está en la posición " + posición);
		else		
			System.out.println("El valor " + dato + " no está");
		
		// Búsqueda secuencial en un vector ordenado.
		System.out.println("\nVector v2: " + Arrays.toString(v2));
		dato = 10;
		posición = búsquedaSecuencialMejorada(v2, dato);
		if (posición >= 0)
			System.out.println("El valor " + dato + " está en la posición " + posición);
		else		
			System.out.println("El valor " + dato + " no está");
	}

	// Devuelve la posición de un elemento en un vector o un valor negativo si no está.
	// Coste temporal: O(n), donde n es la longitud del vector.
	public static int búsquedaSecuencial(int[] vector, int buscado) {
		for (int i = 0; i < vector.length; i++)
			if (vector[i] == buscado)  // Encontrado.
				return i;
		// No está.
		return -1;
	}

	// Devuelve la posición de un elemento en un vector ordenado o un valor negativo si no está.
	// Coste temporal: O(n), donde n es la longitud del vector.
	public static int búsquedaSecuencialMejorada(int[] vector, int buscado) {
		for (int i = 0; i < vector.length; i++)
			if (vector[i] == buscado)  // Encontrado.
				return i;
			else if (vector[i] > buscado)  // Ya sabemos que no está.
				return -1;
		// No está.
		return -1;
	}

}
