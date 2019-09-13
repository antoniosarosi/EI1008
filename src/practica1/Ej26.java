package practica1;

import java.util.Arrays;

public class Ej26 {

    private static int obtenerPuntos(char[][] matriz, String[] vector, String nombre) {

        int posicionEquipo = 0;
        for (int i = 0; i < vector.length; i++)
            if (vector[i].equals(nombre))
                posicionEquipo = i;

        int puntosGanadasLocal = 0;
        int puntosGanadasVisitante = 0;

        for (char local : matriz[posicionEquipo]) {
            if (local == '1')
                puntosGanadasLocal += 3;
            else if (local == 'X')
                puntosGanadasLocal++;
        }

        for (int fila = 0; fila < matriz.length; fila++) {
            if (matriz[fila][posicionEquipo] == '2')
                puntosGanadasVisitante += 3;
            else if (matriz[fila][posicionEquipo] == 'X')
                puntosGanadasVisitante++;
        }

        return puntosGanadasLocal + puntosGanadasVisitante;
    }


    private static void prueba(char[][] matriz, String[] vector, String nombre, int esperado) {
        System.out.println("Prueba con la matriz: ");
        for (char[] fila : matriz)
            System.out.println("\t" + Arrays.toString(fila));
        System.out.println("y el equipo " + nombre);

        System.out.println(obtenerPuntos(matriz, vector, nombre) == esperado ? "OK\n" : "ERROR\n");
    }


    public static void main(String[] args) {

        String[] equipos = {"CDEF_Logroño", "Levante_UD_SAD", "Valencia_Féminas_CF"};

        char[][] m1 = {
                {'-', '2', 'X'},
                {'-', '-', 'X'},
                {'1', '-', '-'}
        };

        prueba(m1, equipos, "CDEF_Logroño", 1);
        prueba(m1, equipos, "Levante_UD_SAD", 4);
        prueba(m1, equipos, "Valencia_Féminas_CF", 5);
    }
}
