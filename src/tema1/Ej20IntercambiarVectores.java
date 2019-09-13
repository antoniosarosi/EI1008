package tema1;

import java.util.Arrays;

public class Ej20IntercambiarVectores {

	public static void main(String[] args) {
		int[] vector1 = new int[5];
		int[] vector2 = new int[5];
		for (int i = 0; i < vector1.length; i++) {
			vector1[i] = i * 2;
			vector2[i] = i * 2 + 1;
		}

		System.out.println("Contenido inicial de vector1: " + Arrays.toString(vector1));
		System.out.println("Contenido inicial de vector2: " + Arrays.toString(vector2));

        System.out.println("\nLlamada a intercambiarIncorrecto(vector1, vector2)\n");
        intercambiarIncorrecto(vector1, vector2);
        
		System.out.println("Contenido final de vector1: " + Arrays.toString(vector1));
		System.out.println("Contenido final de vector2: " + Arrays.toString(vector2));

        System.out.println("\nLlamada a intercambiar(vector1, vector2)\n");
        intercambiar(vector1, vector2);
        
		System.out.println("Nuevo contenido de vector1: " + Arrays.toString(vector1));
		System.out.println("Nuevo contenido de vector2: " + Arrays.toString(vector2));
	}

    // Intento erróneo de intercambiar el contenido de los vectores v1 y v2
    public static void intercambiarIncorrecto(int[] v1, int[] v2) {
        int[] aux = v1;
        v1 = v2;
        v2 = aux;
    }
    
	// Intercambia el contenido de los vectores v1 y v2
	// (solo en caso de que tengan la misma longitud).
	public static void intercambiar(int[] v1, int[] v2) {
		if (v1.length == v2.length) {
			for (int i = 0; i < v1.length; i++) {
				int aux = v1[i];
				v1[i] = v2[i];
				v2[i] = aux;
			}
		}
	}
}
