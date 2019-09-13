package tests.practica3; // Indica aquí el nombre del paquete que utilizas

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import practica3.Diccionario;

public class TestDiccionario {

	Diccionario diccionario;
	Diccionario diccionarioNúmeros;
	String[] números;
	
	private void compruebaElementos(Diccionario diccionario, String[] cadenas, int[] cuentas, int hasta) {
		for (int i = 0 ; i <= hasta ; i++)
			assertEquals("No coincide la cuenta del elemento " + cadenas[i], cuentas[i], diccionario.cantidad(cadenas[i]));
	}
	
	@Before
	public void setUp() throws Exception {
		números = new String[] {"cero", "uno", "dos", "tres" };
		diccionario = new Diccionario();
		diccionarioNúmeros = new Diccionario();
		for (int i = 0 ; i < números.length ; i++)
			diccionarioNúmeros.añadir(números[i], i);
	}

	@Test
	public void testAñadir() {
		int[] esperado = new int[números.length];
		for (int i = 0 ; i < números.length ; i++) {
			diccionario.añadir(números[i], i);
			esperado[i] = i;
			compruebaElementos(diccionario, números, esperado, i);
		}
		for (int i = 0 ; i < números.length ; i++) {
			diccionario.añadir(números[i], i);
			esperado[i] += i;
			compruebaElementos(diccionario, números, esperado, números.length - 1);
		}
	}

	@Test
	public void testCadenaConMayorCantidad() {
		for (int i = 0 ; i < números.length ; i++) {
			diccionario.añadir(números[i], i);
			assertEquals("No encuentra bien la cadena con más cantidad en " + diccionario, números[i], diccionario.cadenaConMayorCantidad());
		}
	}

	@Test
	public void testCadenaConMayorCantidadEnVacíoDevuelveNull() {
		assertNull("En un diccionario vacío, el método cadenaConMayorCantidad debe devolver null", diccionario.cadenaConMayorCantidad());
	}
	
	@Test
	public void testCantidad() {
		for (int i = 0 ; i < números.length ; i++)
			assertEquals("No están bien las cuentas", i, diccionarioNúmeros.cantidad(números[i]));
	}

	@Test
	public void testCantidadNoEstá() {
		assertEquals("Si una cadena no está en el diccionario, debes devolver cero", 0, diccionarioNúmeros.cantidad("patata"));
	}
	
	@Test
	public void testToString() {
		String[] partes = new String[números.length];
		for (int i = 0 ; i < números.length ; i++)
			partes[i] = números[i] + "-->" + i; 
		Arrays.sort(partes);
		String resultado = Arrays.toString(partes);
		resultado = "{" + resultado.substring(1, resultado.length() - 1) + "}";
		assertEquals("Debes revisar el método toString", resultado, diccionarioNúmeros.toString());
	}

}
