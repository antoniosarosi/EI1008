package practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Ej24 {

    private static void escribirResultados(char[][] matriz, String[] partido, String[] equipos) {

        /* Recibe la matriz de resultados, un vector que representa una línea del fichero de partidos
        y que contiene el nombre y goles del equipo local y del visitiante, y el vector de los equipos.

        Comprueba si el partido dado ha ocurrido entre dos equipos del vector equipos, y si es así
        escribe en la matriz su resultado. */

        // Buscamos el equipo local
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i].equals(partido[0])) {

                // Una vez encontrado, buscamos el equipo visitante
                for (int j = 0; j < equipos.length; j++) {
                    if (equipos[j].equals(partido[2])) {

                        // Si lo encontramos, ecribimos el resultado del partido en la matriz
                        if (Integer.parseInt(partido[1]) > Integer.parseInt(partido[3]))
                            matriz[i][j] = '1';  // Gana el local

                        else if (Integer.parseInt(partido[1]) < Integer.parseInt(partido[3]))
                            matriz[i][j] = '2';  // Gana el visitante

                        else matriz[i][j] = 'X'; // Empate
                    }
                }
            }
        }
    }


    private static char[][] crearMatrizResultados(String[] equipos, String fichero) throws FileNotFoundException {

        char[][] matriz = new char[equipos.length][equipos.length];

        // Inicializamos la matriz por defecto con el caracter '-' (partido no jugado)
        for (char[] fila : matriz)
            for (int i = 0; i < fila.length; i++)
                fila[i] = '-';

        Scanner entrada = new Scanner(new File(fichero));

        /* Recorremos el fichero de texto línea a línea y si uno de los partidos ha ocurrido entre dos equipos del vector
        de equipos escribimos en la matriz su resultado con el método escribirResultados. */

        while (entrada.hasNextLine()) {
            String[] partido = entrada.nextLine().split(" ");
            escribirResultados(matriz, partido, equipos);
        }

        entrada.close();
        return matriz;
    }


    private static void prueba(String[] equipos, String fichero, char[][] esperado) throws FileNotFoundException {
        System.out.format("Prueba con %s y %s: ", Arrays.toString(equipos), fichero);
        char[][] resultado = crearMatrizResultados(equipos, fichero);
        System.out.println(Arrays.deepEquals(resultado, esperado) ? "OK" : "ERROR");
    }


    public static void main(String[] args) throws FileNotFoundException {

        String[] equipos = {"CDEF_Logroño", "Levante_UD_SAD", "Valencia_Féminas_CF"};
        String fichero = "ficheros/practica1/fichero.txt";

        char[][] resultadoEsperado = {
                {'-', '2', 'X'},
                {'-', '-', 'X'},
                {'1', '-', '-'}
        };

        prueba(equipos, fichero, resultadoEsperado);
    }
}
