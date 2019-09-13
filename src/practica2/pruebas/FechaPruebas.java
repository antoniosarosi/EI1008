package practica2.pruebas;

import practica2.ExcepcionFechaInvalida;
import practica2.Fecha;

public class FechaPruebas {

	public static void main(String[] args) throws ExcepcionFechaInvalida {

		System.out.println("Ejemplos de uso de fechas");
		System.out.println();

		// Comprobación de cambio de día
		Fecha lunes = new Fecha(23, 3, 2017);
		if (lunes.díaSiguiente().equals(new Fecha(24, 3, 2017)))
			System.out.println("El día siguiente al lunes es el martes. (BIEN)");
		else
			System.out.println("ERROR. Algo va mal al calcular el día siguiente de " + lunes);

		// Comprobación de cambio de mes (mes de 30 días)
		Fecha treintaAbril = new Fecha(30, 4, 2017);
		if (treintaAbril.díaSiguiente().equals(new Fecha(1, 5, 2017)))
			System.out.println("El día después del " + treintaAbril + " es el primero de mayo. (BIEN)");
		else
			System.out.println("ERROR. Algo va mal al calcular el día siguiente de " + treintaAbril);

		// Comprobación de cambio de mes (mes de 31 días)
		Fecha treintayunoOctubre = new Fecha(31, 10, 2017);
		if (treintayunoOctubre.díaSiguiente().equals(new Fecha(1, 11, 2017)))
			System.out.println("El día después del " + treintayunoOctubre + " es el uno de noviembre. (BIEN)");
		else
			System.out.println("ERROR. Algo va mal al calcular el día siguiente de " + treintayunoOctubre);

		// Comprobación de cambio de mes (febrero de año bisiesto)
		Fecha veintiochoFebrero2000 = new Fecha(28, 2, 2000);
		Fecha veintinueveFebrero2000 = new Fecha(29, 2, 2000);
		Fecha unoMarzo2000 = new Fecha(1, 3, 2000);

		if (veintiochoFebrero2000.díaSiguiente().equals(veintinueveFebrero2000))
			System.out.println("El día después del " + veintiochoFebrero2000 + " fue " + veintinueveFebrero2000 + ". (BIEN)");
		else
			System.out.println("ERROR. Algo va mal al calcular el día siguiente de " + veintiochoFebrero2000);
		if (veintinueveFebrero2000.díaSiguiente().equals(unoMarzo2000))
			System.out.println("El día después del " + veintinueveFebrero2000 + " fue " + unoMarzo2000 + ". (BIEN)");
		else
			System.out.println("ERROR. Algo va mal al calcular el día siguiente de " + veintinueveFebrero2000);
		System.out.println();

		// Comprobación de cambio de año
		Fecha finAño = new Fecha(31, 12, 2016);
		Fecha añoNuevo = new Fecha(1, 1, 2017);
		if (finAño.díaSiguiente().equals(añoNuevo))
			System.out.println("El día siguiente al fin de año es el primer día del nuevo año. (BIEN)");
		else
			System.out.println("ERROR. Algo va mal al calcular el día siguiente de " + finAño);

		// Comprobar comparación entre fechas con compareTo
		boolean hayError = false;
		if (añoNuevo.compareTo(finAño) > 0)
			System.out.println("El día " + añoNuevo + " es posterior al día " + finAño + ". (BIEN)");
		else
			hayError = true;
		if (finAño.compareTo(añoNuevo) < 0)
			System.out.println("El día " + finAño + " es anterior al día " + añoNuevo + ". (BIEN)");
		else
			hayError = true;
		if (finAño.díaSiguiente().compareTo(añoNuevo) == 0)
			System.out.println("El día siguiente al fin de año es el primer día del nuevo año. (BIEN)");
		else
			hayError = true;
		if (hayError)
			System.out.println("ERROR. Algo va mal al comparar fechas mediante compareTo");
		System.out.println();

		System.out.println("El año termina el día " + finAño.getDía() + " del mes " + finAño.getMes() + ".");
		System.out.println("El año comienza el día " + añoNuevo.getDía() + " del mes " + añoNuevo.getMes() + ".");
		System.out.println();

		// Comprobación de fechas inválidas (lanzar la excepción)
		try {
			Fecha fechaInvalida = new Fecha(2, 14, 2000);
			System.out.println("Fecha válida");
		}
		catch (ExcepcionFechaInvalida e) {
			System.out.println("La fecha no es válida");
		}
	}

}
