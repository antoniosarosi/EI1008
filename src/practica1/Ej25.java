package practica1;

import java.util.Arrays;

public class Ej25 {

    private static String másVictoriasFuera(char[][] matriz, String[] vector) {

        int maxVictorias = 0;
        String equipoConMasVic = vector[0];

        // Simplemente recorremos la matriz por columnas y contamos la cantidad de '2' que hay
        for (int col = 0; col < matriz[0].length; col++) {

            int victorias = 0;
            for (int fila = 0; fila < matriz.length; fila++)
                if (matriz[fila][col] == '2')
                    victorias++;

            if (victorias >= maxVictorias) {
                maxVictorias = victorias;
                equipoConMasVic = vector[col];
            }
        }

        return equipoConMasVic;
    }


    private static void prueba(char[][] matriz, String[] vector, String esperado) {
        System.out.println("Prueba con la matriz: ");
        for (char[] fila : matriz)
            System.out.println("\t" + Arrays.toString(fila));
        System.out.println("y el vector " + Arrays.toString(vector));

        System.out.println(másVictoriasFuera(matriz, vector).equals(esperado) ? "OK\n" : "ERROR\n");
    }


    public static void main(String[] args) {

        String[] equipos = {"CDEF_Logroño", "Levante_UD_SAD", "Valencia_Féminas_CF"};

        char[][] m1 = {
                {'-', '2', 'X'},
                {'-', '-', 'X'},
                {'1', '-', '-'}
        };

        char[][] m2 = {
                {'-', '2', '2'},
                {'-', '-', '2'},
                {'1', '-', '-'}
        };

        prueba(m1, equipos, "Levante_UD_SAD");
        prueba(m2, equipos, "Valencia_Féminas_CF");
    }
}
