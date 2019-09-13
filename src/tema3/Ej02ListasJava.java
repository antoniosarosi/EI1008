package tema3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ej02ListasJava {

	public static void main(String[] args) {
		List<Integer> lista = new LinkedList<>(); // Probar también ArrayList

		long cantidad = 40000;
		for (int i = 1; i <= cantidad; i++) {
			lista.add(i);
		}

		System.out.println("Recorriendo posiciones");
		long inicio = System.nanoTime();
		long suma = 0;
		for (int i = 0; i < lista.size(); i++) {
			int dato = lista.get(i);
			suma += dato;
		}
		long fin = System.nanoTime();
		double t = (double) (fin - inicio) / 1000000000;
		System.out.println("La suma vale: " + suma);
		System.out.println("Tiempo empleado (s): " + t);

		System.out.println("Recorriendo elementos");
		inicio = System.nanoTime();
		suma = 0;
		for (int dato : lista)
			suma += dato;
		fin = System.nanoTime();
		t = (double) (fin - inicio) / 1000000000;
		System.out.println("La suma vale: " + suma);
		System.out.println("Tiempo empleado (s): " + t);
	}

}
