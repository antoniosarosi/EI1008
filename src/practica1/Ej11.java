package practica1;

public class Ej11 {

    private static boolean esSufijo(String s1, String s2) {

        // Consideramos cadena vacía como sufijo de cualquier cadena
        if (s2.length() == 0) return true;

        // Una cadena vacía solo tendrá como sufijo otra cadena vacía
        if (s1.length() == 0) return false;

        // Una cadena no puede ser sufijo de otra cadena de menor longitud
        if (s2.length() > s1.length()) return false;

        // Cuando las dos cadenas tienen caracteres recorremos las dos al revés y comprobamos si son iguales
        for (int i = s2.length() - 1, j = s1.length() - 1; i >= 0; i--, j--)
            if (s2.charAt(i) != s1.charAt(j))
                return false;

        return true;
    }


    private static void prueba(String s1, String s2, boolean esperado) {
        boolean resultado = esSufijo(s1, s2);
        System.out.format("Prueba con '%s' y '%s': ", s1, s2);
        System.out.println(resultado == esperado ? "OK" : "ERROR");
    }


    public static void main(String[] args) {

        // Casos comunes
        prueba("hola", "ola", true);
        prueba("hola", "a", true);
        prueba("hola", "hola", true);
        prueba("hola", "osa", false);

        // Cadenas vacías
        prueba("hola", "", true);
        prueba("", "hola", false);
        prueba("", "", true);

        // longitud de la segunda cadena mayor a la primera
        prueba("una cadena", "cadena", true);
        prueba("cadena", "una cadena", false);
    }
}
