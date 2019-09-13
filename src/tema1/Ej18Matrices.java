package tema1;

import java.util.Arrays;

public class Ej18Matrices {

	public static void main(String[] args) {
		int nFilas = 3;
		int nColumnas = 5;

		// Crear una matriz de dimensiones nFilas x nColumnas
		int[][] matriz = new int[nFilas][nColumnas];
		
		System.out.println("Creada matriz de " + matriz.length + " x " + matriz[0].length + " enteros");
		System.out.println("Contenido inicial (usando deepToString): "	+ Arrays.deepToString(matriz));

		System.out.println("\nContenido inicial (fila a fila):");
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(Arrays.toString(matriz[i]));
		}

		System.out.println("\nCambiamos los valores de la matriz");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = i + j;
			}
		}
		System.out.println("\nNuevo contenido (fila a fila):");
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(Arrays.toString(matriz[i]));
		}
	}

}
