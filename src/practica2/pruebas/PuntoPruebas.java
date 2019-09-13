package practica2.pruebas;

import practica2.Punto;

public class PuntoPruebas {

	public static void main(String[] args) {

		System.out.println("Ejemplos de uso de puntos");
		Punto punto1 = new Punto();
		Punto punto2 = new Punto(1, 0);
		Punto punto3 = new Punto(1, 1);
		Punto punto4 = new Punto(0, 1);
		Punto punto5 = punto4;
		Punto punto6;

		System.out.println("La distancia de " + punto1 + " a " + punto3 + " es: " + punto1.distancia(punto3));
		System.out.println("La distancia de " + punto2 + " a " + punto4 + " es: " + punto2.distancia(punto4));
		System.out.println("El resultado de las distancias debería ser    : " + Math.sqrt(2));

		punto6 = punto5.desplazar(1, 0);

		System.out.print("Los puntos " + punto3 + " y " + punto6 + " son ");
		if (punto3.equals(punto6))
			System.out.println("iguales. (BIEN)");
		else
			System.out.println("diferentes. Repasa tu código.");

		System.out.print("Los puntos " + punto4 + " y " + punto5 + " son ");
		if (punto4.equals(punto5))
			System.out.println("iguales. (BIEN)");
		else
			System.out.println("diferentes. Repasa tu código.");

	}

}
