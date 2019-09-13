package tema1;

public class Ej10Cadenas {

	public static void main(String[] args) {
		String cadena1 = "Hola";
		String cadena2 = "Hola";
		String cadena3 = cadena2;
		String cadena4 = new String("Hola");
		String cadena5 = "Adiós";

		System.out.println("cadena1 es: " + cadena1);
		System.out.println("cadena2 es: " + cadena2);
		System.out.println("cadena3 es: " + cadena3);
		System.out.println("cadena4 es: " + cadena4);
		System.out.println("cadena5 es: " + cadena5);

		// Fíjate en que cadena1 y cadena2 se han creado a partir del mismo literal
		System.out.println("\ncadena1 == cadena2: " + (cadena1 == cadena2));
		
		System.out.println("cadena1 == cadena3: " + (cadena1 == cadena3));
		System.out.println("cadena1 == cadena4: " + (cadena1 == cadena4));
		System.out.println("cadena1 == cadena5: " + (cadena1 == cadena5));
	}

}
