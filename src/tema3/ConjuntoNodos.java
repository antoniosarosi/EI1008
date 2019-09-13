package tema3;

public class ConjuntoNodos implements Conjunto {

	// Clase anidada
	// Nodo con enlace simple
	private static class Nodo {
		int dato;
		Nodo sig;

		Nodo(int dato, Nodo sig) {
			this.dato = dato;
			this.sig = sig;
		}
	}

	// Atributos
	private Nodo primero; // Enlace al primer elemento
	private int talla;    // Número de elementos

	// Constructor (por defecto)

	public boolean esVacío() {
		return talla == 0;
	}

	public int cardinalidad() {
		return talla;
	}

	// Añade, si no estaba, el elemento dado al conjunto.
	// Los elementos se mantienen ordenados de menor a mayor.
	public void insertar(int elemento) {
		Nodo atrás = null;
		Nodo actual;
		for (actual = primero; actual != null && actual.dato < elemento; actual = actual.sig)
			atrás = actual;
		if (actual == null || actual.dato != elemento) { // Elemento nuevo
			// Crear un nuevo nodo entre atrás y actual
			Nodo nuevo = new Nodo(elemento, actual);
			if (atrás != null)
				atrás.sig = nuevo;
			else
				primero = nuevo;
			talla++;
		}
	}

	// Devuelve true si el conjunto contiene el elemento dado.
	public boolean contiene(int elemento) {
		Nodo actual;
		for (actual = primero; actual != null && actual.dato < elemento; actual = actual.sig)
			;
		return actual != null && actual.dato == elemento;
	}

	// Borra el elemento dado.
	public void borrar(int elemento) {
		Nodo atrás = null;
		Nodo actual;
		for (actual = primero; actual != null && actual.dato < elemento; actual = actual.sig)
			atrás = actual;
		if (actual != null && actual.dato == elemento) {
			// Borrar el elemento
			if (atrás != null)
				atrás.sig = actual.sig;
			else
				primero = actual.sig;
			talla--;
		}
	}

	// Borra todos los elementos del conjunto
	public void borrar() {
		primero = null;
		talla = 0;
	}

	public String toString() {
		if (esVacío())
			return "{}";
		else {
			String resultado = "{" + primero.dato;
			for (Nodo aux = primero.sig; aux != null; aux = aux.sig)
				resultado += ", " + aux.dato;
			return resultado + "}";
		}
	}

	public boolean equals(Object otroObjeto) {
		if (this == otroObjeto)
			return true;
		if (!(otroObjeto instanceof ConjuntoNodos))
			return false;
		ConjuntoNodos otroConjunto = (ConjuntoNodos) otroObjeto;
		if (talla != otroConjunto.talla)
			return false;
		Nodo aux1 = primero;
		Nodo aux2 = otroConjunto.primero;
		while (aux1 != null && aux2 != null) {
			if (aux1.dato != aux2.dato)
				return false;
			else {
				aux1 = aux1.sig;
				aux2 = aux2.sig;
			}
		}
		return true;
	}

}
