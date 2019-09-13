package tema3;

import java.util.EmptyStackException;

public class PilaStringVector implements PilaString {
	private static final int CAPACIDAD_INICIAL = 10;

	private String[] vector;
	private int posCima;

	public PilaStringVector() {
		vector = new String[CAPACIDAD_INICIAL];
		posCima = -1;
	}

	public void apilar(String elemento) {
		if (posCima == vector.length - 1) // Vector lleno
			redimensionar();
		vector[++posCima] = elemento;
	}

	private void redimensionar() {
		String[] nuevo = new String[2 * vector.length];
		for (int i = 0; i < vector.length; i++)
			nuevo[i] = vector[i];
		vector = nuevo;
	}

	public String desapilar() {
		if (esVacía())
			throw new EmptyStackException();
		String elemento = vector[posCima];
		vector[posCima] = null; // Eliminar referencia antigua
		posCima--;
		return elemento;
	}

	public String cima() {
		if (esVacía())
			throw new EmptyStackException();
		return vector[posCima];
	}

	public boolean esVacía() {
		return posCima < 0;
	}

}
