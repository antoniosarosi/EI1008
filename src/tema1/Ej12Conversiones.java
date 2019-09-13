package tema1;

import java.util.Scanner;

public class Ej12Conversiones {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Conversión de String a int
		System.out.print("Dame un número entero: ");
		String s1 = sc.nextLine();
		int n1 = Integer.parseInt(s1);
		System.out.println("El número entero leído es: " + n1);

		// Conversión de String a double
		System.out.print("\nDame un número real (usa punto para el separador decimal): ");
		String s2 = sc.nextLine();
		double n2 = Double.parseDouble(s2);
		System.out.println("El número real leído es: " + n2);
		
		sc.close();
	}

}
