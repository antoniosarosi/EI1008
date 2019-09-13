package tema1;

import java.util.Arrays;

public class Ej17ConcatenarVectores {

	// Devuelve un nuevo vector que contiene los elementos de v1 seguidos de los de v2.
	public static int[] concatenar(int[] v1, int v2[]) {
		int[] resultado = new int[v1.length + v2.length];
		for (int i = 0; i < v1.length; i++)
			resultado[i] = v1[i];
		for (int i = 0; i < v2.length; i++)
			resultado[v1.length + i] = v2[i];
		return resultado;
	}

	public static void main(String[] args) {
		int[] vector1 = { 1, 3, 2, 6 };
		int[] vector2 = { 2, 4, 4, 7, 8, 9 };
		System.out.println("vector1     : " + Arrays.toString(vector1));
		System.out.println("vector2     : " + Arrays.toString(vector2));
		System.out.println("concatenados: "	+ Arrays.toString(concatenar(vector1, vector2)));
	}

}
