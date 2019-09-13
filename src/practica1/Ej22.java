package practica1;

import java.util.Arrays;

public class Ej22 {

    private static int contarOlasFrío(double[] vector, int n) {
        int olas = 0, diasConsecutivos = 0;

        for (double temp : vector) {

            if (temp < 0)
                diasConsecutivos++;
            else
                diasConsecutivos = 0;

            if (diasConsecutivos == n + 1)
                olas++;
        }

        return olas;
    }


    private static int másOlasDeFrío(double[][] matriz, int n) {

        int maxOlas = 0, posicion = 0, olas;

        for (int i = 0; i < matriz.length; i++) {
            olas = contarOlasFrío(matriz[i], n);
            if (olas >= maxOlas) {
                maxOlas = olas;
                posicion = i;
            }
        }

        return posicion;
    }


    private static void prueba(double[][] matriz, int n, int esperado) {
        System.out.println("Prueba con la matriz: ");

        for (double[] fila : matriz)
            System.out.println("\t" + Arrays.toString(fila));

        System.out.println("Y numero " + n);

        System.out.println(másOlasDeFrío(matriz, n) == esperado ? "OK\n" : "ERROR\n");
    }


    public static void main(String[] args) {

        double[][] m1 = {
                {1, 2, 1, -3, -2, -5, -4, 0, 0},
                {1, 1, 3, 4, -3, -3, -3, 1, 1},
                {5, 5, 6, 3, 3, -1, -1, -1, -1}
        };

        double[][] m2 = {

                // Considerando n = 2

                {-1, -2, -3, 4, -5, -6, -7, 8, -9, -10, -11, 12, 13, 14, 15, 16},       // 3 olas de frío
                {-1, -2, -3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},             // 1 ola de frío
                {-1, -2, -3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, -14, -15, -16},          // 2 olas de frío
                {1, 2, 3, -4, -5, -6, 7, 8, -9, -10, -11, 12, 13, -14, -15, -16},       // 3 olas de frío
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},                // 0 olas de frío
                {1, 2, 3, 4, 5, 6, 7, 8, 9, -10, -11, -12, 13, -14, -15, -16},          // 2 olas de frío
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},                // 0 olas de frío
                {1, -2, -3, -4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},             // 1 ola de frío
                {-1, -2, -3, 4, -5, -6, -7, 8, -9, -10, -11, 12, -13, -14, -15, -16},   // 4 olas de frío
                {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10, 11, 12, 13, 14, 15, 16},      // 1 ola de frío
                {-1, -2, -3, 4, -5, -6, -7, 8, -9, -10, -11, 12, -13, -14, -15, 16},    // 4 olas de frío
                {1, 2, -3, -4, -5, 6, -7, -8, -9, 10, 11, 12, 13, -14, -15, -16}        // 3 olas de frío
        };

        prueba(m1, 3, 2);
        prueba(m2, 2, 10);  // másOlasDeFrío debería devolver 10 (la ultima posición con 4 olas de frío)
    }
}
