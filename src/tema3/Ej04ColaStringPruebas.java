package tema3;

public class Ej04ColaStringPruebas {

	public static void main(String[] args) {

		String[] nombres = { "Toni", "Begoña", "José" };

		ColaString cola = new ColaStringNodos();

		for (int i = 0; i < nombres.length; i++)
			cola.insertar(nombres[i]);

		while (!cola.esVacía())
			System.out.println(cola.extraerPrimero());

	}

}
