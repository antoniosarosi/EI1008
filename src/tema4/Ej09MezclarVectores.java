package tema4;

import java.util.Arrays;

public class Ej09MezclarVectores {

	public static void main(String[] args) {
		System.out.println("MEZCLA DE VECTORES ORDENADOS\n");
		
		int[] v1 = { 12, 23, 36, 48, 49, 60, 70, 80 };
		int[] v2 = { 25, 37, 50, 60, 70 };

		System.out.println("v1: " + Arrays.toString(v1));
		System.out.println("v2: " + Arrays.toString(v2));

		int[] v3 = mezclarVectores(v1, v2);
		System.out.println("v3: " + Arrays.toString(v3));
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

	// Otra versión (más compacta)
	public static int[] mezclarVectoresVersión2(int[] v1, int[] v2) {
		int[] v3 = new int[v1.length + v2.length];

		int i1 = 0, i2 = 0, i3 = 0;
		// Repetir mientras queden datos en los dos vectores.
		while (i1 < v1.length && i2 < v2.length)
			v3[i3++] = (v1[i1] < v2[i2]) ? v1[i1++] : v2[i2++];

		// Copiar los elementos que queden en v1 o en v2
		while (i1 < v1.length)
			v3[i3++] = v1[i1++];
		while (i2 < v2.length)
			v3[i3++] = v2[i2++];

		return v3;
	}

	// Y otra más
	public static int[] mezclarVectoresVersión3(int[] v1, int[] v2) {
		int[] v3 = new int[v1.length + v2.length];

		int i1 = 0;
		int i2 = 0;
		for (int i3 = 0; i3 < v3.length; i3++) {
			if (i2 == v2.length || (i1 < v1.length && v1[i1] < v2[i2]))
				v3[i3] = v1[i1++];
			else
				v3[i3] = v2[i2++];
		}

		return v3;
	}

	public static int[] mezclarVectoresTraza(int[] v1, int[] v2) {
		int[] v3 = new int[v1.length + v2.length];

		int i1 = 0;
		int i2 = 0;
		int i3 = 0;

		System.out.println();
		// Repetir mientras queden datos en los dos vectores.
		while (i1 < v1.length && i2 < v2.length) {
			System.out.format("Se compara v1[%d] con v2[%d]%n", i1, i2, v1[i1], v2[i2]);
			if (v1[i1] < v2[i2]) {
				v3[i3] = v1[i1];
				System.out.format("   (%d <  %d) --> Se copia v1[%d] en v3[%d]: %s%n", v1[i1], v2[i2], i1, i3, Arrays.toString(v3));
				i1++;
			} else {
				v3[i3] = v2[i2];
				System.out.format("   (%d >= %d) --> Se copia v2[%d] en v3[%d]: %s%n", v1[i1], v2[i2], i2, i3, Arrays.toString(v3));
				i2++;
			}
			i3++;
		}
		System.out.println("Se ha terminado uno de los vectores");
		
		// Copiar los elementos que queden en v1 o en v2.
		while (i1 < v1.length) {
			v3[i3] = v1[i1];
			System.out.format("Se copia v1[%d] (%d) en v3[%d]: %s%n", i1, v1[i1], i3, Arrays.toString(v3));
			i1++;
			i3++;
		}
		while (i2 < v2.length) {
			v3[i3] = v2[i2];
			System.out.format("Se copia v2[%d] (%d) en v3[%d]: %s%n", i2, v2[i2], i3, Arrays.toString(v3));
			i2++;
			i3++;
		}
		System.out.println();
		
		return v3;
	}

}
