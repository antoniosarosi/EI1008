package tema1;

import java.util.Scanner;

public class Ej05EntradaDatos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Leer un número entero (de tipo int)
		System.out.print("Dame un número entero: ");
		int n1 = sc.nextInt();
		System.out.println("El número entero leído es: " + n1);

		// Leer un número real (de tipo double)
		System.out.print("\nDame un número real (usa coma para el separador decimal): ");
		double n2 = sc.nextDouble();
		System.out.println("El número real leído es: " + n2);
		
		sc.close();
	}

}
