package tema1;

import java.util.Scanner;

public class Ej08While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double suma = 0;
		int contador = 0;
		double máximo = 0;
		double mínimo = 10;
		int suspensos = 0;
		int aprobados = 0;
		int notables = 0;
		int sobresalientes = 0;

		System.out.print("Dame una nota (no válida para terminar): ");
		double nota = sc.nextDouble();
		while (nota >= 0 && nota <= 10) {
			contador++;
			suma += nota;
			if (nota > máximo)
				máximo = nota;
			if (nota < mínimo)
				mínimo = nota;
			if (nota >= 9)
				sobresalientes++;
			else if (nota >= 7)
				notables++;
			else if (nota >= 5)
				aprobados++;
			else
				suspensos++;
			System.out.print("Dame una nota (no válida para terminar): ");
			nota = sc.nextDouble();
		}
		if (contador > 0) {
			System.out.println("\nEstadísticas");
			System.out.println("Presentados: " + contador);
			System.out.println("Nota media: " + (double) suma / contador);
			System.out.println("Nota máxima: " + máximo);
			System.out.println("Nota mínima: " + mínimo);
			System.out.println("Porcentaje de sobresalientes: " + 100.0 * sobresalientes / contador);
			System.out.println("Porcentaje de notables: " + 100.0 * notables / contador);
			System.out.println("Porcentaje de aprobados: " + 100.0 * aprobados / contador);
			System.out.println("Porcentaje de suspensos: " + 100.0 * suspensos / contador);
		} else
			System.out.println("No hay datos");
		
		sc.close();
	}

}
