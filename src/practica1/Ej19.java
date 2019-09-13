package practica1;

import java.util.Arrays;

public class Ej19 {

    private static int[] eliminarValor(int[] vector, int numero) {

        // Buscamos cuántas veces aparece el valor dado en el vector para determinar el length del nuevo vector
        int tamaño = vector.length;
        for (int elemento : vector)
            if (elemento == numero)
                tamaño--;

        /* Si el tamaño no ha cambiado signfica que el valor dado no está en el vector, con lo cual acabaremos
        devolviendo una copia del vector recibido */

        // Creamos el nuevo vector
        int[] nuevoVector = new int[tamaño];

        // Añadimos los elementos
        int i = 0;
        for (int elemento : vector)
            if (elemento != numero) {
                nuevoVector[i] = elemento;
                i++;
            }

        return nuevoVector;
    }


    private static void prueba(int[] vector, int valor, int[] esperado) {
        System.out.format("Prueba con %s y %d: ", Arrays.toString(vector), valor);
        int[] nuevoVector = eliminarValor(vector, valor);
        System.out.println(Arrays.equals(nuevoVector, esperado) ? "OK" : "ERROR");
    }


    public static void main(String[] args) {
        int[] v1 = {1, 2, 2, 3, 4, 5};  // Eliminamos el 2
        int[] e1 = {1, 3, 4, 5};

        int[] v2 = {1, 2, 3, 4};  // Eliminamos el 3
        int[] e2 = {1, 2, 4};

        int[] v3 = {4, 4, 4, 12, 2};  // Eliminamos el 4
        int[] e3 = {12, 2};

        int[] v4 = {1, 2, 3, 4, 5};  // Eliminamos un valor que no está en el vector
        int[] e4 = {1, 2, 3, 4, 5};

        prueba(v1, 2, e1);
        prueba(v2, 3, e2);
        prueba(v3, 4, e3);
        prueba(v4, 6, e4);
    }
}
