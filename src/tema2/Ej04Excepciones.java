package tema2;

import java.util.Scanner;

public class Ej04Excepciones {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int resultado = 0;
		boolean hayError;
		do {
			hayError = false;
			try {
				System.out.print("Dime n1:");
				int n1 = entrada.nextInt();
				System.out.print("Dime n2:");
				int n2 = entrada.nextInt();
				resultado = calculaAlgo(n1, n2);
			} catch (ExcepcionNumerosIguales e) {
				System.out.println("ERROR: Los números no pueden ser iguales");
				hayError = true;
			} catch (ArithmeticException e) {
				System.out.println("ERROR: " + e.getMessage());
				hayError = true;
			}
		} while (hayError);
		System.out.println("El resultado es: " + resultado);
		entrada.close();
	}

	public static int calculaAlgo(int a, int b) throws ExcepcionNumerosIguales {
		if (a == b)
			throw new ExcepcionNumerosIguales();
		return 100 / (a - b) + a / b;
	}
}
