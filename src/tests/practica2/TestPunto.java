package tests.practica2; // Indica aquí el nombre del paquete que utilizas.

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import practica2.Punto;

public class TestPunto {

	private Punto punto12;
	
	@Before
	public void setUp() throws Exception {
		punto12 = new Punto(1, 2);
	}

	private void compruebaXY(double x, double y, Punto punto) {
		assertEquals("La x no está bien", x, punto.getX(), 1e-7);
		assertEquals("La y no está bien", y, punto.getY(), 1e-7);
	}
	
	@Test
	public void testPuntoDoubleDouble() {
		Punto punto = new Punto(1, 2);
		
		compruebaXY(1, 2, punto);
	}

	@Test
	public void testPunto() {
		Punto punto = new Punto();
		compruebaXY(0, 0, punto);
	}

	@Test
	public void testGetX() {
		for (double x : new double[] {1, 2, 4.3, -4}) {
			Punto punto = new Punto(x, 4);
			assertEquals("GetX no va bien", x, punto.getX(), 1e-7);
		}
	}

	@Test
	public void testGetY() {
		for (double y : new double[] {1, 2, 4.3, -4}) {
			Punto punto = new Punto(4, y);
			assertEquals("GetY no va bien", y, punto.getY(), 1e-7);
		}
	}

	@Test
	public void testDesplazar() {
		Punto punto = punto12.desplazar(3, 5);
		compruebaXY(1, 2, punto12);
		compruebaXY(4, 7, punto);
	}

	@Test
	public void testDistancia() {
		Punto[] puntos = {new Punto(1, 1), new Punto(2, 3), new Punto(2, 2) };
		double[] distancias = { 1, Math.sqrt(2), 1 }; 
		for (int i = 0 ; i < puntos.length ; i++ ) {
			Punto punto = puntos[i];
			double distancia = punto.distancia(punto12);
			assertEquals("Error al calcular la distancia de " + punto + " a " + punto12, distancias[i],
					distancia, 1e-7);
		}
	}

	@Test
	public void testToString() {
		assertEquals("Cambia tu implementación de toString para que use punto y dos decimales: return String.format(Locale.US, \"(%.2f, %.2f)\", x, y);", "(1.00, 2.00)", punto12.toString());
	}

	@Test
	public void testEqualsObject() {
		Punto punto = new Punto(1, 2);
		Punto otro = new Punto(2, 4);
		assertTrue("Deben ser iguales", punto.equals(punto12));
		assertFalse("Deben ser distintos", otro.equals(punto12));
	}

}
