package tema3;

public class Ej05ColaDobleStringPruebas {

	public static void main(String[] args) {

		String[] nombres = { "Toni", "Begoña", "José" };

		ColaDobleString cola = new ColaDobleStringNodos();

		for (int i = 0; i < nombres.length; i++) {
			cola.insertarPrimero(nombres[i]);
			cola.insertarÚltimo(nombres[i]);
		}

		while (!cola.esVacía())
			System.out.println(cola.extraerPrimero());

	}

}
