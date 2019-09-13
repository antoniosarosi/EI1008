package tema1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Ej22FicherosDeTexto {
	/* 
	 * El fichero "datos/sucursal.txt" contiene datos de los clientes de una sucursal bancaria.
	 * El formato de cada línea es: dni saldo nombre
	 * Queremos crear un fichero llamado "datos/morosos.txt" que solo contenga
	 * la información de aquellos clientes cuyos saldos sean negativos.
	 */
	public static void main(String[] args)
			throws FileNotFoundException { // De momento, no capturamos la excepción.
		Scanner entrada = new Scanner(new File("datos/sucursal.txt"));
		Formatter salida = new Formatter(new File("datos/morosos.txt"));

		while (entrada.hasNext()) {
			String dni = entrada.next();
			double saldo = entrada.nextDouble(); 
			String nombre = entrada.nextLine(); 
			if (saldo < 0)
				salida.format("%s %10.2f %s%n", dni, saldo, nombre);
		}
		salida.close();
		entrada.close();
	}
}
