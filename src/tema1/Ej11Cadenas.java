package tema1;

public class Ej11Cadenas {

	public static void main(String[] args) {
		String cadena1 = "Hola";
		String cadena2 = "Pepe";
		String cadena3 = cadena1;
		String saludo  = cadena1 + " " + cadena2 + "!";
		String trozo   = saludo.substring(0, 4);

		System.out.println("cadena1 es: " + cadena1);
		System.out.println("cadena2 es: " + cadena2);
		System.out.println("cadena3 es: " + cadena3);
		System.out.println("saludo  es: " + saludo);
		System.out.println("trozo   es: " + trozo);
		
		System.out.println("\nLongitud de saludo: " + saludo.length());
		System.out.println("cadena1 == trozo: " + (cadena1 == trozo));
		System.out.println("cadena1.equals(trozo): " + cadena1.equals(trozo));
		
		System.out.println("\ncadena1 == cadena3: " + (cadena1 == cadena3));
		System.out.println("cadena1.equals(cadena3): " + cadena1.equals(cadena3));
		
		System.out.println("\ncadena1.compareTo(trozo): " + cadena1.compareTo(trozo));
		System.out.println("cadena1.compareTo(cadena2): " + cadena1.compareTo(cadena2));
		
		System.out.println("\nLetra a letra:");
		for (int i = 0; i < saludo.length(); i++) {
			System.out.println(saludo.charAt(i));
		}
	}

}
