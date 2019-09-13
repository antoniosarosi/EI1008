package tema3;

import java.util.Scanner;

public class Ej06ListaStringPruebas {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String palabra;
		int posición;
		int opción;

		ListaString lista = new ListaStringNodos();
		do {
			opción = menú(teclado);
			System.out.println();
			switch (opción) {
			case 1: // Mostrar la lista
				System.out.println("La lista es " + lista);
				break;

			case 2: // Consultar una posición
				System.out.print("Dime la posición que quieres consultar: ");
				posición = teclado.nextInt();
				try {
					String elemento = lista.consultar(posición);
					System.out.println("Elemento  de la posición " + posición
							+ " contiene " + elemento);
				} catch (Exception e) {
					System.out.println("La operación de consulta ha fallado");
				}
				break;

			case 3: // Insertar en una posición
				System.out.print("Dime la palabra que quieres insertar: ");
				palabra = teclado.next();
				System.out.print("Dime en qué posición: ");
				posición = teclado.nextInt();
				try {
					lista.insertar(posición, palabra);
					System.out.println("Palabra insertada");
				} catch (Exception e) {
					System.out.println("La inserción ha fallado");
				}
				break;

			case 4: // Borrar una posición
				if (lista.esVacía())
					System.out.println("No hay elementos que borrar.");
				else {
					System.out.print("Dime la posición que se debe borrar: ");
					posición = teclado.nextInt();
					try {
						lista.borrar(posición);
						System.out.println("Elemento borrado.");
					} catch (Exception e) {
						System.out.println("La operación de borrado ha fallado");
					}
				}
				break;

			case 5: // Borrar todos los elementos
				lista.borrar();
				System.out.println("Lista vacía");
				break;

			case 6: // Borrar primera ocurrencia
				if (lista.esVacía())
					System.out.println("No hay elementos que borrar.");
				else {
					System.out.print("Dime la palabra que quieres borrar: ");
					palabra = teclado.next();
					if (lista.borrarPrimera(palabra))
						System.out.println("Borrada la primera ocurrencia de "
								+ palabra);
					else
						System.out.println("No existe la palabra dada");
				}
				break;

			case 7: // Borrar todas las ocurrencias
				if (lista.esVacía())
					System.out.println("No hay elementos que borrar.");
				else {
					System.out.print("Dime la palabra que quieres borrar: ");
					palabra = teclado.next();
					if (lista.borrarTodas(palabra))
						System.out.println("Borradas todas las ocurrencias de "
								+ palabra);
					else
						System.out.println("No existe la palabra dada");
				}
				break;

			}

		} while (opción != 8);

		teclado.close();

	}

	private static int menú(Scanner entrada) {
		int opción;
		do {
			System.out.println("\n1) Mostrar la lista");
			System.out.println("2) Consultar una posición.");
			System.out.println("3) Insertar en una posición.");
			System.out.println("4) Borrar una posición.");
			System.out.println("5) Borrar todos los elementos.");
			System.out
					.println("6) Borrar la primera aparición de un elemento.");
			System.out
					.println("7) Borrar todas las apariciones de un elemento.");
			System.out.println("8) Salir.");

			System.out.print("\nDame una opción: ");
			opción = entrada.nextInt();
		} while (opción < 1 || opción > 8);
		return opción;
	}

}
