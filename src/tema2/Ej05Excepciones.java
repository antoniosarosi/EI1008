package tema2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Ej05Excepciones {
	public static void main(String[] args) {
		System.out.println("Comienza el programa");
		try {
			// Escribe dos enteros en un fichero
			Formatter salida = new Formatter(new File("datos/misdatos.dat"));
			salida.format("%d%n", 10);
			salida.format("%d%n", 2); // Provoca errores cambiando el valor a cero o trece. Con siete termina.
			salida.close();

			// Lee dos enteros de un fichero
			Scanner entrada = new Scanner(new File("datos/misdatos.dat")); // Provoca errores cambiando el nombre del fichero por otro que no exista
			int num1 = entrada.nextInt();
			System.out.println("Se ha leído el número1: " + num1);
			int num2 = entrada.nextInt();
			System.out.println("Se ha leído el número2: " + num2);
			entrada.close();

			if (num1 == 7 || num2 == 7)
				return; // Aunque termina main, el bloque finally se ejecuta.
			
			if (num1 == 13 || num2 == 13)
				throw new Exception("Encontrado un número de la mala suerte");
			
			// Divide los dos enteros leídos
			int resultado;
			try {
				resultado = num1 / num2;
			} catch (ArithmeticException e) {
				resultado = -1;
				System.out.println("El divisor es cero. No se puede dividir ");
			}
			System.out.println("El resultado es: " + resultado);
		} 
		// Comprueba que, como máximo, se ejecuta un bloque catch
		catch (FileNotFoundException e) { // Comenta este bloque catch para comprobar que esta excepción deriva de IOException
			System.out.println("No se ha encontrado el fichero");
		}
		catch (IOException e) {
			System.out.println("Error genérico de entrada/salida");
		}
		catch (Exception e) { // Comenta los dos bloques catch anteriores para comprobar que todas las excepciones derivan de Exception
			System.out.println("Se ha producido la siguiente excepción: " + e.getMessage());
		}
		finally { // Comprueba que el bloque finally se ejecuta siempre (haya o no excepción)
			System.out.println("Se ejecuta el bloque finally");
		}
		System.out.println("Termina el programa");
	}

}
