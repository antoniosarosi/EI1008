package tema1;

import java.util.Arrays;

public class Ej13Vectores {

	public static void main(String[] args) {
		int[] vector = new int[10];
		System.out.println("vector inicial (tras crearlo): " + Arrays.toString(vector));

		// Rellenar vector
		for (int i = 0; i < vector.length; i++) {
			vector[i] = i;
		}
		System.out.println("vector tras asignarle valores: " + Arrays.toString(vector));

		// Crear una copia del vector
		int[] aux = new int[vector.length];
		for (int i = 0; i < vector.length; i++) {
			aux[i] = vector[i];
		}
		System.out.println("vector aux (es una copia)    : " + Arrays.toString(aux));
		
		System.out.println("\n¿Son iguales las referencias de vector y aux? " + (vector == aux)); 
		System.out.println("¿Son iguales los contenidos de vector y aux? " + Arrays.equals(vector, aux)); 

		vector = aux;
		System.out.println("\nTras asignar un vector a otro (vector = aux;)");
		System.out.println("¿Son iguales las referencias de vector y aux? " + (vector == aux)); 
		System.out.println("¿Son iguales los contenidos de vector y aux? " + Arrays.equals(vector, aux)); 

		vector[vector.length - 1] = -1;
		System.out.println("\nTras asignar -1 al último elemento de vector: ");
		System.out.println("vector: " + Arrays.toString(vector));
		System.out.println("aux   : " + Arrays.toString(vector));

		aux = null;
		System.out.println("\nTras asignar null a aux:");
		System.out.println("¿Son iguales las referencias de vector y aux? " + (vector == aux));
		System.out.println("¿Son iguales los contenidos de vector y aux? " + Arrays.equals(vector, aux));
	}

}
