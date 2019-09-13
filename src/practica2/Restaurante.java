package practica2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Restaurante {

    // Atributos
    private String nombre;
    private Punto posición;
    private int valoración;

    // Constructor
    public Restaurante(String nombre, Punto posición, int valoración) {
        this.nombre = nombre;
        this.posición = posición;
        this.valoración = valoración;
    }

    // Métodos
    public String getNombre() { return nombre; }
    public Punto getPosición() { return posición; }
    public int getValoración() { return valoración; }

    public double distancia(Punto p) { return posición.distancia(p); }


    public static Restaurante[] leeRestaurantes(String nombreFichero) throws FileNotFoundException {

        Scanner entrada = new Scanner(new File(nombreFichero));

        // tamaño del vector
        int tam = Integer.parseInt(entrada.nextLine());
        Restaurante[] vectorRestaurantes = new Restaurante[tam];

        // índice para aacceder al vector
        int i = 0;

        while (entrada.hasNextLine()) {
            String[] atributos = entrada.nextLine().split(" ");

            Restaurante restaurante = new Restaurante (
                    // Nombre
                    atributos[3],
                    // Posición
                    new Punto(Double.parseDouble(atributos[0]), Double.parseDouble(atributos[1])),
                    // Valoración
                    Integer.parseInt(atributos[2])
            );

            vectorRestaurantes[i] = restaurante;
            i++;
        }

        entrada.close();
        return vectorRestaurantes;
    }

}
