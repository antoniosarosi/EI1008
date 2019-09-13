package tema3;

import java.util.NoSuchElementException;

public class ColaStringNodos implements ColaString {

	// Clase anidada
	// Nodo con enlace simple
	private static class Nodo {
		String dato;
		Nodo sig;

		Nodo(String dato, Nodo sig) {
			this.dato = dato;
			this.sig = sig;
		}
	}

	private Nodo primero;
	private Nodo último;

	// Constructor (por defecto)

	public void insertar(String elemento) {
		Nodo nuevo = new Nodo(elemento, null);
		if (esVacía()) {
			primero = nuevo;
			último = nuevo;
		} else {
			último.sig = nuevo;
			último = nuevo;
		}
	}

	public String extraerPrimero() {
		if (esVacía())
			throw new NoSuchElementException();
		String elemento = primero.dato;
		primero = primero.sig;
		if (primero == null)
			último = null;
		return elemento;
	}

	public String consultarPrimero() {
		if (esVacía())
			throw new NoSuchElementException();
		return primero.dato;
	}

	public boolean esVacía() {
		return primero == null;
	}

}
