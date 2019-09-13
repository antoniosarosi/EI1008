package tema4;

import java.util.Arrays;

public class Ej07OrdenarSeleccion {

	public static void main(String[] args) {
		System.out.println("ORDENACIÓN POR SELECCIÓN");

		int[] vector = {  2, 26,  4,  3,  1 };
		System.out.println("\nvector inicial..: " + Arrays.toString(vector));
		
		// Aplicar el método de ordenación por selección.
		ordenarSelección(vector);
		System.out.println("\nvector ordenado.: " + Arrays.toString(vector));
	}

	// Ordena el vector dado aplicando el algoritmo de ordenación por selección.
	// Coste temporal: O(n^2)
	public static void ordenarSelección(int[] vector) {
		for (int i = 0; i < vector.length - 1; i++) {
			// Buscar la posición del menor elemento desde la posición i hasta el final del vector.
			int posMenor = i;
			for (int j = i + 1; j < vector.length; j++)
				if (vector[j] < vector[posMenor])
					posMenor = j;
			
			// Intercambiar elementos en posiciones i y posMenor.
			int aux = vector[i];
			vector[i] = vector[posMenor];
			vector[posMenor] = aux;
		}
	}

	public static void ordenarSelecciónTraza(int[] vector) {
		for (int i = 0; i < vector.length - 1; i++) {
			System.out.printf("%nIteración %d", i);
			System.out.printf("%n   Se selecciona el elemento para la posición %d", i);

			System.out.printf("%n   Buscando el menor elemento entre las posiciones %d y %d ", i, vector.length - 1);
			int posMenor = i;
			for (int j = i + 1; j < vector.length; j++)
				if (vector[j] < vector[posMenor])
					posMenor = j;
			System.out.printf("--> El menor está en la posición %d", posMenor);
			
			// Intercambiar elementos en posiciones i y posMenor.
			System.out.printf("%n   Se intercambian los elementos en las posiciones %d y %d (%d <--> %d)", i, posMenor, vector[i], vector[posMenor]);
			int aux = vector[i];
			vector[i] = vector[posMenor];
			vector[posMenor] = aux;
			System.out.printf("%nTras iteración %d: %s%n", i, Arrays.toString(vector));
		}
	}

}
