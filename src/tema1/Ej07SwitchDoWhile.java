package tema1;

import java.util.Scanner;

public class Ej07SwitchDoWhile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean seguir = true;
		do {
			System.out.print("Dame un número de mes (0 para terminar):");
			int mes = sc.nextInt();

			switch (mes) {
			case 0:
				seguir = false;
				break;
			case 1: // Enero
			case 3: // Marzo
			case 5: // Mayo
			case 7: // Julio
			case 8: // Agosto
			case 10: // Octubre
			case 12: // Diciembre
				System.out.println("El mes " + mes + " tiene 31 días");
				break;
			case 4: // Abril
			case 6: // Junio
			case 9: // Septiembre
			case 11: // Noviembre
				System.out.println("El mes " + mes + " tiene 30 días");
				break;
			case 2: // Febrero
				System.out.println("El mes " + mes + " puede tener 28 o 29 días");
				break;
			default:
				System.out.println("El mes " + mes + " no es válido");
			}
		} while (seguir);
		
		sc.close();
	}

}
