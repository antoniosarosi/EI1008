package tema1;

import java.util.Scanner;

public class Ej06Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cálculo de la longitud de una circunferencia, el área de un círculo o el volumen de una esfera");

		System.out.print("Dame el valor del radio:");
		double radio = sc.nextDouble();

		System.out.println("¿Qué quieres calcular?");
		System.out.println("1. Longitud de la circunferencia");
		System.out.println("2. Área del círculo");
		System.out.println("3. Volumen de la esfera");
		System.out.print("Selecciona una opción: ");
		int opción = sc.nextInt();

		switch (opción) {
		case 1: // Longitud
			double longitud = 2 * Math.PI * radio;
			System.out.println("La longitud de la circunferencia es: " + longitud);
			break;
		case 2: // Área
			double área = Math.PI * Math.pow(radio, 2);
			System.out.println("El área del círculo es: " + área);
			break;
		case 3: // Volumen
			double volumen = 4.0 / 3 * Math.PI * Math.pow(radio, 3);
			System.out.println("El volumen de la esfera es: " + volumen);
			break;
		default:
			System.out.println("Opción no válida");
		}
		
		sc.close();

	}

}
