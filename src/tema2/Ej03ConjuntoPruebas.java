package tema2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ej03ConjuntoPruebas {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("COMIENZA");
		long inicio = System.currentTimeMillis();
		String nombreFich = "datos/DonQuijote.txt";
		Scanner fich = new Scanner(new File(nombreFich));
		int contador = 0;
		Conjunto palabras = new Conjunto();
		while (fich.hasNext()) {
			String palabra = fich.next();
			contador++;
			palabras.insertar(palabra);
		}
		fich.close();
		long fin = System.currentTimeMillis();
		System.out.println("El fichero " + nombreFich + " contiene " + contador + " palabras de las cuales hay " + palabras.longitud() + " distintas.");
		System.out.println("Tiempo empleado: " + (fin - inicio) + " ms.");
	}

}
