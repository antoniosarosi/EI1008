package tema4;

import java.util.Arrays;

public class Ej08OrdenarInsercion {

	public static void main(String[] args) {
		System.out.println("ORDENACIÓN POR INSERCIÓN");

		int[] vector = {  26, 2,  4,  3,  1 };
		System.out.println("\nvector inicial..: " + Arrays.toString(vector));

		// Aplicar el método de ordenación por inserción.
		ordenarInserciónTraza(vector);
		System.out.println("\nvector ordenado.: " + Arrays.toString(vector));
	}

	// Ordena el vector dado aplicando el algoritmo de ordenación por inserción.
	// Coste temporal: O(n^2)
	public static void ordenarInserción(int[] vector) {
		for (int i = 1; i < vector.length; i++) {
			int temp = vector[i];
			int j = i - 1;
			while (j >= 0 && temp < vector[j]) {
				vector[j + 1] = vector[j];
				j--;
			}
			vector[j + 1] = temp;
		}
	}

	public static void ordenarInserciónTraza(int[] vector) {
		for (int i = 1; i < vector.length; i++) {
		        System.out.printf("%nIteración %d", i);
		        System.out.printf("%n   Se van a ordenar los %d primeros elementos", i + 1);
		        System.out.printf("%n   Se guarda el elemento de la posición %d (%d)", i, vector[i]);
			int temp = vector[i];
			int j = i - 1;
			while (j >= 0 && temp < vector[j]) {
				vector[j + 1] = vector[j];
		                System.out.printf("%n   El elemento en la posición %d (%2d) se copia a la derecha: %s", j, vector[j], Arrays.toString(vector));
				j--;
			}
			vector[j + 1] = temp;
		        System.out.printf("%n   El elemento guardado (%d) se almacena en la posición %d: %s", temp, j+1, Arrays.toString(vector));
		        System.out.printf("%nTras iteración %d: %s", i, Arrays.toString(vector));
		        System.out.println();
		}
	}

}
