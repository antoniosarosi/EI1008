package tema3;

import java.util.LinkedList;
import java.util.List;

public class Ej01ListasJava {

	public static void main(String[] args) {
		// Crear la lista
		List<Integer> lista = new LinkedList<Integer>(); // Probar también con LinkedList
		System.out.println("Lista creada!");

		// Añadir al final (add)
		System.out.println("Añadiendo al final el 15");
		lista.add(15);
		System.out.println("Añadiendo al final el 10");
		lista.add(10);
		System.out.println("Añadiendo al final el 20");
		lista.add(20);
		System.out.println(lista);

		// Añadir en una posición (add)
		System.out.println("Añadiendo en la posición 2 el 12");
		lista.add(2, 12); // Probar add(20, 12)
		System.out.println(lista);

		// Averiguar la posición de un elemento (indexOf)
		for (int i = 10; i <= 15; i++)
			System.out.println(String.format(
					"El dato %d se encuentra en la posición %d", i,	lista.indexOf(i)));

		// Consultar el valor de una posición (get)
		int dato1 = lista.get(1);
		int dato2 = lista.get(2);
		System.out.println(String.format(
				"Los datos es las posiciones 1 y 2 son %d y %d", dato1, dato2));

		// Eliminar el elemento en una posición (remove)
		System.out.println("Borrando el elemento en la posición 1");
		lista.remove(1);
		System.out.println(lista);

		// Eliminar un elemento dado (remove) Observa que debe ser un objeto
		System.out.println("Borrando el valor 12");
		lista.remove((Integer) 12);
		System.out.println(lista);

		// Borrar la lista entera (deleteIndex)
		System.out.println("Borrando toda la lista");
		lista.clear();
		System.out.println(lista);
	}

}
