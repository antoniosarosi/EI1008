package practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalabraMasFrecuente {

    public static void main(String[] args) throws FileNotFoundException {
        String fichero = "ficheros/practica3/DonQuijote.txt";
        Scanner sc = new Scanner(new File(fichero));

        Diccionario palabras = new Diccionario();
        while (sc.hasNext())
            palabras.añadir(sc.next(), 1);

        sc.close();
        String palabra = palabras.cadenaConMayorCantidad();
        int cantidad = palabras.cantidad(palabra);
        System.out.format("La palabra más frecuente en %s es <<%s>> con %d apariciones.",
                fichero, palabra, cantidad);
    }
}
