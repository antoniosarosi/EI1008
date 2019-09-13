package practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GanadorLiga {

    public static void main(String[] args) throws FileNotFoundException {
        String fichero = "ficheros/practica3/liga2017-2018.txt";
        Scanner sc = new Scanner(new File(fichero));

        Diccionario liga = new Diccionario();
        while (sc.hasNextLine()) {
            String[] equipos = sc.nextLine().split(" ");

            if (Integer.parseInt(equipos[1]) > Integer.parseInt(equipos[3]))
                liga.añadir(equipos[0], 3);
            else if (Integer.parseInt(equipos[1]) == Integer.parseInt(equipos[3])) {
                liga.añadir(equipos[0], 1);
                liga.añadir(equipos[2], 1);
            }
            else {
                liga.añadir(equipos[2], 3);
            }
        }
        sc.close();

        String equipo = liga.cadenaConMayorCantidad();
        int puntos = liga.cantidad(equipo);
        System.out.format("Ganador liga 2017-2018: <<%s>> con %d puntos.", equipo, puntos);
    }
}
