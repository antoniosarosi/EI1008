package tests.practica3; // Indica aquí el nombre del paquete que utilizas

import static org.junit.Assert.*;

import java.util.Arrays;

import practica3.ListaCadenas;

import practica3.ListaCadenasEnlaceSimple;
import practica3.ListaCadenasEnlaceDoble;

import org.junit.Before;
import org.junit.Test;

public class TestListaCadenas {
	private ListaCadenas construyeListaCadenas() {
		return new ListaCadenasEnlaceSimple();
//		 return new ListaCadenasEnlaceDoble();
	}

	private ListaCadenas construyeListaPruebas() {
		ListaCadenas listaPruebas = construyeListaCadenas();
		for (int i = 0; i < listaNúmeros.size(); i++)
			listaPruebas.add(listaNúmeros.get(i));
		return listaPruebas;
	}

	private void compruebaElementos(ListaCadenas lista, String[] esperado, int hasta) {
		assertEquals("El tamaño de la lista no es el esperado", hasta + 1, lista.size());
		for (int i = 0 ; i <= hasta ; i++)
			assertEquals("No coincide el elemento de la posición " + i, esperado[i], lista.get(i));
	}
	
	private void compruebaElementos(ListaCadenas lista, String[] esperado) {
		compruebaElementos(lista, esperado, esperado.length - 1);
	}
	
	private String colaMensaje(ListaCadenas lista) {
		return " en la lista " + lista;
	}


	private ListaCadenas lista, listaNúmeros, listaPruebas;
	private String[] números;
	
	@Before
	public void setUp() throws Exception {
		números = new String[] {"uno", "dos", "tres", "cuatro" };
		lista = construyeListaCadenas();
		listaNúmeros = construyeListaCadenas();
		for (String número : números)
			listaNúmeros.add(número);
		listaPruebas = construyeListaPruebas();
	}

	@Test
	public void testAddString() {
		for (int i = 0 ; i < números.length ; i++) {
			assertTrue("add debe devolver cierto si funciona", lista.add(números[i]));
			compruebaElementos(lista, números, i);
		}
	}

	@Test
	public void testAddIntStringVacía() {
		lista.add(0, números[0]);
		compruebaElementos(lista, números, 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIntStringVacíaExcepción() {
		lista.add(1, números[0]);
	}

	@Test
	public void testAddIntStringPrimerElemento() {
		lista.add(números[1]);
		lista.add(0, números[0]);
		compruebaElementos(lista, números, 1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIntStringNoVacíaExcepción() {
		lista.add(números[0]);
		lista.add(2, números[0]);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIntStringÍndiceNegativo() {
		lista.add(-1, números[0]);
	}

	@Test
	public void testAddIntStringCentro() {
		lista.add(números[0]);
		lista.add(números[2]);
		lista.add(1, números[1]);
		compruebaElementos(lista, números, 2);
	}

	@Test
	public void testAddIntStringFinal() {
		lista.add(números[0]);
		lista.add(1, números[1]);
		lista.add(2, números[2]);
		compruebaElementos(lista, números, 2);
	}

	@Test
	public void testClear() {
		lista.add(números[0]);
		lista.add(números[1]);
		lista.clear();
		compruebaElementos(lista, números, -1);
	}

	@Test
	public void testGet() {
		for (int i = 0 ; i < números.length ; i++) {
			assertEquals("No se recupera bien la posición " + i + colaMensaje(listaNúmeros), números[i], listaNúmeros.get(i));
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetExcepción() {
		listaNúmeros.get(números.length);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetExcepciónÍndiceNegativo() {
		listaNúmeros.get(-1);
	}

	@Test
	public void testIndexOf() {
		for (String número : números)
			listaNúmeros.add(número);
		for (int i = 0 ; i < números.length ; i++)
			assertEquals("No se encuentra el primer índice de " + números[i] + colaMensaje(listaNúmeros), i,
					listaNúmeros.indexOf(números[i]));
	}

	@Test
	public void testIndexOfNoEstá() {
		assertEquals("No debería encontrar \"patata\"" +  colaMensaje(listaNúmeros), -1,
					listaNúmeros.indexOf("patata"));
	}

	
	@Test
	public void testLastIndexOf() {
		for (String número : números)
			listaNúmeros.add(número);
		int l = números.length;
		for (int i = 0 ; i < números.length ; i++)
			assertEquals("No se encuentra el último índice de " + números[i] + colaMensaje(listaNúmeros), i + l,
					listaNúmeros.lastIndexOf(números[i]));
	}

	@Test
	public void testIsEmpty() {
		assertTrue("isEmpty debe devoler cierto en la lista vacía", lista.isEmpty());
		assertFalse("isEmpty debe devoler falso" + colaMensaje(listaNúmeros), listaNúmeros.isEmpty());
	}

	@Test
	public void testRemoveInt() {
		for (int i = 0; i >= 0 ; i--) {
			listaNúmeros.remove(i);
			String[] esperado = Arrays.copyOfRange(números, i+1, números.length);
			compruebaElementos(listaNúmeros, esperado);
		}
	}

	@Test
	public void testRemoveAtrás() {
		for (int i = números.length - 1; i >= 0 ; i--) {
			listaNúmeros.remove(i);
			compruebaElementos(listaNúmeros, números, i - 1);
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveIntExcepción() {
		listaNúmeros.remove(listaNúmeros.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveIntExcepciónÍndiceNegativo() {
		listaNúmeros.remove(-1);
	}

	@Test
	public void testRemoveString() {
		for (int i = 0 ; i < números.length ; i++) {
			String mensaje = "remove debe devolver cierto al borrar " + números[i] + colaMensaje(listaNúmeros);
			assertTrue(mensaje, listaNúmeros.remove(números[i]));
			compruebaElementos(listaNúmeros, Arrays.copyOfRange(números, i+1, números.length));
		}
	}

	@Test
	public void testRemoveStringAtrás() {
		for (int i = números.length - 1 ; i >= 0 ; i--) {
			String mensaje = "remove debe devolver cierto al borrar " + números[i] + colaMensaje(listaNúmeros);
			assertTrue(mensaje, listaNúmeros.remove(números[i]));
			compruebaElementos(listaNúmeros, números, i-1);
		}
	}


	@Test
	public void testRemoveStringCentro() {
		for (int i = 1 ; i < números.length ; i++) {
			String mensaje = "remove debe devolver cierto al borrar " + números[i] + colaMensaje(listaNúmeros);
			assertTrue(mensaje, listaNúmeros.remove(números[i]));
			String[] esperado = Arrays.copyOfRange(números, i, números.length);
			esperado[0] = números[0];
			compruebaElementos(listaNúmeros, esperado);
		}
	}
	
	@Test
	public void testSet() {
		for (int i = 0 ; i < números.length ; i++) {
			listaNúmeros.set(i, "patata");
			números[i] = "patata";
			compruebaElementos(listaNúmeros, números);
		}
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetExcepción() {
		listaNúmeros.set(listaNúmeros.size(), "patata");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetExcepciónÍndiceNegativo() {
		listaNúmeros.set(-1, "patata");
	}
	
	@Test
	public void testSize() {
		assertEquals("La lista vacía debe tener talla cero", 0, lista.size());
		for (int i = 0 ; i < números.length ; i++) {
			lista.add(números[i]);
			assertEquals("Talla incorrecta" + colaMensaje(lista), i+1, lista.size());
		}
	}

	@Test
	public void testToString() {
		assertEquals("No está bien el toString de la lista vacía", "[]", lista.toString());
		for (int i = 0 ; i < números.length ; i++) {
			lista.add(números[i]);
			String esperado = Arrays.toString(Arrays.copyOf(números, i+1));
			assertEquals("No está bien el formato de toString", esperado, lista.toString());
		}
	}

	private void compruebaResultadosRemoveAll(String msg) {
		listaPruebas.removeAll("s");
		assertEquals("Fallo al borrar" + msg, listaNúmeros.toString(), listaPruebas.toString());
		compruebaElementos(listaPruebas, números);
	}

	@Test()
	public void testRemoveAllborrarHeads() {
		for (int i = 0; i < 3; i++)
			listaPruebas.add(0, "s");
		compruebaResultadosRemoveAll("heads");
	}

	@Test
	public void testRemoveAllUltimos() {
		for (int i = 0; i < 3; i++)
			listaPruebas.add(listaPruebas.size(), "s");
		compruebaResultadosRemoveAll("ultimos");
	}

	@Test
	public void testRemoveAllRandomPosiciones() {
		for (int i = 0, j = 1; i < 3; i++, j += 2)
			listaPruebas.add(j, "s");
		compruebaResultadosRemoveAll("randoms");
	}

	@Test
	public void testRemoveAllRandomPosicionesConHeadAndLast() {
		for (int i = 0, j = 1; i < 3; i++, j += 2)
			listaPruebas.add(j, "s");
		listaPruebas.add(0, "s");
		listaPruebas.add(listaPruebas.size(), "s");
		compruebaResultadosRemoveAll("randoms pero con head y last");
	}

	@Test
	public void testRemoveAllTodosLosCasosPosibles() {
		int i = 1, j = 1;
		while (i <= 3) {
			while (j < i * 4) {
				listaPruebas.add(j, "s");
				j++;
			}
			i++;
			j++;
		}
		for (int k = 0; k < 3; k++) {
			listaPruebas.add(0, "s");
			listaPruebas.add(listaPruebas.size(), "s");
		}
		compruebaResultadosRemoveAll("todo lo posible");
	}

	@Test
	public void removeAllBorrarTodo() {
		ListaCadenas list = construyeListaCadenas();
		ListaCadenas expected = construyeListaCadenas();
		for (int i = 0; i < 5; i++)
			list.add("s");
		list.removeAll("s");
		assertEquals("No funciona", expected.toString(), list.toString());
	}
}
