package tests.practica2; // Indica aquí el nombre del paquete que utilizas.

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import practica2.ExcepcionFechaInvalida;
import practica2.Fecha;

public class TestFecha {
	
	private static class P {
		Fecha fecha1, fecha2;
		P(Fecha fecha1, Fecha fecha2) {
			this.fecha1 = fecha1;
			this.fecha2 = fecha2;
		}
	}
	
	
	private Fecha hombreEnLaLuna;
	private Fecha dosDeMayo;
	private P[] paresOrdenados;
	
	@Before
	public void setUp() throws Exception {
		hombreEnLaLuna = new Fecha(20, 7, 1969);
		dosDeMayo = new Fecha(2,5,1808);
		paresOrdenados = new P[] {
			new P(dosDeMayo, hombreEnLaLuna),
			new P(new Fecha(1, 5, 1808), dosDeMayo),
			new P(new Fecha(2, 4, 1808), dosDeMayo),
			new P(new Fecha(2, 5, 1807), dosDeMayo),
			new P(new Fecha(3, 5, 1807), dosDeMayo),
			new P(new Fecha(2, 6, 1807), dosDeMayo),
		};
	}
	
	@Test
	public void testFechaFecha() throws ExcepcionFechaInvalida {
		Fecha fecha = new Fecha(hombreEnLaLuna);
		
		assertFechaEs("constructor desde fecha", fecha, hombreEnLaLuna);
	}

	@Test
	public void testFormatoCadena() {
		assertEquals("Formato de toString incorrecto", "20/7/1969", hombreEnLaLuna.toString() );
	}

	@Test
	public void testFormatoCadenaDíaPequeño() {
		assertEquals("Formato de toString incorrecto", "2/5/1808", dosDeMayo.toString() );
	}
	
	@Test
	public void testEqualsDevuelveFalseSiDistintos() {
		assertFalse("Equals falla con fechas distintas", hombreEnLaLuna.equals(dosDeMayo));
	}
	
	@Test
	public void testEqualsDevuelveTrueSiIguales() throws ExcepcionFechaInvalida {
		Fecha copia = new Fecha(dosDeMayo);
		assertTrue("Equals falla con fechas iguales", dosDeMayo.equals(copia));
	}

	@Test
	public void testCompareToDevuelveNegativo() {
		for (P par : paresOrdenados)
			assertTrue("CompareTo falla cuando compara " + par.fecha1 + " y " + par.fecha2, par.fecha1.compareTo(par.fecha2) < 0);
	}
	
	@Test
	public void testCompareToDevuelveCero() {
		assertTrue("CompareTo falla cuando debe devolver cero", dosDeMayo.compareTo(dosDeMayo) == 0);
	}

	@Test
	public void testCompareToDevuelvePositivo() {
		for (P par : paresOrdenados)
			assertTrue("CompareTo falla cuando compara " + par.fecha2 + " y " + par.fecha1, par.fecha2.compareTo(par.fecha1) > 0);
	}
	
	@Test
	public void testAñoBisiesto() {
		for (int año : new int [] {1900, 1902, 1905, 2100, 2114})
			assertFalse("El año " + año + " no es bisiesto y tú método dice que sí", Fecha.añoBisiesto(año));
		for (int año : new int [] {1904, 1912, 2000, 2016, 2104})
			assertTrue("El año " + año + " es bisiesto y tú método dice que no", Fecha.añoBisiesto(año));
	}
	
	@Test
	public void testDiasMes() throws ExcepcionFechaInvalida {
		for (int mes : new int[] {1, 3, 5, 7, 8, 10, 12})
			assertEquals("El mes " + mes + " tiene 31 días", 31, Fecha.díasMes(mes, 1969));
		for (int mes : new int[] {4, 6, 9, 11})
			assertEquals("El mes " + mes + " tiene 30 días", 30, Fecha.díasMes(mes, 1969));
		for (int año : new int [] {1900, 1902, 1905, 2100, 2114})
			assertEquals("Febrero en  " + año + " tiene 28 días", 28, Fecha.díasMes(2, año));
		for (int año : new int [] {1904, 1912, 2000, 2016, 2104})
			assertEquals("Febrero en  " + año + " tiene 29 días", 29, Fecha.díasMes(2, año));
	}
	
	@Test
	public void testHoy() throws ExcepcionFechaInvalida {
		Calendar calendario = Calendar.getInstance();
		assertFechaEs("del método hoy", Fecha.hoy(),
				calendario.get(Calendar.DAY_OF_MONTH),
				calendario.get(Calendar.MONTH) + 1,
				calendario.get(Calendar.YEAR)
				);
	}
	
	@Test
	public void testDíaSiguiente() throws ExcepcionFechaInvalida {
		testDíaSiguienteAño(1901);
		testDíaSiguienteAño(2000);
	}
	
	private void testDíaSiguienteAño(int año) throws ExcepcionFechaInvalida {
		for (int mes = 1 ; mes <= 12 ; mes++ ) {
			int ndías = Fecha.díasMes(mes, año);	
			for (int día = 1 ; día <= ndías ; día++) {
				Fecha fecha = new Fecha(día, mes, año);
				Fecha fecha2 = new Fecha(fecha);
				Fecha siguiente = fecha.díaSiguiente();
				assertEquals("El método díaSiguiente no debe modificar la fecha original", fecha2, fecha);
				if (día < ndías) {
					assertEquals("Mal día devuelto como siguiente de " + fecha, día + 1, siguiente.getDía());
					assertEquals("Mal mes devuelto como siguiente de " + fecha, mes, siguiente.getMes());
					assertEquals("Mal año devuelto como siguiente de " + fecha, año, siguiente.getAño());
				} else if (mes < 12) {
					assertEquals("Mal día devuelto como siguiente de " + fecha, 1, siguiente.getDía());
					assertEquals("Mal mes devuelto como siguiente de " + fecha, mes + 1, siguiente.getMes());
					assertEquals("Mal año devuelto como siguiente de " + fecha, año, siguiente.getAño());
				} else {
					assertEquals("Mal día devuelto como siguiente de " + fecha, 1, siguiente.getDía());
					assertEquals("Mal mes devuelto como siguiente de " + fecha, 1, siguiente.getMes());
					assertEquals("Mal año devuelto como siguiente de " + fecha, año + 1, siguiente.getAño());
				}
			}
				
		}
	}
	
	private void assertFechaEs(String prueba, Fecha fecha, Fecha referencia) {
		assertFechaEs(prueba, fecha, referencia.getDía(), referencia.getMes(), referencia.getAño());
	}
	
	private void assertFechaEs(String prueba, Fecha fecha, int día, int mes, int año) {
		assertEquals("No coincide el día en la prueba " + prueba, día, fecha.getDía());
		assertEquals("No coincide el mes en la prueba " + prueba, mes, fecha.getMes());
		assertEquals("No coincide el año en la prueba " + prueba, año, fecha.getAño());
	}

}
