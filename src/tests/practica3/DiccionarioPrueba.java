package tests.practica3;

//
// Para que este programa de prueba funcione correctamente es importante que
// los métodos toString() de las clases Nodo y Diccionario
// usen el formato indicado en el enunciado, es decir:
// {} para una lista vacía y
// {cadena-->cantidad, cadena-->cantidad, ..., cadena-->cantidad} para una lista no vacía
//

import practica3.Diccionario;

public class DiccionarioPrueba {

    public static void main(String[] args) {
        Diccionario diccionario = new Diccionario();

        System.out.println("\nContenido del diccionario: " + diccionario);
        System.out.println("--> Probamos añadir(String) de cadenas que NO están presentes:");
        diccionario.añadir("Elena", 5);
        diccionario.añadir("Pablo", 3);
        diccionario.añadir("Noa", 3);
        comprueba(diccionario, "{Elena-->5, Noa-->3, Pablo-->3}");

        System.out.println("\nContenido del diccionario: " + diccionario);
        System.out.println("--> Probamos añadir(String) de cadenas que SI están presentes:");
        diccionario.añadir("Pablo", 7);
        diccionario.añadir("Elena", 1);
        comprueba(diccionario, "{Elena-->6, Noa-->3, Pablo-->10}");

        System.out.println("\nContenido del diccionario: " + diccionario);
        System.out.println("--> Probamos get(String):");
        System.out.println("La cantidad asociada a Pablo es " + diccionario.cantidad("Pablo"));
        System.out.println("La cantidad asociada a Elena es " + diccionario.cantidad("Elena"));
        System.out.println("La cantidad asociada a María es " + diccionario.cantidad("María"));

        System.out.println("\nContenido del diccionario: " + diccionario);
        System.out.println("--> Probamos cadenaConMayorCantidad():");
        System.out.println("La cadena con mayor cantidad es " + diccionario.cadenaConMayorCantidad());
    }


    public static void comprueba(Diccionario dic, String valorCorrecto) {
        if (!dic.toString().equals(valorCorrecto)) {
            System.out.println("*** Detectado error: Se esperaba " + valorCorrecto + " pero se ha obtenido " + dic);
        } else {
            System.out.println("    (ok)");
        }
    }

}
