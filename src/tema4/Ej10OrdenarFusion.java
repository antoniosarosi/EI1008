package tema4;

import java.util.Arrays;

public class Ej10OrdenarFusion {

	public static void main(String[] args) {
		int[] vector = {11, 21, 3, 1, 98, 0, 12, 82, 29, 30, 11, 18, 43, 4, 75, 37, 12, 3, 21, 29};
		
		System.out.println("vector inicial: " + Arrays.toString(vector));
		ordenarFusión(vector);
		System.out.println("vector ordenado: " + Arrays.toString(vector));
	}

	// Ordena el vector dado aplicando el algoritmo de ordenación por fusión o mezcla (mergesort).
	// Coste temporal: O(n x log n)
	public static void ordenarFusión(int[] vector) {
		if (vector.length > 1) {

			// Dividir el vector en dos mitades
			int medio = vector.length / 2;
			int[] mitad1 = Arrays.copyOfRange(vector, 0, medio);
			int[] mitad2 = Arrays.copyOfRange(vector, medio, vector.length);

			// Ordenar cada mitad por separado
			ordenarFusión(mitad1);
			ordenarFusión(mitad2);

			// Mezclar las mitades ordenadas
			int[] mezcla = mezclarVectores(mitad1, mitad2);
			for (int i = 0; i < vector.length; i++)
				vector[i] = mezcla[i];
		}
	}
	
	// Devuelve el vector ordenado resultante de mezclar dos vectores ordenados.
	// Coste temporal: O(n)
	public static int[] mezclarVectores(int[] v1, int[] v2) {
		int[] v3 = new int[v1.length + v2.length];

		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		// Repetir mientras queden datos en los dos vectores.
		while (i1 < v1.length && i2 < v2.length) {
			if (v1[i1] < v2[i2]) {
				v3[i3] = v1[i1];
				i1++;
			} else {
				v3[i3] = v2[i2];
				i2++;
			}
			i3++;
		}

		// Copiar los elementos que queden en v1 o en v2.
		while (i1 < v1.length) {
			v3[i3] = v1[i1];
			i1++;
			i3++;
		}
		while (i2 < v2.length) {
			v3[i3] = v2[i2];
			i2++;
			i3++;
		}

		return v3;
	}

}
