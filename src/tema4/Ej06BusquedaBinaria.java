package tema4;

import java.util.Arrays;
import java.util.Scanner;

public class Ej06BusquedaBinaria {

	public static void main(String[] args) {
		System.out.println("BÚSQUEDA BINARIA\n");

		int[] v = //{ 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987 };
				{1, 3, 7, 9, 12, 15, 20};
		System.out.println("Vector: " + Arrays.toString(v));

		Scanner consola = new Scanner(System.in);
		System.out.print("Dame el número que quieres buscar: ");
		int dato = consola.nextInt();

		int posición = búsquedaBinaria(v, dato);
		if (posición >= 0)
			System.out.println("\nEl valor " + dato + " está en la posición " + posición);
		else
			System.out.println("\nEl valor " + dato	+ " no está. Debería estar en la posición " + (-posición - 1));
		consola.close();
	}

	// Devuelve la posición de un elemento en un vector ordenado o un valor negativo si no está.
	// Coste temporal: O(log n), donde n es la longitud del vector.
	public static int búsquedaBinaria(int[] vector, int buscado) {
		int inicio = 0;
		int fin = vector.length - 1;
		while (inicio <= fin) {
			int medio = (inicio + fin) / 2;
			if (vector[medio] < buscado)
				inicio = medio + 1;
			else if (vector[medio] > buscado)
				fin = medio - 1;
			else
				// Encontrado.
				return medio;
		}
		// No está.
		return -inicio - 1;
	}

	public static int búsquedaBinariaTraza(int[] vector, int buscado) {
		int inicio = 0;
		int fin = vector.length - 1;
		System.out.format("%nBuscar el dato %d entre las posiciones %d y %d%n", buscado, inicio, fin);
		while (inicio <= fin) {
			int medio = (inicio + fin) / 2;
			System.out.format("Comparamos v[%d] con %d ", medio, buscado);
			if (vector[medio] < buscado) {
				System.out.format("(%d < %d) ---> Examinar mitad derecha%n", vector[medio], buscado);
				inicio = medio + 1;
			} else if (vector[medio] > buscado) {
				System.out.format("(%d > %d) ---> Examinar mitad izquierda%n", vector[medio], buscado);
				fin = medio - 1;
			} else { // Encontrado.
				System.out.format("(%d == %d) ---> Encontrado %n", vector[medio], buscado);
				return medio;
			}
			System.out.format("Buscar el dato %d entre las posiciones %d y %d%n", buscado, inicio, fin);
		}
		// No está.
		System.out.println("La búsqueda ha terminado");
		return -inicio - 1;
	}
}
