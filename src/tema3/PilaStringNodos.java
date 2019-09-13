package tema3;

import java.util.EmptyStackException;

public class PilaStringNodos implements PilaString {

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

	// Constructor (por defecto)

	public void apilar(String elemento) {
		primero = new Nodo(elemento, primero);
	}

	public String desapilar() {
		if (esVacía())
			throw new EmptyStackException();
		String elemento = primero.dato;
		primero = primero.sig;
		return elemento;
	}

	public String cima() {
		if (esVacía())
			throw new EmptyStackException();
		return primero.dato;
	}

	public boolean esVacía() {
		return primero == null;
	}

}
